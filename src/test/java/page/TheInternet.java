package page;

import Utils.DriverContext;

import Utils.ReadProperties;
import Utils.Validaciones;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;

public class TheInternet {
    @FindBy (xpath = "//*[@id=\"content\"]/div/a[18]")
    WebElement linkDescarga;

    public TheInternet(){
        PageFactory.initElements(DriverContext.getDriver(),this);

    }
    public void descarga(String archivo) throws InterruptedException {
        Validaciones.validarObjeto(linkDescarga,"link descarga");

        File Carpeta = new File(ReadProperties.readFromConfig("propiedades.properties").getProperty("rutaDescarga"));
        String [] compararArchivos = Carpeta.list();
        File[] cNombresArchivosborrar = Carpeta.listFiles();

        for(int i =0; i < cNombresArchivosborrar.length;i++){
            System.out.println(compararArchivos[i]);
            System.out.println(archivo);
            if (archivo == compararArchivos[i].trim()){
                System.out.println("Archivo eliminado");
                cNombresArchivosborrar[i].delete();
                }

        }

        linkDescarga.click();
        boolean validar=true;
        while(validar){
            String[] cNombresArchivos = Carpeta.list();
            for(int i =0; i < cNombresArchivos.length;i++){
                if (cNombresArchivos[i].equals(archivo)){
                    System.out.println("Descarga encontrada");
                    validar=false;
                }

            }
        }
    }
}
