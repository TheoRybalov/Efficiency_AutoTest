package Efficiency.Tests.AuthorizedZone;

import Efficiency.Pages.AuthorizedZone.HomeExpertPage;
import Efficiency.Pages.LoginPage;
import Efficiency.Providers.ConfigProviderInterface;
import Efficiency.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.SQLException;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

public class HOME_EXPERT extends TestBase {

    public String getEnvironment(){
        return super.getEnv();
    }
    private static final String EXPERT_USER = System.getenv()
            .getOrDefault("ENTERPRISE_USER", "test_quantum22@test.com");
    private static final String EXPERT_PASSWORD = System.getenv()
            .getOrDefault("ENTERPRISE_PASSWORD", "BJMD9~");
    @BeforeClass
    public void Login(){
        LoginPage loginPage = open(ConfigProviderInterface.authorizedExpertURL, LoginPage.class);
        loginPage.login(EXPERT_USER, EXPERT_PASSWORD);
        sleep(5000);
    }

    @Test(priority = 1, description = "Авторизованная зона. Эксперт. Моя Лента. Витрина решений")
    public void MyFeed_Solutions_TEST() throws SQLException {
        HomeExpertPage homeExpertPage = open(ConfigProviderInterface.authorizedExpertURL, HomeExpertPage.class);
        homeExpertPage.getSolutionsWidgetDataFromDB();
        homeExpertPage.getSolutionsWidgetDataFromApi();
        homeExpertPage.Assert_MyFeed_Solutions_Header();
        homeExpertPage.Assert_MyFeed_Solutions_Text();
        homeExpertPage.Assert_MyFeed_Solutions_Quantity();
        homeExpertPage.Assert_MyFeed_Solutions_Href();
    }
}
