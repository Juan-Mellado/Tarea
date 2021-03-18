package testSuite;

import Utils.DriverContext;
import constants.Navegador;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testClases.Iniciar;

import java.io.IOException;

public class recuperarInformacion {
    ChromeDriver driver;
    String url = "http://qanovagroup.com/piloto/";


    @BeforeTest
    public void setUp(){
        DriverContext.setUp(Navegador.Chrome,url);



    }

    @AfterTest
    public void end(){

        DriverContext.closeDriver();
    }

    @Test
    public void iniciar(){
        Iniciar iniciar = new Iniciar();
        iniciar.inicio("nvivas","qanova");

    }
    @Test
    public void noInicia(){

        Iniciar iniciar= new Iniciar();
        iniciar.noInicia();
    }
}
