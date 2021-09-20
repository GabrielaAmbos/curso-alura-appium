package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CadastroPageObjects extends PageObjectsBase{

    private MobileElement campoNome;
    private MobileElement campoSenha;
    private MobileElement campoConfirmarSenha;
    private MobileElement botaoCadastrar;
    private MobileElement mensagemErroCadastro;
    private final By erroId;
    private By campoNomeId;
    private By campoSenhaId;
    private By campoConfirmarId;
    private By botaoCadastrarId;


    public CadastroPageObjects(AppiumDriver driver) {
        super(driver);
        erroId = By.id("erro_cadastro");
        campoNomeId = By.id("input_nome");
        campoSenhaId = By.id("input_senha");
        campoConfirmarId = By.id("input_confirmar_senha");
        botaoCadastrarId = By.id("cadastro_usuario_botao_cadastrar");
    }

    @Override
    public void buscarElementos() {
        campoNome = (MobileElement) driver.findElement(campoNomeId);
        campoSenha = (MobileElement) driver.findElement(campoSenhaId);
        campoConfirmarSenha = (MobileElement) driver.findElement(campoConfirmarId);
        botaoCadastrar = (MobileElement) driver.findElement(botaoCadastrarId);
    }

    private void preencherFormulario(String nome, String senha, String confirmarSenha) {
        campoNome.setValue(nome);
        campoSenha.setValue(senha);
        campoConfirmarSenha.setValue(confirmarSenha);
    }

    public void Cadastrar(String nome, String senha, String confirmarSenha) {
        preencherFormulario(nome, senha, confirmarSenha);
        botaoCadastrar.click();
    }

    public String MensagemErro() {
        WebDriverWait espera = new WebDriverWait(driver, 3);
        espera.until(ExpectedConditions.presenceOfElementLocated(erroId));

        mensagemErroCadastro = (MobileElement) driver.findElement(erroId);
        return mensagemErroCadastro.getText();
    }

}
