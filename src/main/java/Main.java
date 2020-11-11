import Beans.Banda;
import Daos.BandaDao;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Banda> bandas = BandaDao.obtenerListaBandas("y");
        for (Banda banda: bandas){
            System.out.println(banda.getIdBanda());
            System.out.println(banda.getNombre_banda());
            System.out.println(banda.getIdlider());
            System.out.println("-------");
        }
    }
}
