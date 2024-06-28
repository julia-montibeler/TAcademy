public class Quadrado {
    private double lado;
    private double area;
    private String cor;

    public Quadrado(double lado, String cor) {
        this.lado = lado;
        this.cor = cor;
    }

    public double getArea() {
        return Math.pow(this.getLado(), 2);
    }

    public double getLado() {
        return this.lado;
    }

    public void setLado(double lado) {
        this.lado = lado;
    }

    public String getCor() {
        return this.cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }
}
