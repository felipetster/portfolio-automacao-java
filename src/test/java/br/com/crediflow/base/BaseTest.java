package br.com.crediflow.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void iniciar() {
        WebDriverManager.edgedriver().setup();

        driver = new EdgeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://parabank.parasoft.com/parabank/index.htm");
    }

    @AfterMethod
    public void finalizar() {
        if (driver != null); {
            driver.quit();
        }
    }
}
