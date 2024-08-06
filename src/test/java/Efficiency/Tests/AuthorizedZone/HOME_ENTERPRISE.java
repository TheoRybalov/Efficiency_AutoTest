package Efficiency.Tests.AuthorizedZone;

import Efficiency.Pages.AuthorizedZone.HomeEnterprisePage;
import Efficiency.Providers.ConfigProviderInterface;
import Efficiency.TestBase;


//import org.openqa.selenium.devtools.v127.network.Network;
//import org.openqa.selenium.devtools.v127.network.model.Request;
//import org.openqa.selenium.devtools.v127.network.model.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Efficiency.Pages.LoginPage;

import java.io.IOException;
import java.sql.SQLException;

import static com.codeborne.selenide.Selenide.*;

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

    @Test(priority = 1, description = "Авторизованная зона. Боковое меню")
    public void Side_Menu_TEST(){
        HomeEnterprisePage homeEnterprisePage = open(ConfigProviderInterface.authorizedEnterpriseURL, HomeEnterprisePage.class);
        homeEnterprisePage.getSideMenuDataFromApi();
        homeEnterprisePage.Assert_SideMenu_WidgetData_Titles();
        homeEnterprisePage.Assert_SideMenu_WidgetData_URLs();
        homeEnterprisePage.Assert_SideMenu_ServicesData_Titles();
        homeEnterprisePage.Assert_SideMenu_ServicesData_URLs();
    }

    @Test(priority = 2, description = "Путь цифровизации. Диагностика")
    public void Customer_Route_Diagnostics_Tab_TEST() throws SQLException {
        HomeEnterprisePage homeEnterprisePage = open(ConfigProviderInterface.authorizedEnterpriseURL, HomeEnterprisePage.class);
        homeEnterprisePage.getCustomerRouteDiagnosticsDataFromDB();
        homeEnterprisePage.Assert_CustomerRoute_Diagnostics_Header();
        homeEnterprisePage.Assert_CustomerRoute_Diagnostics_Text();
        homeEnterprisePage.Click_CustomerRoute_Diagnostics();
        homeEnterprisePage.Assert_CustomerRoute_Diagnostics_Status_Enabled();
        homeEnterprisePage.deleteCustomerRouteFromDB();
        homeEnterprisePage.Assert_CustomerRoute_Diagnostics_Status_NotEnabled();

    }

    @Test(priority = 3, description = "Путь цифровизации. Бенчмаркинг")
    public void Customer_Route_Benchmarking_Tab_TEST() throws SQLException {
        HomeEnterprisePage homeEnterprisePage = open(ConfigProviderInterface.authorizedEnterpriseURL, HomeEnterprisePage.class);
        homeEnterprisePage.getCustomerRouteBenchmarkingDataFromDB();
        homeEnterprisePage.Assert_CustomerRoute_Benchmarking_Header();
        homeEnterprisePage.Assert_CustomerRoute_Benchmarking_Text();
        homeEnterprisePage.Click_CustomerRoute_Benchmarking();
        homeEnterprisePage.Assert_CustomerRoute_Benchmarking_Status_Enabled();
        homeEnterprisePage.deleteCustomerRouteFromDB();
        homeEnterprisePage.Assert_CustomerRoute_Benchmarking_Status_NotEnabled();

    }

    @Test(priority = 4, description = "Путь цифровизации. План цифровизации")
    public void Customer_Route_DigitalizationPlan_Tab_TEST() throws SQLException {
        HomeEnterprisePage homeEnterprisePage = open(ConfigProviderInterface.authorizedEnterpriseURL, HomeEnterprisePage.class);
        homeEnterprisePage.getCustomerRouteDigitalizationPlanDataFromDB();
        homeEnterprisePage.Assert_CustomerRoute_DigitalizationPlan_Header();
        homeEnterprisePage.Assert_CustomerRoute_DigitalizationPlan_Text();
        homeEnterprisePage.Click_CustomerRoute_DigitalizationPlan();
        homeEnterprisePage.Assert_CustomerRoute_DigitalizationPlan_Status_Enabled();
        homeEnterprisePage.deleteCustomerRouteFromDB();
        homeEnterprisePage.Assert_CustomerRoute_DigitalizationPlan_Status_NotEnabled();

    }

    @Test(priority = 5, description = "Путь цифровизации. Подбор типовых решений")
    public void Customer_Route_StandardSolution_Tab_TEST() throws SQLException {
        HomeEnterprisePage homeEnterprisePage = open(ConfigProviderInterface.authorizedEnterpriseURL, HomeEnterprisePage.class);
        homeEnterprisePage.getCustomerRouteStandardSolutionDataFromDB();
        homeEnterprisePage.Assert_CustomerRoute_StandardSolution_Header();
        homeEnterprisePage.Assert_CustomerRoute_StandardSolution_Text();
        homeEnterprisePage.Click_CustomerRoute_StandardSolution();
        homeEnterprisePage.Assert_CustomerRoute_StandardSolution_Status_Enabled();
        homeEnterprisePage.deleteCustomerRouteFromDB();
        homeEnterprisePage.Assert_CustomerRoute_StandardSolution_Status_NotEnabled();
    }

    @Test(priority = 6, description = "Путь цифровизации. План внедрения")
    public void Customer_Route_ImplementationPlan_Tab_TEST() throws SQLException {
        HomeEnterprisePage homeEnterprisePage = open(ConfigProviderInterface.authorizedEnterpriseURL, HomeEnterprisePage.class);
        homeEnterprisePage.getCustomerRouteImplementationPlanDataFromDB();
        homeEnterprisePage.Assert_CustomerRoute_ImplementationPlan_Header();
        homeEnterprisePage.Assert_CustomerRoute_ImplementationPlan_Text();
        homeEnterprisePage.Click_CustomerRoute_ImplementationPlan();
        homeEnterprisePage.Assert_CustomerRoute_ImplementationPlan_Status_Enabled();
        homeEnterprisePage.deleteCustomerRouteFromDB();
        homeEnterprisePage.Assert_CustomerRoute_ImplementationPlan_Status_NotEnabled();
    }

    @Test(priority = 2, description = "Путь цифровизации. Меры поддержки")
    public void Customer_Route_SupportMeasures_Tab_TEST() throws SQLException {
        HomeEnterprisePage homeEnterprisePage = open(ConfigProviderInterface.authorizedEnterpriseURL, HomeEnterprisePage.class);
        homeEnterprisePage.getCustomerRouteSupportMeasuresDataFromDB();
        homeEnterprisePage.Assert_CustomerRoute_SupportMeasures_Header();
        homeEnterprisePage.Assert_CustomerRoute_SupportMeasures_Text();
        homeEnterprisePage.Click_CustomerRoute_SupportMeasures();
        homeEnterprisePage.Assert_CustomerRoute_SupportMeasures_Status_Enabled();
        homeEnterprisePage.deleteCustomerRouteFromDB();
        homeEnterprisePage.Assert_CustomerRoute_SupportMeasures_Status_NotEnabled();
    }



    @Test(priority = 2, description = "Авторизованная зона. Предприятие. Моя Лента. Диагностика")
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

    @Test(priority = 3, description = "Авторизованная зона. Предприятие. Моя Лента. Рекомендуемые анкеты")
    public void MyFeed_RecommendedQuestionnaires_TEST() throws SQLException {
        HomeEnterprisePage homeEnterprisePage = open(ConfigProviderInterface.authorizedEnterpriseURL, HomeEnterprisePage.class);
        homeEnterprisePage.getRecommendedQuestionnairesWidgetDataFromApi(super.proxy);
        homeEnterprisePage.getRecommendedQuestionnairesWidgetDataFromDB();
        homeEnterprisePage.Assert_MyFeed_RecommendedQuestionnaires_Header();
        homeEnterprisePage.Assert_MyFeed_RecommendedQuestionnaires_Questions();
        homeEnterprisePage.Assert_MyFeed_RecommendedQuestionnaires_Duration();
        homeEnterprisePage.Assert_MyFeed_RecommendedQuestionnaires_Text();
    }

    @Test(priority = 4, description = "Авторизованная зона. Предприятие. Моя Лента. Бенчмаркинг")
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

    @Test(priority = 5, description = "Авторизованная зона. Предприятие. Моя Лента. Витрина Решений")
    public void MyFeed_SolutionShowcase_TEST() throws SQLException {
        HomeEnterprisePage homeEnterprisePage = open(ConfigProviderInterface.authorizedEnterpriseURL, HomeEnterprisePage.class);
       homeEnterprisePage.getSolutionShowcaseWidgetDataFromApi();
       homeEnterprisePage.getSolutionShowcaseWidgetDataFromDB();
       homeEnterprisePage.Assert_MyFeed_SolutionShowcase_Header();
       homeEnterprisePage.Assert_MyFeed_SolutionShowcase_Text();
       homeEnterprisePage.Assert_MyFeed_SolutionShowcase_Count();

    }

    @Test(priority = 6, description = "Авторизованная зона. Предприятие. Моя Лента. Рекомендуемая статья")
    public void MyFeed_RecommendedArticle_TEST() throws IOException {
        HomeEnterprisePage homeEnterprisePage = open(ConfigProviderInterface.authorizedEnterpriseURL, HomeEnterprisePage.class);
        homeEnterprisePage.getRecommendedArticleWidgetDataFromApi(super.proxy);
        homeEnterprisePage.Assert_MyFeed_RecommendedArticle_Title();
        homeEnterprisePage.Assert_MyFeed_RecommendedArticle_Description();
    }

    @Test(priority = 7, description = "Авторизованная зона. Предприятие. Моя Лента. Поиск в Базе знаний")
    public void MyFeed_KnowledgeBaseSearch_TEST(){
        HomeEnterprisePage homeEnterprisePage = open(ConfigProviderInterface.authorizedEnterpriseURL, HomeEnterprisePage.class);
        homeEnterprisePage.getKnowledgeBaseSearchWidgetAfterNotEmptySearch(super.proxy, "");
        homeEnterprisePage.Assert_MyFeed_KnowledgeBaseSearch_AfterSearch();
        homeEnterprisePage.getKnowledgeBaseSearchWidgetAfterNotEmptySearch(super.proxy, homeEnterprisePage.MyFeed_KnowledgeBaseSearch_GetArticleTitleForSearch());
        homeEnterprisePage.Assert_MyFeed_KnowledgeBaseSearch_AfterSearch();
    }

    @Test(priority = 8, description = "Авторизованная зона. Предприятие. Моя Лента. HTML Виджет контрагента 1")
    public void MyFeed_HTML_Widget_First_Counterparty_TEST() throws IOException {
        HomeEnterprisePage homeEnterprisePage = open(ConfigProviderInterface.authorizedEnterpriseURL, HomeEnterprisePage.class);
        homeEnterprisePage.TakeScreenshotOfCounterpartyWidget1(getEnvironment());
        boolean result_of_comparing = homeEnterprisePage.compareScreenshotsOfCounterpartyWidget1(getEnvironment());
        Assert.assertTrue(result_of_comparing, "Скриншоты не совпали. Вёрстка не такая, как в макете");
    }

    @Test(priority = 9, description = "Авторизованная зона. Предприятие. Моя Лента. HTML Виджет контрагента 2")
    public void MyFeed_HTML_Widget_Second_Counterparty_TEST() throws IOException {
        HomeEnterprisePage homeEnterprisePage = open(ConfigProviderInterface.authorizedEnterpriseURL, HomeEnterprisePage.class);
        homeEnterprisePage.TakeScreenshotOfCounterpartyWidget2(getEnvironment());
        boolean result_of_comparing = homeEnterprisePage.compareScreenshotsOfCounterpartyWidget2(getEnvironment());
        Assert.assertTrue(result_of_comparing, "Скриншоты не совпали. Вёрстка не такая, как в макете");
    }

    @Test(priority = 10, description = "Авторизованная зона. Предприятие. Проекты с экспертной поддержкой")
    public void ElementalSupportWindow_TEST() throws IOException {
        HomeEnterprisePage homeEnterprisePage = open(ConfigProviderInterface.authorizedEnterpriseURL, HomeEnterprisePage.class);
        homeEnterprisePage.TakeScreenshotOfElementalSupportWindow_Column1(getEnvironment());
        boolean result_of_comparing = homeEnterprisePage.compareScreenshotsOfElementalSupportWindow_Column1(getEnvironment());
        Assert.assertTrue(result_of_comparing, "Скриншоты не совпали. Вёрстка не такая, как в макете");

        homeEnterprisePage.TakeScreenshotOfElementalSupportWindow_Column2(getEnvironment());
        result_of_comparing = homeEnterprisePage.compareScreenshotsOfElementalSupportWindow_Column2(getEnvironment());
        Assert.assertTrue(result_of_comparing, "Скриншоты не совпали. Вёрстка не такая, как в макете");

        homeEnterprisePage.TakeScreenshotOfElementalSupportWindow_Column3(getEnvironment());
        result_of_comparing = homeEnterprisePage.compareScreenshotsOfElementalSupportWindow_Column3(getEnvironment());
        Assert.assertTrue(result_of_comparing, "Скриншоты не совпали. Вёрстка не такая, как в макете");

        homeEnterprisePage.TakeScreenshotOfElementalSupportWindow_Column4(getEnvironment());
        result_of_comparing = homeEnterprisePage.compareScreenshotsOfElementalSupportWindow_Column4(getEnvironment());
        Assert.assertTrue(result_of_comparing, "Скриншоты не совпали. Вёрстка не такая, как в макете");
    }


}
