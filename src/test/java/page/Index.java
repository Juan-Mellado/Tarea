package page;
import Utils.DriverContext;
import Utils.Validaciones;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Index {
    //Inicio de secion
    @FindBy(xpath = "//*[@id=\"imUname\"]")
    private WebElement txtUsuario;

    @FindBy(xpath = "//*[@id=\"imPwd\"]")
    private WebElement txtKey;

    @FindBy(xpath = "//*[@id=\"imLogin\"]/form/div[3]/input")
    private WebElement btnDemo;

    //mensage de error

    @FindBy(xpath = "//*[@id=\"imLoginPage\"]/div[3]/div")
    private WebElement msgError;

    public Index(){
        PageFactory.initElements(DriverContext.getDriver(),this);
    }

    public void inicio(String usuario, String key){
        Validaciones.validarObjeto(txtUsuario,"Campo usuario");
        txtUsuario.click();
        txtUsuario.sendKeys(usuario);
        txtKey.click();
        txtKey.sendKeys(key);
        btnDemo.click();
    }

    public void noInicia(String msgAux){
        Validaciones.validarObjeto(btnDemo,"Boton ingresar demo");
        btnDemo.click();
        String msg = msgError.getText();
        String color = msgError.getCssValue("color");
        if(msgAux.equals(msg)){
            System.out.println("El texto ("+msg+") SI se encuentra en la página\n"+"El color es "+color);
        }
        else{
            System.out.println("El texto ("+msgAux+") NO se encuentra en la página");
        }

    }






}
