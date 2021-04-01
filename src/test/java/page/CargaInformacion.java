package page;
import Utils.DriverContext;
import Utils.Reporte.EstadoPrueba;
import Utils.Reporte.PdfQaNovaReports;
import Utils.Validaciones;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import java.util.List;
public class CargaInformacion {
    @FindBy(xpath = "//*[@id=\"imMnMnNode4\"]/a/span/span/span[2]")
    WebElement btnMatrizInformacion;
    @FindBy (xpath = "//*[@id=\"imMnMnNode6\"]/a/span/span/span[2]")
    WebElement btnCargaArchivo;
    @FindBy(xpath = "//*[@id=\"imObjectForm_1_2\"]")
    WebElement cmpTexto;
    @FindBy(xpath = "//*[@id=\"imObjectForm_1_3\"]")
    WebElement cmpEmail;
    @FindBy(xpath = "//*[@id=\"imObjectForm_1_4\"]")
    WebElement areaTexto;
    @FindBy(xpath = "//*[@id=\"imObjectForm_1_5\"]")
    WebElement cmpFecha;
    @FindBy(xpath = "//*[@id=\"imObjectForm_1_6\"]")
    WebElement lista;
    // items de checkbox
    @FindBy(xpath = "//*[@id=\"imObjectForm_1_7_0\"]")
    WebElement seleccion0;
    @FindBy(xpath = "//*[@id=\"imObjectForm_1_7_1\"]")
    WebElement seleccion1;
    @FindBy(xpath = "//*[@id=\"imObjectForm_1_7_2\"]")
    WebElement seleccion2;
    //items radio button
    @FindBy(xpath = "//*[@id=\"imObjectForm_1_8_0\"]")
    WebElement boton0;
    @FindBy(xpath = "//*[@id=\"imObjectForm_1_8_1\"]")
    WebElement boton1;
    @FindBy(xpath = "//*[@id=\"imObjectForm_1_8_2\"]")
    WebElement boton2;
    //Elementos calendario
    @FindBy(xpath = "//*[@id=\"imObjectForm_1_5_icon\"]")
    WebElement btnCalendario;
    @FindBy(xpath = "//*[@id=\"imDPcal\"]/table")
    WebElement tblCalendario;
    @FindBy(xpath = "//*[@id=\"imObjectForm_1_submit\"]")
    WebElement btnCargar;
    public  CargaInformacion(){
        PageFactory.initElements(DriverContext.getDriver(),this);
    }
    //Valida que el boton "matriz de informacion" exista
    public void pbCargaInformacion(){
        Validaciones.validarObjeto(btnMatrizInformacion,"Boton Matriz de informacion de main menu");
        btnMatrizInformacion.click();
    }
    //Valida que el boton "carga de archivo" exista
    public void pbCargaArchivo(){
        Validaciones.validarObjeto(btnCargaArchivo,"Boton cargar archivo de main manu");
        btnCargaArchivo.click();
    }
    //Llena los campos de la tabla texto, email, area, lista, checkbox y radio button
    public void llenarCampos( String texto, String email, String area,String valorlista,boolean sMultiple0,boolean sMultiple1, boolean sMultiple2,String rButton){
        Validaciones.validarObjeto(cmpTexto,"Campo texto");
        cmpTexto.sendKeys(texto);
        cmpEmail.sendKeys(email);
        areaTexto.sendKeys(area);
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
    //Llena el campo fecha de la tabla
    public void llenarCampos2(  String fecha){
        Validaciones.validarObjeto(cmpTexto,"Campo texto");
        btnCalendario.click();
        List<WebElement> Filas = tblCalendario.findElements(By.tagName("td"));
        int semanas = Filas.size();
        for (int i = 1; i< semanas; i++){
            String dias = Filas.get(i).getText();
            if(dias.equalsIgnoreCase(fecha)){
                Filas.get(i).click();
                break;
            }
        }
    }
    //Preciona el boton enviar de la tabla
    public void enviar(){
        btnCargar.click();
    }
    //Genera reporte con la captura de la pagina con los elementos sin llenar
    public void cargaCargaInformacion(){
        Validaciones.validarObjeto(btnCargar,"El boton cargar se despliega correctamente");
        PdfQaNovaReports.addWebReportImage("Despliga la ventana carga de informacion","Se realiza Login y despliega página \"Carga de Información\"\n" +
                "\n" +
                "\"Se generan todas las posibilidades con el fin de poder automatizar la mayor parte del script en etapa de desarrollo\"\n" +
                "\n" +
                "Texbox \"Campo Texto\"\n" +
                "Textbox \"campo mail\"\n" +
                "Textbox \"Campo Area de Texto\"\n" +
                "Calendario \"Campo Fecha\"\n" +
                "Listbox \"Campo Lista\"\n" +
                "Checkbox \"Campo Selección Multiple\"\n" +
                "Radiobutton \"Combo Radio Button\"\n" +
                "Botones \"Enviar\" \"Resetear\"", EstadoPrueba.PASSED,false);
    }
}
