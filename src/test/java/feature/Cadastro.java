package feature;

import driver.AppiumDriverConfig;
import io.appium.java_client.MobileElement;
import org.junit.Assert;
import org.junit.Test;

import java.net.MalformedURLException;

public class Cadastro {

    @Test
    public void nao_deve_cadastrar_usuario_com_senhas_que_nao_conferem() throws MalformedURLException {
        AppiumDriverConfig driver = new AppiumDriverConfig();

        MobileElement botaoCadastro = (MobileElement) driver.driver.findElementById("br.com.alura.aluraesporte:id/login_botao_cadastrar_usuario");
        botaoCadastro.click();

        MobileElement campoNome = (MobileElement) driver.driver.findElementById("br.com.alura.aluraesporte:id/input_nome");
        campoNome.setValue("Sapphire");

        MobileElement campoSenha = (MobileElement) driver.driver.findElementById("br.com.alura.aluraesporte:id/input_senha");
        campoSenha.setValue("123456");

        MobileElement campoConfirmarSenha = (MobileElement) driver.driver.findElementById("br.com.alura.aluraesporte:id/input_confirmar_senha");
        campoConfirmarSenha.setValue("543563");

        MobileElement botaoCadastrar = (MobileElement) driver.driver.findElementById("br.com.alura.aluraesporte:id/cadastro_usuario_botao_cadastrar");
        botaoCadastrar.click();

        MobileElement mensagemErroCadastro = (MobileElement) driver.driver.findElementById("br.com.alura.aluraesporte:id/erro_cadastro");

        Assert.assertEquals("Senhas não conferem", mensagemErroCadastro.getText());

    }

    @Test
    public void posso_cadastrar_usuario_com_senhas_que_conferem() throws MalformedURLException {
        AppiumDriverConfig driver = new AppiumDriverConfig();

        MobileElement botaoCadastro = (MobileElement) driver.driver.findElementById("br.com.alura.aluraesporte:id/login_botao_cadastrar_usuario");
        botaoCadastro.click();

        MobileElement campoNome = (MobileElement) driver.driver.findElementById("br.com.alura.aluraesporte:id/input_nome");
        campoNome.setValue("Sapphire");

        MobileElement campoSenha = (MobileElement) driver.driver.findElementById("br.com.alura.aluraesporte:id/input_senha");
        campoSenha.setValue("123456");

        MobileElement campoConfirmarSenha = (MobileElement) driver.driver.findElementById("br.com.alura.aluraesporte:id/input_confirmar_senha");
        campoConfirmarSenha.setValue("123456");

        MobileElement botaoCadastrar = (MobileElement) driver.driver.findElementById("br.com.alura.aluraesporte:id/cadastro_usuario_botao_cadastrar");
        botaoCadastrar.click();
    }
}
