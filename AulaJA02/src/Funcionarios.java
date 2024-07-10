import java.util.ArrayList;

public class Funcionarios<T> {
    private ArrayList<T> funcionarios;

    public Funcionarios() {
        funcionarios = new ArrayList<>();
    }

    public void contratar(T funcionario) {
        funcionarios.add(funcionario);
    }

    public void demitir(T funcionario) {
        funcionarios.remove(funcionario);
    }

    public void imprimirFuncionarios() {
        for(T f : funcionarios) {
            System.out.println(f);
        }
    }

    public int quantidadeFuncionarios() {
        return funcionarios.size();
    }

}
