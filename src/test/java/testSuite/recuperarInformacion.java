package testSuite;
import Utils.DriverContext;
import Utils.ReadProperties;
import constants.Navegador;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testClases.BuscarMatriz;
import testClases.Iniciar;
import testClases.SubirArchivo;

public class recuperarInformacion {

    @BeforeTest
    public void setUp(){
        String url = ReadProperties.readFromConfig("propiedades.properties").getProperty("url");
        DriverContext.setUp(Navegador.Chrome,url);
    }

    @AfterTest
    public void end(){
        DriverContext.closeDriver();
    }

    @Test
    public void iniciar(){
        Iniciar iniciar = new Iniciar();
        iniciar.inicio();
    }
    @Test
    public void noInicia(){
        Iniciar iniciar= new Iniciar();
        iniciar.noInicia();
    }
    @Test
    public void llenado(){
        Iniciar iniciar = new Iniciar();
        iniciar.llenadoCampos();
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

}
