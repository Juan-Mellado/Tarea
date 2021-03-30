package page;

import Utils.DriverContext;
import Utils.Reporte.EstadoPrueba;
import Utils.Reporte.PdfQaNovaReports;
import Utils.Validaciones;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CrearUsuario {
    @FindBy(xpath = "//*[@id=\"imRegUname\"]")
    WebElement txtNuevoNombreUsuario;
    @FindBy(xpath = "//*[@id=\"imRegPwd\"]")
    WebElement txtNuevaContrasena;
    @FindBy(xpath = "//*[@id=\"imRepeatPwd\"]")
    WebElement txtNuevaRepiteContrasena;
    @FindBy(xpath = "//*[@id=\"imRealname\"]")
    WebElement txtNuevoNombreCompleto;
    @FindBy(xpath = "//*[@id=\"imEmail\"]")
    WebElement txtNuevoEmail;
    @FindBy(xpath = "//*[@id=\"imRegister_submit\"]")
    WebElement btnRegistarse;
    @FindBy(xpath = "//*[@id=\"imLoginPage\"]/div[4]/div")
    WebElement msgregistro;
    public CrearUsuario(){
        PageFactory.initElements(DriverContext.getDriver(),this);
    }
    public void cargaPagina(){
        Validaciones.validarObjeto(btnRegistarse,"boton de registrarse");
        PdfQaNovaReports.addWebReportImage("Carga pagina crear usuario","Se despliega página \"Area reservada\"\n" +
                "\"Para acceder a esta sección del sitio web debe introducir sus detalles de inicio de sesión\"\n" +
                "\n" +
                "Usuario ya Registrado\n" +
                "Textbox \"Nombre del Usuario\"\n" +
                "Textbox \"Contraseña\"\n" +
                "He olvidado mi contraseña, botón \"Intro\"\n" +
                "\n" +
                "Registra una nueva cuenta\n" +
                "Textbox \"Nombre usuario\"\n" +
                "Textbox \"Contraseña\"\n" +
                "Textbox \"Repite la contraseña\"\n" +
                "Textbox \"Nombre completo\"\n" +
                "Textbox \"E-mail\"\n" +
                "Botón \"Registrarse\"", EstadoPrueba.PASSED,false);
    }
    public void crearNuevoUsuario(String nombreUsuario,String contraseña, String nombreCompleto, String email){
        txtNuevoNombreUsuario.sendKeys(nombreUsuario);
        txtNuevaContrasena.sendKeys(contraseña);
        txtNuevaRepiteContrasena.sendKeys(contraseña);
        txtNuevoNombreCompleto.sendKeys(nombreCompleto);
        txtNuevoEmail.sendKeys(email);
        PdfQaNovaReports.addWebReportImage("Llenado de datos","Ingrese [Nombre usuario], [Contraseña], [Repite la contraseña], [Nombre completo], [E-mail] y presione Botón \"Registrarse\" ",EstadoPrueba.PASSED,false);


    }
    public void botonRegistrarse (){
        btnRegistarse.click();
    }
    public void mensajeRegistro(){
        Validaciones.validarObjeto(msgregistro,"Mensaje de registro");
        PdfQaNovaReports.addWebReportImage("mensaje de registro","Se despliega mensaje \"Registro completado con éxito\" en recuadro verde",EstadoPrueba.PASSED,false);

    }

}
