package solid.lsp;

public class Conta {
    private int id;
    private String titular;
    protected double saldo;

    public double rendimentoAplicacao() {
        return saldo*1.02;
    }
}
