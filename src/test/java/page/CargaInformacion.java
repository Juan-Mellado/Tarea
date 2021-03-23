package page;
import Utils.DriverContext;
import Utils.Validaciones;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CargaInformacion {
    @FindBy(xpath = "//*[@id=\"imMnMnNode4\"]/a/span/span/span[2]")
    WebElement btnMatrizInformacion;

    @FindBy (xpath = "//*[@id=\"imMnMnNode6\"]/a/span/span/span[2]")
    WebElement btnCargaArchivo;

    @FindBy(xpath = "//*[@id=\"imObjectForm_1_2\"]")
    private WebElement cmpTexto;

    @FindBy(xpath = "//*[@id=\"imObjectForm_1_3\"]")
    private WebElement cmpEmail;

    @FindBy(xpath = "//*[@id=\"imObjectForm_1_4\"]")

    private WebElement areaTexto;

    @FindBy(xpath = "//*[@id=\"imObjectForm_1_5\"]")
    private WebElement cmpFecha;

    @FindBy(xpath = "//*[@id=\"imObjectForm_1_6\"]")
    private WebElement lista;

    // items de checkbox

    @FindBy(xpath = "//*[@id=\"imObjectForm_1_7_0\"]")
    private WebElement seleccion0;

    @FindBy(xpath = "//*[@id=\"imObjectForm_1_7_1\"]")
    private WebElement seleccion1;

    @FindBy(xpath = "//*[@id=\"imObjectForm_1_7_2\"]")
    private WebElement seleccion2;

    //items radio button

    @FindBy(xpath = "//*[@id=\"imObjectForm_1_8_0\"]")
    private WebElement boton0;

    @FindBy(xpath = "//*[@id=\"imObjectForm_1_8_1\"]")
    private WebElement boton1;

    @FindBy(xpath = "//*[@id=\"imObjectForm_1_8_2\"]")
    private WebElement boton2;

    public  CargaInformacion(){
        PageFactory.initElements(DriverContext.getDriver(),this);
    }

    public void pbCargaInformacion(){
        Validaciones.validarObjeto(btnMatrizInformacion,"Boton Matriz de informacion de main menu");
        btnMatrizInformacion.click();
    }

    public void pbCargaArchivo(){
        Validaciones.validarObjeto(btnCargaArchivo,"Boton cargar archivo de main manu");
        btnCargaArchivo.click();
    }
    public void llenarCampos( String texto, String email, String area, String fecha,String valorlista,boolean sMultiple0,boolean sMultiple1, boolean sMultiple2,String rButton){
        Validaciones.validarObjeto(cmpTexto,"Campo texto");
        cmpTexto.sendKeys(texto);
        cmpEmail.sendKeys(email);
        areaTexto.sendKeys(area);
        cmpFecha.sendKeys(fecha);
        Select cmplista = new Select(lista);
        //lista
        cmplista.selectByValue(valorlista);
        //checkbox
        if(sMultiple0){
            seleccion0.click();
        }
        if(sMultiple1){
            seleccion1.click();
        }
        if(sMultiple2){
            seleccion2.click();
        }
        //botton
        switch (rButton){
            case "1":
                boton0.click();
                break;
            case "2":
                boton1.click();
                break;
            case "3":
                boton2.click();
                break;
            default:
                System.out.println("No existe la opcion ingresada");
        }
    }

}
