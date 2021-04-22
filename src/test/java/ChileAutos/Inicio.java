package ChileAutos;

import Utils.DriverContext;
import Utils.Validaciones;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Inicio {
    @FindBy(xpath = "//*[@id=\"search-form-container\"]/div/div[1]/a")
    WebElement btnBuscar;
    public Inicio(){
        PageFactory.initElements(DriverContext.getDriver(),this);
    }

    public void presionaBtnBuscar(){
        Validaciones.validarObjeto(btnBuscar,"boton de buscar");
        btnBuscar.click();
        }

}
