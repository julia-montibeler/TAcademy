package solid.dip;

import solid.dip.Pagamento;

public class PagamentoCredito implements Pagamento {
    @Override
    public void realizarPagamento() {
        System.out.println("Pagamento com cartão de crédito");
    }
}
