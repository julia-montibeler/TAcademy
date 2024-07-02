public class Gato extends Animal{
    private double alturaPulo;

    public Gato(){}

    public Gato(double alturaPulo) {
        this.alturaPulo = alturaPulo;
    }

    public Gato(int id, String nome, String raca, double alturaPulo) {
        super(id, nome, raca);
        this.alturaPulo = alturaPulo;
    }

    public double getAlturaPulo() {
        return alturaPulo;
    }

    public void setAlturaPulo(double alturaPulo) {
        this.alturaPulo = alturaPulo;
    }

    public void fazerAcao() {
        System.out.println("Gato fez algo");
    }

    public void fazerAcao(String comida) {
        System.out.println("O gato comeu: "+comida);
    }

    public void fazerAcao(int qtdArranhoes) {
        System.out.println("O gato te arranhou "+qtdArranhoes+" vezes");
    }
}
