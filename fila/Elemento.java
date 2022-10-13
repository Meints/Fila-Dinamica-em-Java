public class Elemento {
    public Cliente cli;
    public Elemento proximo;

    public Elemento(Cliente cli){
        this.cli = cli;
        this.proximo = null;
    }
}
