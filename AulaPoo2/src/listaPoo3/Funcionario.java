package listaPoo3;

public class Funcionario {
    private String cargo;
    private String nome;
    private String departamento;
    private double salario;

    public Funcionario(String cargo, String nome, String departamento, double salario) {
        this.cargo = cargo;
        this.nome = nome;
        this.departamento = departamento;
        this.salario = salario;
    }

    public void promover(String novoCargo) {
        this.cargo = novoCargo;
    }

    public void exibirDetalhes() {
        System.out.println("Nome: "+this.nome+". Cargo: "+this.cargo+". Departamento: "+this.departamento+". Salário: "+this.salario);
    }
}
