package listaPoo3;

public class Produto {
    private String nome;
    private int quantidadeEstoque;
    private double preco;

    public Produto(String nome, int quantidadeEstoque, double preco) {
        this.nome = nome;
        this.quantidadeEstoque = quantidadeEstoque;
        this.preco = preco;
    }

    public void atualizarEstoque(int n) {
        this.quantidadeEstoque = n;
    }

    public void exibirDetalhes() {
        System.out.println("Nome: "+this.nome+". Quantidade em estoque: "+this.quantidadeEstoque+". Preço: "+this.preco);
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public double getPreco() {
        return preco;
    }
}
