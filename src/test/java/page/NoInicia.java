package page;
import Utils.DriverContext;
import Utils.Reporte.EstadoPrueba;
import Utils.Reporte.PdfQaNovaReports;
import Utils.Validaciones;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class NoInicia {
    @FindBy(xpath = "//*[@id=\"imLoginPage\"]/div[3]/div")
    WebElement msgError;
    public NoInicia(){
        PageFactory.initElements(DriverContext.getDriver(),this);
    }
    //Genera reporte con la captura de la pagina con el mensaje de error
    public void mensageError(String msgAux){
        Validaciones.validarObjeto(msgError,"se despliega mensage de error");
        try {
            String color = msgError.getCssValue("color");
            if (msgAux.equals(msgError.getText())) {
                System.out.println("El texto (" + msgError.getText() + ") SI se encuentra en la página\n" + "El color es ");
                PdfQaNovaReports.addWebReportImage("no inicio sesion", "no se logro iniciar sesion", EstadoPrueba.FAILED, false);
            } else {
                System.out.println("El texto (" + msgAux + ") NO se encuentra en la página");
            }
            PdfQaNovaReports.addWebReportImage("Se falla en el login", "No se realiza Login y se despliega mensaje \"Nombre y/o password incorrecto\" en recuadro rojo", EstadoPrueba.PASSED, false);
        } catch (Exception e){
            System.out.println("No se ejecuta el codigo de mensageError");
        }
    }

}
