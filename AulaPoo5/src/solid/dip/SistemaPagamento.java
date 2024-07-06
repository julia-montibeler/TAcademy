package solid.dip;

import solid.dip.Pagamento;

public class SistemaPagamento {

    public void fecharPedido(Pagamento p) {
        p.realizarPagamento();
    }
}
