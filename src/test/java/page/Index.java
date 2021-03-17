package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.security.cert.X509Certificate;

public class Index {

    @FindBy(xpath = "//*[@id=\"imUname\"]")
    private WebElement txtUsuario;

    @FindBy(xpath = "//*[@id=\"imPwd\"]")
    private WebElement txtKey;

    @FindBy(xpath = "//*[@id=\"imLogin\"]/form/div[3]/input")
    private WebElement btnDemo;

    public void inicio(String usuario, String key){
        txtUsuario.click();
        txtUsuario.sendKeys(usuario);
        txtKey.click();
        txtKey.sendKeys(key);
        btnDemo.click();


    }



}
