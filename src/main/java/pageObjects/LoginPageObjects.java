package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class LoginPageObjects extends PageObjectsBase{

    private MobileElement botaoCadastro;
    private By botaoCadastroId;

    public LoginPageObjects(AppiumDriver driver) {
        super(driver);
        botaoCadastroId = By.id("login_botao_cadastrar_usuario");
    }

    @Override
    public void buscarElementos() {
        botaoCadastro = (MobileElement) driver.findElement(botaoCadastroId);
    }

    public void irParaATelaDeCadastro() {
        botaoCadastro.click();
    }
}
