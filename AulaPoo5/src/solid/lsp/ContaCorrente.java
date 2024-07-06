package solid.lsp;

import solid.lsp.Conta;

public class ContaCorrente extends Conta {
    @Override
    public double rendimentoAplicacao() {
        return saldo*1.01;
    }
}
