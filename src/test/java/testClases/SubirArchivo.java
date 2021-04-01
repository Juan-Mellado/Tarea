package testClases;
import Utils.ReadProperties;
import page.CargaArchivo;
import page.CargaInformacion;
import page.Index;
public class SubirArchivo {
    //inicia sesion en la pagina y sube un archivo
    public void enviarArchivo(){
        String usuario = ReadProperties.readFromConfig("propiedades.properties").getProperty("usuario");
        String key = ReadProperties.readFromConfig("propiedades.properties").getProperty("key");
        String archivo = ReadProperties.readFromConfig("propiedades.properties").getProperty("archivo");
        CargaArchivo cargaArchivo = new CargaArchivo();
        Index index = new Index();
        CargaInformacion cargaInformacion = new CargaInformacion();
        index.inicio(usuario,key);
        cargaInformacion.pbCargaArchivo();
        cargaArchivo.ingresarArchivo(archivo);
        cargaArchivo.clickEnviar();
    }
}
