public class Animal {
    protected int id;
    protected String nome;
    protected String raca;

    public Animal(){}
    public Animal(int id, String nome, String raca) {
        this.id = id;
        this.nome = nome;
        this.raca = raca;
    }

    public void emitirSom() {
        System.out.println("som");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
