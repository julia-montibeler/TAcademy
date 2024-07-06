package solid.ocp;

import solid.ocp.Desconto;
import solid.ocp.Pedido;

public class DescontoEstudante implements Desconto {
    @Override
    public double calcularDesconto(Pedido p) {
        return p.getValor()*0.9;
    }
}
