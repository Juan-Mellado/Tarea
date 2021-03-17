package testSuite;

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
        System.setProperty("webdriver.chrome.driver","/driversNavegadores/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(url);



    }

    @AfterTest
    public void end(){
        driver.close();
    }

    @Test
    public void iniciar(){
        Iniciar iniciar = new Iniciar();
        iniciar.inicio("nvivas","qanova");

    }
}
