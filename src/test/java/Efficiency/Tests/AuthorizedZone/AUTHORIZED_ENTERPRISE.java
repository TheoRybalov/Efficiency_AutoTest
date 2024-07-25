package Efficiency.Tests.AuthorizedZone;

import Efficiency.Pages.AuthorizedZone.AuthorizedEnterprisePage;
import Efficiency.Providers.ConfigProviderInterface;
import Efficiency.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Efficiency.Pages.LoginPage;

import java.io.IOException;
import java.sql.SQLException;

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


    @Test(priority = 1, description = "Авторизованная зона. Предприятие. Моя Лента. Диагностика")
    public void MyFeed_Diagnostics_TEST() throws SQLException {
        AuthorizedEnterprisePage authorizedEnterprisePage = open(ConfigProviderInterface.authorizedEnterpriseURL, AuthorizedEnterprisePage.class);
        authorizedEnterprisePage.getDiagnosticWidgetDataFromDB();
        authorizedEnterprisePage.getDiagnosticWidgetDataFromApi();
        authorizedEnterprisePage.Assert_MyFeed_Diagnostics_Header();
        authorizedEnterprisePage.Assert_MyFeed_Diagnostics_Text();
        authorizedEnterprisePage.Assert_MyFeed_Diagnostics_Percentage();
        authorizedEnterprisePage.Assert_MyFeed_Diagnostics_Application();
    }

}
