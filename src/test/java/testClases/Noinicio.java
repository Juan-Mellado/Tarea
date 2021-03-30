package testClases;

import Utils.ReadProperties;
import Utils.Reporte.EstadoPrueba;
import Utils.Reporte.PdfQaNovaReports;
import page.Index;
import page.NoInicia;

public class Noinicio {
    public void noInicia(){
        String msgAux = ReadProperties.readFromConfig("propiedades.properties").getProperty("msgAux");
        Index index = new Index();
        index.cargaIndex();
        String usuarioError=ReadProperties.readFromConfig("propiedades.properties").getProperty("usuarioError");
        String keyError=ReadProperties.readFromConfig("propiedades.properties").getProperty("keyError");
        index.inicio(usuarioError,keyError);
        PdfQaNovaReports.addWebReportImage("login","Se ingreso [Nombre del Usuario], [Contraseña] incorrectos y se preciono Botón \"Ingresar a Demo\" ", EstadoPrueba.PASSED,false);
        index.prisionaBtnDemo();
        NoInicia noinicia = new NoInicia();
        noinicia.mensageError(msgAux);

    }
}
