import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static Map<String, Aluno> alunos = new HashMap<>();

    public static void main(String[] args) {
        String nome = "Julia";
        alunos.put(nome, new Aluno(nome, 9));
        nome = "João";
        alunos.put(nome, new Aluno(nome, 6));
        nome = "Arthur";
        alunos.put(nome, new Aluno(nome, 7));
        nome = "Joana";
        alunos.put(nome, new Aluno(nome, 4));
        nome = "William";
        alunos.put(nome, new Aluno(nome, 9));

        System.out.println("HashMap original");
        alunos.entrySet()
                .forEach(System.out::println);

        System.out.println("\nMétodo mostrar nota");
        mostrarNota("Julia");

        System.out.println("\nAlunos com nota maior do que 7");
        ArrayList<String> alunosNotaMaior = notaMaior(7);
        for (String s : alunosNotaMaior) {
            System.out.println(s);
        }

        System.out.println("\nAlunos com nota menor do que 7");
        ArrayList<String> alunosNotaMenor = removerAlunosNotaMenor(7);
        for (String s : alunosNotaMenor) {
            System.out.println(s);
        }

        System.out.println("\nHashmap depois de remover os alunos com nota menor do que 7");
        alunos.entrySet()
                .forEach(System.out::println);

        System.out.println("\nAlunos ordenados por nota");
        HashMap<String, Aluno> alunosOrdenados = ordernarNota();
        alunosOrdenados.entrySet()
                .forEach(System.out::println);

        System.out.println("\nAlunados agrupados por nota");
        HashMap<String, ArrayList<Aluno>> alunosAgrupados = agruparNota();
        alunosAgrupados.entrySet()
                .forEach(System.out::println);
    }

    public static void mostrarNota(String nome) {
        Aluno aluno = alunos.get(nome);
        if (aluno != null) {
            System.out.println("A nota de " + nome + " é: " + aluno.getNota());
        } else {
            System.out.println("Aluno não encontrado.");
        }
    }

    public static ArrayList<String> notaMaior(double notaCorte) {
        return alunos.values().stream()
                .filter(aluno -> aluno.getNota() > notaCorte)
                .map(Aluno::getNome)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public static ArrayList<String> removerAlunosNotaMenor (double notaCorte) {
        ArrayList<String> alunosRemovidos = alunos.entrySet().stream()
                .filter(entry -> entry.getValue().getNota() < notaCorte)
                .map(Map.Entry::getKey)
                .collect(Collectors.toCollection(ArrayList::new));

        alunosRemovidos.forEach(alunos::remove);

        //Exemplo da aula
        ArrayList<String> alunosRemovidosCorrecao = new ArrayList<>();

        alunos.values().removeIf(aluno -> {
            if (aluno.getNota() > notaCorte) {
                alunosRemovidosCorrecao.add(aluno.getNome());
                return true;
            }
            return false;
        });
        //Fim exemplo da aula

        return alunosRemovidos;
    }

    public static HashMap<String, Aluno> ordernarNota() {
        return alunos.entrySet().stream()
                .sorted((a1, a2) -> Double.compare(a2.getValue().getNota(), a1.getValue().getNota()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a1, a2) -> a1,
                        LinkedHashMap::new
                ));
    }

    public static HashMap<String, ArrayList<Aluno>> agruparNota() {
        return alunos.values().stream()
                .collect(Collectors.groupingBy(
                        aluno -> {
                            double nota = aluno.getNota();
                            if (nota >= 9) {
                                return "A";
                            } else if (nota >= 8) {
                                return "B";
                            } else if (nota >= 7) {
                                return "C";
                            } else if (nota >= 6) {
                                return "D";
                            } else {
                                return "F";
                            }
                        },
                        HashMap::new,
                        Collectors.toCollection(ArrayList::new)
                ));
    }
}
