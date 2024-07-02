public class Cachorro extends Animal{

    private int volumeLatido;


    public Cachorro(int id, String nome, String raca, int volumeLatido) {
        super(id, nome, raca);
        this.volumeLatido = volumeLatido;
    }

    @Override
    public void emitirSom() {
        System.out.println("au au au");
    }

    public int getVolumeLatido() {
        return volumeLatido;
    }

    public void setVolumeLatido(int volumeLatido) {
        this.volumeLatido = volumeLatido;
    }
}
