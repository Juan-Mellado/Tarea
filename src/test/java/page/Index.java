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
    WebElement txtUsuario;
    @FindBy(xpath = "//*[@id=\"imPwd\"]")
    WebElement txtKey;
    @FindBy(xpath = "//*[@id=\"imLogin\"]/form/div[3]/input")
    WebElement btnDemo;
    @FindBy(xpath = "//*[@id=\"dynObj_02\"]/p/a")
    WebElement btnCrearUsuario;
    public Index(){
        PageFactory.initElements(DriverContext.getDriver(),this);
    }
    //Llena los campor usuario y contraseña
    public void inicio(String usuario, String key){
        Validaciones.validarObjeto(txtUsuario,"Campo usuario");
        txtUsuario.clear();
        txtKey.clear();
        txtUsuario.sendKeys(usuario);
        txtKey.sendKeys(key);
        PdfQaNovaReports.addWebReportImage("ingreso de claves","se ingresa nombre y claves correspondientes",EstadoPrueba.PASSED,false);
    }
    //Genera reporte con la captura de la pagina con los elementos sin llenar
    public void cargaIndex(){
        Validaciones.validarObjeto(txtUsuario,"cuadro de texto de usuario");
        PdfQaNovaReports.addWebReportImage("Despliegue de la ventana index","se despliega de manera correcta los elementos Textbox Nombre del usuario:\n" + "Textbox Contraseña:\n" + "Botón Ingresar a Demo\n" + "Link Crea tu usuario Aquí",EstadoPrueba.PASSED,false);
    }
    //Presiona el boton demo
    public void prisionaBtnDemo(){
        btnDemo.click();
    }
    //Presiona el boton crear nuevo usuario
    public void btncreaUsuario(){
        btnCrearUsuario.click();
    }
}
