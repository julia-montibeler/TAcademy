package solid.dip;

import solid.dip.Pagamento;

public class PagamentoPayPal implements Pagamento {
    @Override
    public void realizarPagamento() {
        System.out.println("Pagamento com paypal");
    }
}
