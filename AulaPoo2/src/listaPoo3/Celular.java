package listaPoo3;

public class Celular {
    private String marca;
    private String modelo;
    private int armazenamento = 0;
    private String[] aplicativos;

    public Celular(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
        aplicativos = new String[10];
    }

    public void instalarAplicativo(String app) {
        if (armazenamento == 9) {
            System.out.println("Sem espaço");
        }
        aplicativos[armazenamento] = app;
        armazenamento++;
    }
}
