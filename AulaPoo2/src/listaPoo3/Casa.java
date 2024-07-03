package listaPoo3;

public class Casa {
    private String endereco;
    private int numQuartos;
    private double area;
    private double valor;

    public Casa(String endereco, int numQuartos, double area, double valor) {
        this.endereco = endereco;
        this.numQuartos = numQuartos;
        this.area = area;
        this.valor = valor;
    }

    public double calcularValorImposto() {
        return 5000*area + 1000*numQuartos + 0.02*valor;
    }

    public void exibirDetalhes() {
        System.out.println("Endereco: "+this.endereco+". Quantidade de quartos: "+this.numQuartos+". Valor: "+this.valor+". Área: "+this.area);
    }
}
