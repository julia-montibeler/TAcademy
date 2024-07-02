import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<SerVivo> seresVivos = new ArrayList<>();
        Mamifero vaca = new Mamifero("vaca", "??", "??", "??");
        Gimnosperma arvore = new Gimnosperma("arvore", "??", "??", "??");
        seresVivos.add(vaca);
        seresVivos.add(arvore);
        vaca.print();
    }
}
