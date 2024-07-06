package solid.srp;

import java.util.ArrayList;

public class Relatorio {
    private ArrayList<String> vendas = new ArrayList<>();

    public String gerarRelatorio() {
        String relatorio = "";
        for (String v : vendas) {
            relatorio += v + " ";
        }
        return relatorio;
    }

    public void imprimirRelatorio() {
        System.out.println(gerarRelatorio());
    }
}
