import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Fila {
    private Elemento primeiro;
    private Elemento ultimo;
    public Fila(){
        primeiro = new Elemento(null);
        ultimo = primeiro;
    }

    public Boolean filaVazia(){
        if (primeiro == ultimo) {
            return true;
        }
            return false;
    }

    public void enfileirar(Cliente cli){
        Elemento novo = new Elemento(cli);
        ultimo.proximo = novo;
        ultimo = novo;

    }

    public Cliente desinfileirar(){
        if (filaVazia()) {
            return null;
        }
        Elemento aux = primeiro.proximo;
        primeiro.proximo = aux.proximo;
        if (aux == ultimo) {
            ultimo = primeiro;
        }
        else{
            aux.proximo = null;
        }
        return aux.cli;
    }

    public Cliente obterPrimero(){
        if (filaVazia()) {
            return null;
        }
        return primeiro.proximo.cli;
    }

    public int obterNumeroClientes(){
        int cont = 0;
        Elemento aux = primeiro.proximo;
        while (aux != ultimo.proximo) {
            cont++;
            aux = aux.proximo;
        }
        return cont;
    }

    public void imprimir(){
        Elemento aux = primeiro.proximo;
        while (aux != ultimo.proximo) {
            System.out.println(aux.cli.nome);
            aux = aux.proximo;
        }
    }

    public Fila dividir(){
        Fila filaPar = new Fila();
        Fila filaImpar = new Fila();
        int cont = 1;
        Elemento aux = primeiro.proximo;
        while (aux != ultimo.proximo) {
            if (cont % 2 == 0) {
                filaPar.enfileirar(aux.cli);
                
            }
            else{
                filaImpar.enfileirar(aux.cli);
            }
            cont++;
            aux = aux.proximo;
        }
        primeiro.proximo = filaImpar.primeiro.proximo;
        return filaPar;
    }

    public Boolean verificarExistencia(String nomeCliente){
        Elemento aux = primeiro.proximo;
        while (aux != ultimo.proximo) {
            if (aux.cli.nome == nomeCliente) {
                return true;
            }
            aux = aux.proximo;
        }
        return false;
    }

    public int obterNumClientesAFrente(String nomeCliente){
        int cont = 0;
        Elemento aux = primeiro.proximo;
        while (aux != ultimo.proximo) {
            if (aux.cli.nome == nomeCliente) {
                return cont;
            }
            cont++;
            aux = aux.proximo;
        }
        return -1;
    }

    public Fila copiar(){
        Fila filaCopiada = new Fila();
        Elemento aux = primeiro.proximo;
        while (aux != ultimo.proximo) {
            filaCopiada.enfileirar(aux.cli);
            aux = aux.proximo;
        }
        return filaCopiada;
    }

    public double obterTempoMedioEspera(LocalDateTime horarioAtual){
        int quant = obterNumeroClientes();
        double somaDeTempo = 0;
        Elemento aux = primeiro.proximo;
        while (aux != ultimo.proximo) {
          double tempoEsperado = ChronoUnit.MINUTES.between(aux.cli.horarioChegada, horarioAtual);
          somaDeTempo += tempoEsperado;
          aux = aux.proximo;
        }
        return (somaDeTempo/quant);
    }

    public int obterNumClientesEsperando(LocalDateTime horarioAtual){
        int quant = 0;
        Elemento aux = primeiro.proximo;
        while (aux != ultimo.proximo) {
            double tempoEsperado = ChronoUnit.MINUTES.between(aux.cli.horarioChegada, horarioAtual);
            if (tempoEsperado > 15) {
                quant++;
            }
            aux = aux.proximo;
        }
          return quant;
    }
}

/*10) Implemente, em Java, a função public int obterNumClientesEsperando(DateTime horarioAtual), capaz
de calcular e retornar o número de clientes que estão esperando na fila por, pelo menos, 15 minutos. */