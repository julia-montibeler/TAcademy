package solid.ocp;

import solid.ocp.Desconto;
import solid.ocp.Pedido;

public class DescontoIdoso implements Desconto {
    @Override
    public double calcularDesconto(Pedido p) {
        return p.getValor()*0.8;
    }
}
