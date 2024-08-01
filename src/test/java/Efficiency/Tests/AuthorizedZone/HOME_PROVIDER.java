package Efficiency.Tests.AuthorizedZone;

import Efficiency.Pages.AuthorizedZone.HomeExpertPage;
import Efficiency.Pages.AuthorizedZone.HomeProviderPage;
import Efficiency.Pages.LoginPage;
import Efficiency.Providers.ConfigProviderInterface;
import Efficiency.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class HOME_PROVIDER extends TestBase {
    public String getEnvironment(){
        return super.getEnv();
    }
    private static final String PROVIDER_USER = System.getenv()
            .getOrDefault("PROVIDER_USER", "test_quantum31@test.com");
    private static final String PROVIDER_PASSWORD = System.getenv()
            .getOrDefault("PROVIDER_PASSWORD", "QWERTY123");
    @BeforeClass
    public void Login(){
        LoginPage loginPage = open(ConfigProviderInterface.authorizedProviderURL, LoginPage.class);
        loginPage.login(PROVIDER_USER, PROVIDER_PASSWORD);
    }

    @Test(priority = 1, description = "Авторизованная зона. Боковое меню")
    public void Side_Menu_TEST(){
        HomeProviderPage homeProviderPage = open(ConfigProviderInterface.authorizedProviderURL, HomeProviderPage.class);
        homeProviderPage.getSideMenuDataFromApi();
        homeProviderPage.Assert_SideMenu_WidgetData_Titles();
        homeProviderPage.Assert_SideMenu_WidgetData_URLs();
        homeProviderPage.Assert_SideMenu_ServicesData_Titles();
        homeProviderPage.Assert_SideMenu_ServicesData_URLs();
    }
}
