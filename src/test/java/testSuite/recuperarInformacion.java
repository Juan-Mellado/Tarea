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

    @BeforeTest
    public void setUp(){
        String url = ReadProperties.readFromConfig("propiedades.properties").getProperty("url");
        DriverContext.setUp(Navegador.Chrome,url);
        PdfQaNovaReports.createPDF();
    }
    @AfterTest
    public void end(){
        DriverContext.closeDriver();
        PdfQaNovaReports.closePDF();
    }

    @Test
    public void iniciar(){
        Iniciar iniciar = new Iniciar();
        iniciar.inicio();
    }
    @Test
    public void noInicia(){
        Noinicio noInicio = new Noinicio();
        noInicio.noInicia();

    }
    @Test
    public void llenado(){
        LlenarCampos llenado = new LlenarCampos();
        llenado.llenadoCampos();
    }
    @Test
    public void mostarTabls(){
        BuscarMatriz buscar = new BuscarMatriz();
        buscar.recoleccionDatos();
    }
    @Test
    public void carga(){
        SubirArchivo subirArchivo= new SubirArchivo();
        subirArchivo.enviarArchivo();
    }
    @Test
    public void descarga() throws InterruptedException {
        Descarga descarga = new Descarga();
        descarga.descarga();
    }
    @Test
    public void llenadoCalendario(){
        LlenarCampos llenado = new LlenarCampos();
        llenado.llenadoCalendario();
    }
    @Test
    public void enivioEmail(){
        EnviarEmail envio = new EnviarEmail();
        envio.sendEmail();
    }
    @Test
    public void resgistroUsuario(){
        CompletarUsuario nuevoUsuario = new CompletarUsuario();
        nuevoUsuario.datosUsuarioNuevo();
    }

}
