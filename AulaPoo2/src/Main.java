import ex11.Aluno;
import ex8.Jogador;

public class Main {
    public static void main(String[] args) {
        Quadrado q = new Quadrado(10, "Vermelho");
        System.out.println(q.getArea()+"m²");

        Jogador j = new Jogador("joao", "atacante", 2000, "a", 2.1, 60);
        j.imprimeDados();
    }
}
