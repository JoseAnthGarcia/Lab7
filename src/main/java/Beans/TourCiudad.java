package Beans;

import java.sql.Date;

public class TourCiudad {

    private String tourName;
    private String ciudad;
    private Date fecha;

    public TourCiudad(String tourName, String ciudad, Date fecha) {
        this.tourName = tourName;
        this.ciudad = ciudad;
        this.fecha = fecha;
    }

    public String getTourName() {
        return tourName;
    }

    public String getCiudad() {
        return ciudad;
    }

    public Date getFecha() {
        return fecha;
    }
}
