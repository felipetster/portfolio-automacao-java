package br.com.crediflow.tests.login;

import br.com.crediflow.base.BaseTest;
import br.com.crediflow.pages.LoginPage;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class LoginTest extends BaseTest {
    @Test(description = "Deve realizar login com sucesso no CrediFlow")
    public void testLoginSucesso() {
        LoginPage loginPage = new LoginPage(driver);

        //ações
        loginPage.realizarLogin("dummy", "user");

        //validações
        assertThat(driver.getTitle())
                .as("O título da página deve ser Dashboard")
                .isEqualTo("ParaBank | Accounts Overview");

        assertThat(driver.getCurrentUrl())
                .contains("/overview");
    }
}
