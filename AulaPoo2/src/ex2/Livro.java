package ex2;

public class Livro extends Produto{
    private String genero;
    private String autor;
    public Livro(String nome, double preco, String genero, String autor) {
        super(nome, preco);
        this.autor = autor;
        this.genero = genero;
    }
}
