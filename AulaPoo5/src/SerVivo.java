public abstract class SerVivo {
    private String nomeCientifico;
    private String reino;
    private String filo;
    private String classe;
    private String ordem;
    private String familia;
    private String genero;

    public SerVivo(String nomeCientifico, String reino, String filo, String classe, String ordem, String familia, String genero) {
        this.nomeCientifico = nomeCientifico;
        this.reino = reino;
        this.filo = filo;
        this.classe = classe;
        this.ordem = ordem;
        this.familia = familia;
        this.genero = genero;
    }

    public void print() {
        System.out.println(this.nomeCientifico);
        System.out.println(this.reino);
        System.out.println(this.filo);
        System.out.println(this.classe);
        System.out.println(this.ordem);
        System.out.println(this.familia);
        System.out.println(this.genero);
    }

}
