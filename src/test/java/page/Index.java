package page;
import Utils.DriverContext;
import Utils.Reporte.EstadoPrueba;
import Utils.Reporte.PdfQaNovaReports;
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

    @FindBy(xpath = "//*[@id=\"dynObj_02\"]/p/a")
    private WebElement btnCrearUsuario;



    public Index(){
        PageFactory.initElements(DriverContext.getDriver(),this);
    }

    public void inicio(String usuario, String key){
        Validaciones.validarObjeto(txtUsuario,"Campo usuario");
        txtUsuario.click();
        txtUsuario.sendKeys(usuario);
        txtKey.click();
        txtKey.sendKeys(key);
    }

    public void cargaIndex(){
        Validaciones.validarObjeto(txtUsuario,"cuadro de texto de usuario");
        PdfQaNovaReports.addWebReportImage("Despliegue de la ventana index","se despliega de manera correcta los elementos Textbox Nombre del usuario:\n" + "Textbox Contraseña:\n" + "Botón Ingresar a Demo\n" + "Link Crea tu usuario Aquí",EstadoPrueba.PASSED,false);
    }
    public void prisionaBtnDemo(){

        btnDemo.click();
    }
    public void btncreaUsuario(){
        btnCrearUsuario.click();
    }






}
