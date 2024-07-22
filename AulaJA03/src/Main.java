import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> lista = new ArrayList<>();
        for (int i = 0; i <= 10; i+=2){
            lista.add(i);
        }

        ArrayList<String> listaString = new ArrayList<>();
        listaString.add("Julia");
        listaString.add("Ana");
        listaString.add("William");

        //ex1
        List<Integer> pares = lista.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());

        //ex2
        List<Integer> dobro = lista.stream()
                .map(n -> n * 2)
                .collect(Collectors.toList());


        //ex3
        boolean maiores = lista.stream()
                .allMatch(n -> n > 10);


        //ex4
        Integer maior = lista.stream().max(Integer::compare).get();

        //ex5
        listaString.stream()
                .map(s -> s.toUpperCase());

        //ex6
        listaString.stream().sorted();

        //ex7
        ArrayList<Pessoa> pessoas = new ArrayList<>();
        HashMap<String, ArrayList<Pessoa>> grupos = pessoas.stream()
                .collect(Collectors.groupingBy(
                        pessoa -> {
                            int idade = pessoa.getIdade();
                            if (idade <= 18) {
                                return "Criança";
                            } else if (idade <= 60) {
                                return "Adulto";
                            } else {
                                return "Idoso";
                            }
                        },
                        HashMap::new,
                        Collectors.toCollection(ArrayList::new)));

        //ex8
        Double media = lista.stream().collect(Collectors
                .averagingDouble(n -> n));

        //ex9
        lista.stream().distinct();

        //ex10
        ArrayList<Integer> lista2 = new ArrayList<>();
        for (int i = 1; i <= 11; i+=2){
            lista2.add(i);
        }

        List<Integer> listasCombinadas = lista.stream()
                .flatMap(i -> Arrays.asList(i, lista2.get(lista.indexOf(i))).stream())
                .collect(Collectors.toList());

        listasCombinadas.forEach(n -> System.out.println(n));


        List<Integer> listaCombinada = IntStream.range(0, lista.size())
                .boxed()
                .flatMap(i -> Arrays.asList(lista.get(i), lista2.get(i)).stream())
                .collect(Collectors.toList());
    }
}