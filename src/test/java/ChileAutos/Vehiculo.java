package ChileAutos;

import Utils.DriverContext;
import Utils.Validaciones;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

public class Vehiculo {
    @FindBy(xpath = "/html/body/div[2]/div[3]/div/div/section[14]/div/div/div/p")
    WebElement txtComentario;
    @FindBy(xpath = "//*[@id=\"details\"]")
    WebElement txtDetalles;
    @FindBy(xpath = "/html/body/div[2]/div[3]/div/div/section[4]/div/div/div[1]/div")
    WebElement imgPrincipal;
    @FindBy(xpath = "/html/body/div[5]/div/div[1]/div[2]/div/div[1]/div[3]/div/div")
    WebElement listaImagenes;

    public Vehiculo(){
        PageFactory.initElements(DriverContext.getDriver(),this);
    }
    public void datosVehiculos() throws IOException {
        Validaciones.validarObjeto(txtComentario,"texto de comentario");
        System.out.println(txtComentario.getText());
        System.out.println("\n############################################################################################\n");
        System.out.println("\nVision General\n");
        List<WebElement> detalles = txtDetalles.findElements(By.tagName("div"));
        int elementos= detalles.size();
        for(int i=0;i<elementos;i++){
            List<WebElement> especifico= detalles.get(i).findElements(By.tagName("div"));
            int largo=especifico.size();
            for(int j=0;j<largo;j++){
                if(j==0){
                    System.out.println(especifico.get(j).getText()+" : "+especifico.get(j+1).getText());
                }
            }
        }
        System.out.println("\n");
        imgPrincipal.click();
        Validaciones.validarObjeto(listaImagenes,"lista de imagenes");
        List<WebElement> imagenes = listaImagenes.findElements(By.tagName("img"));
        int cantImagenes=imagenes.size();
        String src;
        File Imagenes=new File("C:\\tareas\\Tareas\\tmp\\imagen");
        File[] cNombresArchivosborrar = Imagenes.listFiles();
        for(int i =0; i < cNombresArchivosborrar.length;i++){
            cNombresArchivosborrar[i].delete();
        }
        for(int i=0;i<cantImagenes;i++){
            src=imagenes.get(i).getAttribute("src");

            BufferedImage bufferedImage = ImageIO.read(new URL(src));
            File outputfile = new File("C:\\tareas\\Tareas\\tmp\\imagen\\imagen"+i+".png");
            ImageIO.write(bufferedImage, "png", outputfile);
        }
    }
}
