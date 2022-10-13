import java.time.LocalDateTime;
public class Cliente{
    String nome;
    LocalDateTime horarioChegada;

    public Cliente(String nomeCliente, LocalDateTime hora){
            this.nome = nomeCliente;
            this.horarioChegada = hora;
    }
}