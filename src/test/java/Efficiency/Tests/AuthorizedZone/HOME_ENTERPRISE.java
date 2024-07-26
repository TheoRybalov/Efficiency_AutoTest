package Efficiency.Tests.AuthorizedZone;

import Efficiency.Pages.AuthorizedZone.HomeEnterprisePage;
import Efficiency.Providers.ConfigProviderInterface;
import Efficiency.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Efficiency.Pages.LoginPage;

import java.io.IOException;
import java.sql.SQLException;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

public class HOME_ENTERPRISE extends TestBase {

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
    }


    @Test(priority = 1, description = "Авторизованная зона. Предприятие. Моя Лента. Диагностика", enabled = false)
    public void MyFeed_Diagnostics_TEST() throws SQLException {
        HomeEnterprisePage homeEnterprisePage = open(ConfigProviderInterface.authorizedEnterpriseURL, HomeEnterprisePage.class);
        homeEnterprisePage.getDiagnosticWidgetDataFromDB();
        homeEnterprisePage.getDiagnosticWidgetDataFromApi();
        homeEnterprisePage.Assert_MyFeed_Diagnostics_Header();
        homeEnterprisePage.Assert_MyFeed_Diagnostics_Text();
        homeEnterprisePage.Assert_MyFeed_Diagnostics_Percentage();
        homeEnterprisePage.Assert_MyFeed_Diagnostics_Application();
//        homeEnterprisePage.Assert_MyFeed_Diagnostics_Href();
    }

    @Test(priority = 2, description = "Авторизованная зона. Предприятие. Моя Лента. Рекомендуемые анкеты",enabled = false)
    public void MyFeed_RecommendedQuestionnaires_TEST() throws SQLException {
        HomeEnterprisePage homeEnterprisePage = open(ConfigProviderInterface.authorizedEnterpriseURL, HomeEnterprisePage.class);
        homeEnterprisePage.getRecommendedQuestionnairesWidgetDataFromApi();
        homeEnterprisePage.getRecommendedQuestionnairesWidgetDataFromDB();
        homeEnterprisePage.Assert_MyFeed_RecommendedQuestionnaires_Header();
        homeEnterprisePage.Assert_MyFeed_RecommendedQuestionnaires_Questions();
        homeEnterprisePage.Assert_MyFeed_RecommendedQuestionnaires_Duration();
        homeEnterprisePage.Assert_MyFeed_RecommendedQuestionnaires_Text();
    }

    @Test(priority = 3, description = "Авторизованная зона. Предприятие. Моя Лента. Бенчмаркинг", enabled = false)
    public void MyFeed_Benchmarking_TEST() throws SQLException {
        HomeEnterprisePage homeEnterprisePage = open(ConfigProviderInterface.authorizedEnterpriseURL, HomeEnterprisePage.class);
        homeEnterprisePage.getBenchmarkingWidgetDataFromDB();
        homeEnterprisePage.getBenchmarkingWidgetDataFromApi();
        homeEnterprisePage.Assert_MyFeed_Benchmarking_Header();
        homeEnterprisePage.Assert_MyFeed_Benchmarking_Text();
        homeEnterprisePage.Assert_MyFeed_Benchmarking_companiesCount();
        homeEnterprisePage.Assert_MyFeed_Benchmarking_companiesByOkvedCount();
//        homeEnterprisePage.Assert_MyFeed_Benchmarking_Href();

    }

    @Test(priority = 4, description = "Авторизованная зона. Предприятие. Моя Лента. Витрина Решений",enabled = false)
    public void MyFeed_SolutionShowcase_TEST() throws SQLException {
        HomeEnterprisePage homeEnterprisePage = open(ConfigProviderInterface.authorizedEnterpriseURL, HomeEnterprisePage.class);
       homeEnterprisePage.getSolutionShowcaseWidgetDataFromApi();
       homeEnterprisePage.getSolutionShowcaseWidgetDataFromDB();
       homeEnterprisePage.Assert_MyFeed_SolutionShowcase_Header();
       homeEnterprisePage.Assert_MyFeed_SolutionShowcase_Text();
       homeEnterprisePage.Assert_MyFeed_SolutionShowcase_Count();

    }

    @Test(priority = 5, description = "Авторизованная зона. Предприятие. Моя Лента. Рекомендуемая статья",enabled = false)
    public void MyFeed_RecommendedArticle_TEST() throws IOException {
        HomeEnterprisePage homeEnterprisePage = open(ConfigProviderInterface.authorizedEnterpriseURL, HomeEnterprisePage.class);


    }

    @Test(priority = 6, description = "Авторизованная зона. Предприятие. Моя Лента. HTML Виджет контрагента 1")
    public void MyFeed_HTML_Widget_First_Counterparty_TEST() throws IOException {
        HomeEnterprisePage homeEnterprisePage = open(ConfigProviderInterface.authorizedEnterpriseURL, HomeEnterprisePage.class);
        homeEnterprisePage.TakeScreenshotOfCounterpartyWidget1(getEnvironment());
        homeEnterprisePage.compareScreenshotsOfCounterpartyWidget1(getEnvironment());
    }

    @Test(priority = 6, description = "Авторизованная зона. Предприятие. Моя Лента. HTML Виджет контрагента 2")
    public void MyFeed_HTML_Widget_Second_Counterparty_TEST() throws IOException {
        HomeEnterprisePage homeEnterprisePage = open(ConfigProviderInterface.authorizedEnterpriseURL, HomeEnterprisePage.class);
        homeEnterprisePage.TakeScreenshotOfCounterpartyWidget2(getEnvironment());
        homeEnterprisePage.compareScreenshotsOfCounterpartyWidget2(getEnvironment());
    }


}
