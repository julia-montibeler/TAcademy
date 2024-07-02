package exercicios;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Aluno> alunos= new ArrayList<>();
        while (true) {
            System.out.println("1 - Novo aluno \n 2 - Ver alunos \n 3 - Sair");
            int op = sc.nextInt();

            if (op == 1) {
                System.out.println("Digite o nome do aluno: ");
                String nome = sc.next();

                System.out.println("Digite o cpf do aluno: ");
                String cpf = sc.next();

                System.out.println("Digite a idade do aluno: ");
                int idade = sc.nextInt();

                alunos.add(new Aluno(nome, cpf, idade));
            }
            if (op == 2) {
                for (Aluno a : alunos) {
                    System.out.println(a.nome);
                }
            }
            if (op == 3 ) {
                break;
            }
        }

    }

}
