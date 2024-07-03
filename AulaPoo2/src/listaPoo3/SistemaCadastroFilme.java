package listaPoo3;

import java.util.ArrayList;
import java.util.Scanner;

public class SistemaCadastroFilme {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Filme> filmes = new ArrayList<>();
        while (true) {
            System.out.println("Digite o nome do filme a ser cadastrado (digite C para sair): ");
            String nome = sc.nextLine();
            if (nome.equalsIgnoreCase("c")) {
                break;
            }
            filmes.add(new Filme(nome));
        }
        for (Filme f: filmes) {
            f.mostrarDetalhes();
        }




    }
}
