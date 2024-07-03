package listaPoo3;

public class Filme {
    private String nome;

    public Filme(String nome) {
        this.nome = nome;
    }

    public void mostrarDetalhes() {
        System.out.println("Nome: "+this.nome);
    }
}
