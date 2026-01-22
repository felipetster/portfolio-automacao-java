package br.com.crediflow.tests.login;

import br.com.crediflow.base.BaseTest;
import br.com.crediflow.pages.LoginPage;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class LoginTest extends BaseTest {

    @Test(description = "Deve realizar login com sucesso no CrediFlow")
    public void testLoginSucesso() {
        // 1. Instancia a página
        LoginPage loginPage = new LoginPage(driver);

        // 2. Ações
        loginPage.realizarLogin("dummy", "user");

        // 3. Validações (AssertJ)
        assertThat(driver.getTitle())
                .as("O título da página deve ser Dashboard")
                .isEqualTo("ParaBank | Accounts Overview");

        assertThat(driver.getCurrentUrl())
                .contains("/overview");
    }

    @Test(description = "Deve bloquear login inválido")
    public void deveBloquearLoginInvalido() {
        // TODO: Este teste falha no ambiente público pois o sistema aceita qualquer senha
        // Bug reportado em: JIRA-123 (fictício)
        // Comportamento esperado: Bloquear.
        // Comportamento atual: Loga como John Smith.

        LoginPage loginPage = new LoginPage(driver);
        loginPage.realizarLogin("usuario_errado", "senha_errada");

        // O assert abaixo vai falhar propositalmente para evidenciar o bug
        assertThat(loginPage.getMensagemErro())
                .as("Falha de Segurança: O sistema permitiu login com senha errada!")
                .isEqualTo("The username and password could not be verified.");
    }
}