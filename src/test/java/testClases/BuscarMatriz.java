package testClases;
import Utils.ReadProperties;
import page.CargaInformacion;
import page.Index;
import page.MatrizInformacion;

public class BuscarMatriz {

    public void recoleccionDatos(){
        String buscar= ReadProperties.readFromConfig("propiedades.properties").getProperty("filtro");
        String usuario= ReadProperties.readFromConfig("propiedades.properties").getProperty("usuario");
        String key = ReadProperties.readFromConfig("propiedades.properties").getProperty("key");
        MatrizInformacion matriz = new MatrizInformacion();
        Index inicio=new Index();
        CargaInformacion cargarInformacion = new CargaInformacion();
        inicio.inicio(usuario,key);
        cargarInformacion.pbCargaInformacion();
        matriz.bucarInformacion(buscar);
    }

}
