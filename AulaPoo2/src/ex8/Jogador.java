package ex8;

public class Jogador {
    private String nome;
    private String posicao;
    private int ano;
    private String nacionalidade;
    private double altura;
    private double peso;

    public Jogador(String nome, String posicao, int ano, String nacionalidade, double altura, double peso) {
        this.setNome(nome);
        this.setPosicao(posicao);
        this.setAno(ano);
        this.setNacionalidade(nacionalidade);
        this.setAltura(altura);
        this.setPeso(peso);
    }
    public void imprimeDados() {
        System.out.println("Nome: "+this.getNome());
        System.out.println("Posição: "+this.getPosicao());
        System.out.println("Data de nascimento: "+this.getAno());
        System.out.println("Nacionalidade: "+this.getNacionalidade());
        System.out.println("Altura: "+this.getAltura());
        System.out.println("Peso: "+this.getPeso());
    }

    public int tempoAposentadoria() {
        int dif = 2024 - this.getAno();
        if (this.getPosicao().equalsIgnoreCase("defesa")) {
            return 40-dif;
        } else if (this.getPosicao().equalsIgnoreCase("meio-campo")) {
            return 38-dif;
        } else if (this.getPosicao().equalsIgnoreCase("atacante")) {
            return 35-dif;
        }
        return 0;
    }

    //getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
}
