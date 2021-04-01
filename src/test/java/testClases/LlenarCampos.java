package testClases;
import Utils.ReadProperties;
import Utils.Reporte.EstadoPrueba;
import Utils.Reporte.PdfQaNovaReports;
import page.CargaInformacion;
import page.Index;
import page.MatrizInformacion;
public class LlenarCampos {
    //Llena todos los campos de la tabla y los carga en la matris de informacion
    public void llenadoCampos(){
        String usuario= ReadProperties.readFromConfig("propiedades.properties").getProperty("usuario");
        String key = ReadProperties.readFromConfig("propiedades.properties").getProperty("key");
        String texto= ReadProperties.readFromConfig("propiedades.properties").getProperty("texto");
        String email=ReadProperties.readFromConfig("propiedades.properties").getProperty("email");
        String area=ReadProperties.readFromConfig("propiedades.properties").getProperty("area");
        String fecha=ReadProperties.readFromConfig("propiedades.properties").getProperty("fecha");
        String lista= ReadProperties.readFromConfig("propiedades.properties").getProperty("lista");
        boolean sMultiple0 = Boolean.parseBoolean(ReadProperties.readFromConfig("propiedades.properties").getProperty("sMultiple0"));
        boolean sMultiple1 = Boolean.parseBoolean(ReadProperties.readFromConfig("propiedades.properties").getProperty("sMultiple1"));
        boolean sMultiple2 = Boolean.parseBoolean(ReadProperties.readFromConfig("propiedades.properties").getProperty("sMultiple2"));
        String rButton = ReadProperties.readFromConfig("propiedades.properties").getProperty("rButton");
        Index index = new Index();
        index.cargaIndex();
        index.inicio(usuario,key);
        PdfQaNovaReports.addWebReportImage("login","Se ingreso [Nombre del Usuario], [Contraseña] y se preciono Botón \"Ingresar a Demo\" ", EstadoPrueba.PASSED,false);
        index.prisionaBtnDemo();
        CargaInformacion cargaInformacion = new CargaInformacion();
        cargaInformacion.cargaCargaInformacion();
        cargaInformacion.llenarCampos(texto,email,area,lista,sMultiple0,sMultiple1,sMultiple2,rButton);
        cargaInformacion.llenarCampos2(fecha);
        PdfQaNovaReports.addWebReportImage("Datos ingresados","Ingrese [Campo Texto], [campo mail], [Campo Area de Texto], seleccione \n" +
                "[Campo Fecha], [Campo Lista], [Campo Selección Multiple], [Combo Radio Button]\n" +
                "Presione botón \"Enviar\" ",EstadoPrueba.PASSED,false);
        cargaInformacion.enviar();
        MatrizInformacion matriz = new MatrizInformacion();
        matriz.cargaMatrizInformacion();
    }
    //Llena el compo calendario con la propiedad entregada
    public void llenadoCalendario(){
        String usuario= ReadProperties.readFromConfig("propiedades.properties").getProperty("usuario");
        String key = ReadProperties.readFromConfig("propiedades.properties").getProperty("key");
        String fecha=ReadProperties.readFromConfig("propiedades.properties").getProperty("fecha");
        Index index = new Index();
        index.inicio(usuario,key);
        CargaInformacion cargaInformacion = new CargaInformacion();
        cargaInformacion.llenarCampos2(fecha);
    }
}
