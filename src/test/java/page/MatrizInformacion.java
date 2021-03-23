package page;

import Utils.DriverContext;
import Utils.Validaciones;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MatrizInformacion {
    @FindBy(xpath = "//*[@id=\"pluginAppObj_4_01_filter_field\"]")
    private WebElement txtFiltro;
    @FindBy(xpath = "//*[@id=\"pluginAppObj_4_01_filter_button\"]")
    private WebElement btnFilter;
    @FindBy(xpath = "//*[@id=\"pluginAppObj_4_01_jtable\"]/div/table")
    WebElement Body;

    public MatrizInformacion(){
        PageFactory.initElements(DriverContext.getDriver(),this);
    }

    public void bucarInformacion(String buscar){
        Validaciones.validarObjeto(btnFilter,"Boton de filtrar");
        txtFiltro.sendKeys(buscar);
        btnFilter.click();

        List<WebElement> Filas = Body.findElements(By.tagName("tr"));
        int cantFilas = Filas.size();
        String id = "", texto = "", email = "", area="",fecha = "", lista = "", seleccion = "",radio = "";
        for (int i = 1; i< cantFilas; i++){
            List<WebElement> columnas = Filas.get(i).findElements(By.tagName("td"));
            id = id + columnas.get(0).getText() + ";";
            texto = texto + columnas.get(1).getText() + ";";
            email = email + columnas.get(2).getText() + ";";
            area = area + columnas.get(3).getText() + ";";
            fecha = fecha + columnas.get(4).getText() + ";";
            lista = lista + columnas.get(5).getText() + ";";
            seleccion = seleccion + columnas.get(6).getText() + ";";
            radio = radio + columnas.get(7).getText() + ";";
        }
        System.out.println("**");
        System.out.println("ID" +"\n"+ id);
        System.out.println("TEXTO"+"\n"+ texto);
        System.out.println("EMAIL"+"\n"+ email);
        System.out.println("AREA"+"\n"+ area);
        System.out.println("FECHA"+"\n"+ fecha);
        System.out.println("LISTA"+"\n"+ lista);
        System.out.println("SELECCION"+"\n"+ seleccion);
        System.out.println("RADIO"+"\n"+ radio);
        System.out.println("**");
    }


}
