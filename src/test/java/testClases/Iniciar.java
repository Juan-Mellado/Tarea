package testClases;
import Utils.ReadProperties;
import page.CargaInformacion;
import page.Index;

public class Iniciar {

    Index index;
    String usuario= ReadProperties.readFromConfig("propiedades.properties").getProperty("usuario");
    String key = ReadProperties.readFromConfig("propiedades.properties").getProperty("key");
    public void inicio() {
        index = new Index();
        index.inicio(usuario,key);
    }
    public void noInicia(){
        String msgAux = "Nombre y/o password incorrecto";
        index = new Index();
        index.noInicia(msgAux);
    }
    public void llenadoCampos(){
        String texto=ReadProperties.readFromConfig("propiedades.properties").getProperty("texto");
        String email=ReadProperties.readFromConfig("propiedades.properties").getProperty("email");
        String area=ReadProperties.readFromConfig("propiedades.properties").getProperty("area");
        String fecha=ReadProperties.readFromConfig("propiedades.properties").getProperty("fecha");
        String lista= ReadProperties.readFromConfig("propiedades.properties").getProperty("lista");
        boolean sMultiple0 = Boolean.parseBoolean(ReadProperties.readFromConfig("propiedades.properties").getProperty("sMultiple0"));
        boolean sMultiple1 = Boolean.parseBoolean(ReadProperties.readFromConfig("propiedades.properties").getProperty("sMultiple1"));
        boolean sMultiple2 = Boolean.parseBoolean(ReadProperties.readFromConfig("propiedades.properties").getProperty("sMultiple2"));
        String rButton = ReadProperties.readFromConfig("propiedades.properties").getProperty("rButton");
        index = new Index();
        index.inicio(usuario,key);
        CargaInformacion cargaInformacion = new CargaInformacion();
        cargaInformacion.llenarCampos(texto,email,area,fecha,lista,sMultiple0,sMultiple1,sMultiple2,rButton);
    }

}
