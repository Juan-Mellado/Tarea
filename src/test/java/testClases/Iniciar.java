package testClases;
import Utils.DriverContext;
import Utils.ReadProperties;
import Utils.Reporte.EstadoPrueba;
import Utils.Reporte.PdfQaNovaReports;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import page.CargaInformacion;
import page.Index;
import page.NoInicia;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Iniciar {
    //Inicia sesion con las propiedades entregadas
    public void inicio(){
        String usuario= ReadProperties.readFromConfig("propiedades.properties").getProperty("usuario");
        String key = ReadProperties.readFromConfig("propiedades.properties").getProperty("key");
        Index index = new Index();
        index.cargaIndex();
        index.inicio(usuario,key);
        PdfQaNovaReports.addWebReportImage("login","Se ingreso [Nombre del Usuario], [Contraseña] y se preciono Botón \"Ingresar a Demo\" ", EstadoPrueba.PASSED,false);
        index.prisionaBtnDemo();
        CargaInformacion cargaInformacion =new CargaInformacion();
        cargaInformacion.cargaCargaInformacion();
    }
    //Iniciar sesion desde una pila json
    public void iniciarPila() throws IOException {
        String datos="";
        String comparacion;
        BufferedReader br = new BufferedReader(new FileReader("C:\\tareas\\Tareas\\src\\test\\java\\Json\\usuarios.json"));
        while((comparacion = br.readLine()) != null){
            datos = datos+comparacion+"\n";
        }
        br.close();
        JsonObject jsonObject = new Gson().fromJson(datos,JsonObject.class);
        JsonArray jsonUsuarios = jsonObject.getAsJsonArray("usuario");
        String url = ReadProperties.readFromConfig("propiedades.properties").getProperty("url");
        JsonObject jsonArreglo;
        Index index =new Index();
        NoInicia noInicia =new NoInicia();
        CargaInformacion cargaInformacion =new CargaInformacion();
        String usuario;
        String clave;
        for(int i=0;i<jsonUsuarios.size();i++){
            jsonArreglo = (JsonObject) jsonUsuarios.get(i);
            usuario = jsonArreglo.get("nombre").getAsString();
            clave = jsonArreglo.get("clave").getAsString();
            index.inicio(usuario,clave);
            index.prisionaBtnDemo();
            noInicia.mensageError(ReadProperties.readFromConfig("propiedades.properties").getProperty("msgAux"));
            cargaInformacion.cargaCargaInformacion();
            System.out.println("\nInicio de sesion: \n"+"Nombre: "+jsonArreglo.get("nombre").getAsString()+"\n"+"Clave: "+jsonArreglo.get("clave").getAsString()+"\n");
            DriverContext.getDriver().navigate().to(url);
        }
    }
}
