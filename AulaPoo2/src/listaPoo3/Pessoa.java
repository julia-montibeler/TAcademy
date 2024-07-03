package listaPoo3;

public class Pessoa {
    private String nome;
    private int idade;
    private double altura;
    private double peso;

    public Pessoa(String nome, int idade, double altura, double peso) {
        this.nome = nome;
        this.idade = idade;
        this.altura = altura;
        this.peso = peso;
    }

    public void engordar() {
        peso++;
    }

    public void emagrecer() {
        peso--;
    }

    public void envelhecer() {
        idade++;
    }

    public void mostrarInformacoes() {
        System.out.println("Nome: "+this.nome+"\nIdade: "+this.idade+"\nAltura: "+this.altura+"\nPeso: "+this.peso);
    }

}
