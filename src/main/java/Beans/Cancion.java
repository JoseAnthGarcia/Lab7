package Beans;

public class Cancion {

    private int idCancion;
    private String nombreCancion;
    private String banda;

    public Cancion(int idCancion, String nombreCancion, String banda) {
        this.idCancion = idCancion;
        this.nombreCancion = nombreCancion;
        this.banda = banda;
    }

    public int getIdCancion() {
        return idCancion;
    }

    public String getNombreCancion() {
        return nombreCancion;
    }

    public String getBanda() {
        return banda;
    }
}
