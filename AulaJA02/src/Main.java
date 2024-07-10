public class Main {
    public static void main(String[] args) throws Exception {
        Fila<Integer> fila = new Fila<>(5);

        fila.enqueue(1);
        fila.enqueue(5);

        System.out.println(fila);
    }
}
