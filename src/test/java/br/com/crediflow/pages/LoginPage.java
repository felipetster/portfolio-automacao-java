package br.com.crediflow.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    // Mapeamento dos elementos
    private By campoUsuario = By.name("username");
    private By campoSenha = By.name("password");
    private By botaoLogin = By.cssSelector("div.login input.button");
    private By mensagemErro = By.xpath("//p[@class='error']");

    //Construtor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //Ações
    public void preencherUsuario(String usuario) {
        driver.findElement(campoUsuario).sendKeys(usuario);
    }

    public void preencherSenha(String senha) {
        driver.findElement(campoSenha).sendKeys(senha);
    }

    public void clicarEntrar() {
        driver.findElement(botaoLogin).click();
    }

    public String getMensagemErro() {
        return driver.findElement(mensagemErro).getText();
    }

    public void realizarLogin(String usuario, String senha) {
        preencherUsuario(usuario);
        preencherSenha(senha);
        clicarEntrar();
    }
}