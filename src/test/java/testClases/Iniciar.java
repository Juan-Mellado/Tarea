package testClases;
import Utils.ReadProperties;
import Utils.Reporte.EstadoPrueba;
import Utils.Reporte.PdfQaNovaReports;
import page.CargaInformacion;
import page.Index;
public class Iniciar {
    //Inicia sesion con las propiedades entregadas
    public void inicio() {
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
}
