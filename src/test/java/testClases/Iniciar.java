package testClases;
import org.openqa.selenium.chrome.ChromeDriver;
import page.Index;

public class Iniciar {

    Index index;

    public void inicio(String usuario, String key) {
        index = new Index();
        index.inicio(usuario,key);

    }
    public void noInicia(){
        String msgAux = "Nombre y/o password incorrecto";
        index = new Index();
        index.noInicia(msgAux);
    }

}
