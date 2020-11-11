package Beans;

public class Tour {
    private int id;
    private String nombreTour;
    private String banda;

    public Tour(int id, String nombreTour, String banda) {
        this.id = id;
        this.nombreTour = nombreTour;
        this.banda = banda;
    }

    public int getId() {
        return id;
    }

    public String getNombreTour() {
        return nombreTour;
    }

    public String getBanda() {
        return banda;
    }
}
