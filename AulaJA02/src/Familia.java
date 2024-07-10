import java.util.ArrayList;

public class Familia<T>{
    private ArrayList<T> membros;

    public Familia() {
        membros = new ArrayList<>();
    }

    public void adicionarMembro(T membro) {
        membros.add(membro);
    }

    public void removerMembro(T membro) {
        membros.remove(membro);
    }

    public void imprimirMembros() {
        for(T membro : membros) {
            System.out.println(membro);
        }
    }
}
