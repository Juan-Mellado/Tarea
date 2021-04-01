package testClases;
import Utils.ReadProperties;
import page.TheInternet;
public class Descarga {
    //Descarga un archivo
    public void descarga() throws InterruptedException {
        String archivo= ReadProperties.readFromConfig("propiedades.properties").getProperty("nombreArchivo");
        TheInternet theInternet = new TheInternet();
        theInternet.descarga(archivo);
    }
}
