package solid.lsp;

import solid.lsp.Conta;

public class ContaPoupanca extends Conta {
    @Override
    public double rendimentoAplicacao() {
        return saldo*1.05;
    }
}
