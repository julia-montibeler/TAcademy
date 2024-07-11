import java.util.ArrayList;

public class Personagens<T> {
    private ArrayList<T> ajudantes;
    private ArrayList<T> superHerois;
    private ArrayList<T> viloes;

    public Personagens() {
        ajudantes = new ArrayList<>();
        superHerois = new ArrayList<>();
        viloes = new ArrayList<>();
    }

    public void mostrarAjudantes() {
        ajudantes.forEach(a -> System.out.println(a));
    }

    public void mostrarSuperHerois() {
        superHerois.forEach(s -> System.out.println(s));
    }

    public void mostrarViloes() {
        viloes.forEach(v -> System.out.println(v));
    }
}
