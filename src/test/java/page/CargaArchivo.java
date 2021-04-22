package page;
import Utils.DriverContext;
import Utils.Validaciones;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class CargaArchivo {
    @FindBy (xpath = "//*[@id=\"imObjectForm_1_2\"]")
    WebElement seleccionArchivo;
    @FindBy (xpath = "//*[@id=\"imObjectForm_1_submit\"]")
    WebElement btnEnviar;
    public CargaArchivo(){
        PageFactory.initElements(DriverContext.getDriver(),this);
    }
    //Valida que el boton seleccionar archivo se encuentre en pantalla
    public void ingresarArchivo(String archivo){
        Validaciones.validarObjeto(seleccionArchivo,"Boton selecionar archivo");
        seleccionArchivo.sendKeys(archivo);
    }
    //Valida que el boton enviar se encuentre en pantalla y lo clickea
    public void clickEnviar(){
        Validaciones.validarObjeto(btnEnviar,"Boton enviar");
        btnEnviar.click();
    }
}
