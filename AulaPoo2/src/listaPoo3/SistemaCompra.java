package listaPoo3;

import java.util.ArrayList;
import java.util.Scanner;

public class SistemaCompra {
    public static void main(String[] args) {
        ArrayList<Produto> lista = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        lista.add(new Produto("livro", 3, 25.2));
        lista.add(new Produto("caixa", 3, 10.5));
        lista.add(new Produto("sorvete", 3, 2.3));
        int q = 0;
        while (true) {
            int i = 1;
            if (q == 9) {
                System.out.println("Não há mais produtos");
                break;
            }
            System.out.println("Qual produto deseja comprar?");
            for (Produto p : lista) {
                if (p.getQuantidadeEstoque() > 0) {
                    p.exibirDetalhes();
                } else {
                    q++;
                }
                i++;
            }
            System.out.println("4 - Sair");
            int r = sc.nextInt();
            if (r == 4) {
                break;
            }
            lista.get(r-1).atualizarEstoque(lista.get(r-1).getQuantidadeEstoque()-1);
        }

    }
}
