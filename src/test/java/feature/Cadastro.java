package feature;

import driver.AppiumDriverConfig;
import io.appium.java_client.AppiumDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;
import pageObjects.CadastroPageObjects;
import pageObjects.LoginPageObjects;


public class Cadastro {

    @Test
    public void nao_deve_cadastrar_usuario_com_senhas_que_nao_conferem() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;

        LoginPageObjects loginPage = new LoginPageObjects(driver);
        loginPage.buscarElementos();
        loginPage.irParaATelaDeCadastro();

        CadastroPageObjects cadastroPage = new CadastroPageObjects(driver);
        cadastroPage.buscarElementos();
        cadastroPage.Cadastrar("Sapphire", "123", "456");

        Assert.assertEquals("Senhas não conferem", cadastroPage.MensagemErro());

        driver.navigate().back();

    }

    @Test
    public void posso_cadastrar_usuario_com_senhas_que_conferem() throws NoSuchElementException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;

        LoginPageObjects loginPage = new LoginPageObjects(driver);
        loginPage.buscarElementos();
        loginPage.irParaATelaDeCadastro();

        CadastroPageObjects cadastroPage = new CadastroPageObjects(driver);
        cadastroPage.buscarElementos();
        cadastroPage.Cadastrar("Sapphire", "123", "123");

    }
}
