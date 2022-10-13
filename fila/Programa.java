import java.time.LocalDateTime;
public class Programa {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("carlao", LocalDateTime.of(2022, 10, 12, 10, 00, 0));
        Cliente cliente2 = new Cliente("jose", LocalDateTime.of(2022, 10, 12, 10, 10, 0));
        Cliente cliente3 = new Cliente("lincoln", LocalDateTime.of(2022, 10, 12, 10, 15, 0));
        Cliente cliente4 = new Cliente("pedro cabeca de ovo", LocalDateTime.of(2022, 10, 12, 10, 50, 0));
        Fila fila = new Fila();
        fila.enfileirar(cliente1);
        fila.enfileirar(cliente2);
        fila.enfileirar(cliente3);
        fila.enfileirar(cliente4);
        System.out.println(fila.obterPrimero().nome);
        //  System.out.println(fila.obterNumeroClientes());
        // fila.imprimir();


        //Fila filaPar = fila.dividir();
        //filaPar.imprimir();
        //System.out.println("teste");
        //fila.imprimir();

        // System.out.println(fila.verificarExistencia("frederico"));
        // System.out.println(fila.obterNumClientesAFrente("pedro cabeca de ovo"));

        // Fila filaCopiada = fila.copiar();
        // filaCopiada.imprimir();

        // System.out.println(fila.obterTempoMedioEspera(LocalDateTime.of(2022, 10, 12, 11, 00, 0)) + " minutos");
        // System.out.println(fila.obterNumClientesEsperando(LocalDateTime.of(2022, 10, 12, 11, 00, 0)) + " pessoas");
    }
}
