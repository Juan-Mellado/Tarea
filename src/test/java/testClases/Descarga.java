package testClases;

import Utils.ReadProperties;
import page.TheInternet;

public class Descarga {
    public void descarga() throws InterruptedException {
        String archivo= ReadProperties.readFromConfig("propiedades.properties").getProperty("nombreArchivo");
        TheInternet theInternet = new TheInternet();
        theInternet.descarga(archivo);
    }
}
