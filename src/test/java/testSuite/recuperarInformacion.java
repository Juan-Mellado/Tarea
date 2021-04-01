package testSuite;
import Utils.Constants.Navegador;
import Utils.DriverContext;
import Utils.ReadProperties;
import Utils.Reporte.PdfQaNovaReports;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testClases.*;
public class recuperarInformacion {
    //Inicia el drivercontex y el pdfreport
    @BeforeTest
    public void setUp(){
        String url = ReadProperties.readFromConfig("propiedades.properties").getProperty("url");
        DriverContext.setUp(Navegador.Chrome,url);
        PdfQaNovaReports.createPDF();
    }
    //Finaliza el drivercontext
    @AfterTest
    public void end(){
        DriverContext.closeDriver();
    }
    //Prueba de inicio de sesion correcta
    @Test
    public void iniciar(){
        Iniciar iniciar = new Iniciar();
        iniciar.inicio();
        PdfQaNovaReports.closePDF();
    }
    //Prueba de inicio de sesion incorrecta
    @Test
    public void noInicia(){
        Noinicio noInicio = new Noinicio();
        noInicio.noInicia();
        PdfQaNovaReports.closePDF();
    }
    //Prueba de llenado de los campos de la tabla
    @Test
    public void llenado(){
        LlenarCampos llenado = new LlenarCampos();
        llenado.llenadoCampos();
        PdfQaNovaReports.closePDF();
    }
    //Prueba de busqueda en la tabla
    @Test
    public void mostarTabls(){
        BuscarMatriz buscar = new BuscarMatriz();
        buscar.recoleccionDatos();
    }
    //Prueba de subir un archivo
    @Test
    public void carga(){
        SubirArchivo subirArchivo= new SubirArchivo();
        subirArchivo.enviarArchivo();
    }
    //Prueba de descargar un archivo a una ruta especifica
    @Test
    public void descarga() throws InterruptedException {
        Descarga descarga = new Descarga();
        descarga.descarga();
    }
    //Prueba de llenado de calendario
    @Test
    public void llenadoCalendario(){
        LlenarCampos llenado = new LlenarCampos();
        llenado.llenadoCalendario();
    }
    //Prueba de envio de email con los datos cargados a la tabla
    @Test
    public void enivioEmail(){
        EnviarEmail envio = new EnviarEmail();
        envio.sendEmail();
    }
    //Prueba de registrar un nuevo usuario
    @Test
    public void resgistroUsuario(){
        CompletarUsuario nuevoUsuario = new CompletarUsuario();
        nuevoUsuario.datosUsuarioNuevo();
        PdfQaNovaReports.closePDF();
    }
}
