import java.util.ArrayList;
import java.util.HashMap;

public class Rede<T> {
    private ArrayList<T> dispositivos;
    private HashMap<T,T> conexoes;

    public Rede() {
        dispositivos = new ArrayList<>();
        conexoes = new HashMap<>();
    }

    public void dispositivosNaRede() {
        dispositivos.forEach(d -> System.out.println(d.toString()));
    }

    public void adicionarDispositivo(T dispositivo) {
        dispositivos.add(dispositivo);
    }

    public void removerDispositivo(T dispositivo) {
        dispositivos.remove(dispositivo);
    }

    public void conectarDispositivos(T d1, T d2) {
        conexoes.put(d1,d2);
    }

}
