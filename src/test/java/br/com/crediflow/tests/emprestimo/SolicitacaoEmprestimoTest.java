package br.com.crediflow.tests.emprestimo;

import br.com.crediflow.base.BaseTest;
import br.com.crediflow.pages.LoginPage;
import br.com.crediflow.pages.RequestLoanPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class SolicitacaoEmprestimoTest extends BaseTest {

    // 1. happy path :)
    @DataProvider(name = "massaDeDadosEmprestimo")
    public Object[][] obterDadosEmprestimo() {
        return new Object[][] {
                { "100", "5" },   // Cenário 1
                { "200", "10" }   // Cenário 2
        };
    }

    // 2. teste positivo
    @Test(description = "Deve aprovar empréstimos de valores baixos", dataProvider = "massaDeDadosEmprestimo")
    public void testSolicitarEmprestimoComSucesso(String valorSolicitado, String valorEntrada) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.realizarLogin("dummy", "user");

        RequestLoanPage loanPage = new RequestLoanPage(driver);
        loanPage.fazerPedidoEmprestimo(valorSolicitado, valorEntrada);

        String mensagemAtual = loanPage.obterMensagemSucesso();

        assertThat(mensagemAtual)
                .as("O empréstimo deveria ser aprovado")
                .contains("Congratulations");
    }

    // 3. teste negativo :(
    @Test(description = "Deve negar empréstimo se o valor de entrada for absurdo")
    public void testDeveNegarEmprestimoSemSaldo() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.realizarLogin("dummy", "user");

        RequestLoanPage loanPage = new RequestLoanPage(driver);
        // (vai ser negado -> muito dinheiro pedido)
        loanPage.fazerPedidoEmprestimo("100000", "50000");

        String mensagem = loanPage.obterMensagemErro();

        assertThat(mensagem)
                .as("O sistema deveria negar por falta de fundos")
                .contains("You do not have sufficient funds");
    }
}