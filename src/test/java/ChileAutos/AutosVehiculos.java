package ChileAutos;

import Utils.DriverContext;
import Utils.Validaciones;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AutosVehiculos {
    @FindBy(xpath = "/html/body/div[2]/div[3]/div[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[1]/a")
    WebElement listaAutos;
    public AutosVehiculos(){
        PageFactory.initElements(DriverContext.getDriver(),this);
    }
    public void  datosPrimerVehiculo(){
        Validaciones.validarObjeto(listaAutos,"numero de fotos");
        List<WebElement> autos = listaAutos.findElements(By.tagName("span"));
        int largo = autos.size();
        for(int i=1;i<largo;i++){
            if(i==1){
                System.out.println("Fotos: "+autos.get(i).getText());
            }
            else{
                if(i==2){
                    System.out.println("Videos: "+autos.get(i).getText());
                }
            }
        }
        autos.get(0).click();
    }
}
