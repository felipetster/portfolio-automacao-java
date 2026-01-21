package br.com.crediflow.pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RequestLoanPage {

    private WebDriver driver;

    //mapeamento
    private By menuRequestLoan = By.linkText("Request Loan");
    private By inputAmount = By.id("amount");
    private By inputDownPayment = By.id("downPayment");
    private By botaoApply = By.cssSelector("input.button");

    //validacao
    //aqui estao os dois possiveis resultados (aprovado ou negado)
    private By mensagemSucesso = By.xpath("//div[@id='loanRequestApproved']/p");
    private By mensagemErro = By.xpath("//div[@id='loanRequestDenied']/p");

    public RequestLoanPage(WebDriver driver) {
        this.driver = driver;
    }

    //acoes atomicas
    public void acessarTelaSolicitacao() {
        driver.findElement(menuRequestLoan).click();
    }

    public void preencherValor(String valor) {
        driver.findElement(inputAmount).sendKeys(valor);
    }

    public void preencherEntrada(String valor) {
        driver.findElement(inputDownPayment).sendKeys(valor);
    }

    public void clicarAplicar() {
        driver.findElement(botaoApply).click();
    }

    //validacoes com espera explicita
    public String obterMensagemSucesso() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //espera aparecer a mensagem de aprovado
        WebElement elemento = wait.until(ExpectedConditions.visibilityOfElementLocated(mensagemSucesso));
        return elemento.getText();
    }

    public String obterMensagemErro() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //espera aparecer a mensagem de negado
        WebElement elemento = wait.until(ExpectedConditions.visibilityOfElementLocated(mensagemErro));
        return elemento.getText();
    }

    //facade / fluxo completo
    public void fazerPedidoEmprestimo(String valor, String entrada) {
        acessarTelaSolicitacao();
        preencherValor(valor);
        preencherEntrada(entrada);
        clicarAplicar();
    }
}