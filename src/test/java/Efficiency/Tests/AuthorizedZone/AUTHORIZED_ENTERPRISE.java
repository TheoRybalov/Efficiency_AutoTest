package Efficiency.Tests.AuthorizedZone;

import Efficiency.Pages.AuthorizedZone.AuthorizedEnterprisePage;
import Efficiency.Pages.HomePage;
import Efficiency.Providers.ConfigProviderInterface;
import Efficiency.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Efficiency.Pages.LoginPage;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

public class AUTHORIZED_ENTERPRISE extends TestBase {

    public String getEnvironment(){
        return super.getEnv();
    }
    private static final String ENTERPRISE_USER = System.getenv()
            .getOrDefault("ENTERPRISE_USER", "test_quantum29@test.com");
    private static final String ENTERPRISE_PASSWORD = System.getenv()
            .getOrDefault("ENTERPRISE_PASSWORD", "QWERTY123");
    @BeforeClass
    public void Login(){
        LoginPage loginPage = open(ConfigProviderInterface.authorizedEnterpriseURL, LoginPage.class);
        loginPage.login(ENTERPRISE_USER, ENTERPRISE_PASSWORD);
        sleep(5000);
    }


    @Test(priority = 1, description = "Домашняя страница. Редиректы на хэдере")
    public void Header_TEST() throws IOException {
        AuthorizedEnterprisePage authorizedEnterprisePage = open(ConfigProviderInterface.authorizedEnterpriseURL, AuthorizedEnterprisePage.class);
    }

}
