package Efficiency.Tests.AuthorizedZone;

import Efficiency.BrowserDriverFactory;
import Efficiency.Pages.AuthorizedZone.HomeEnterprisePage;
import Efficiency.Pages.AuthorizedZone.HomeExpertPage;
import Efficiency.Providers.ConfigProviderInterface;
import Efficiency.TestBase;
import com.codeborne.selenide.WebDriverRunner;
import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.core.har.Har;
import net.lightbody.bmp.core.har.HarEntry;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;



//import org.openqa.selenium.devtools.v127.network.Network;
//import org.openqa.selenium.devtools.v127.network.model.Request;
//import org.openqa.selenium.devtools.v127.network.model.Response;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Efficiency.Pages.LoginPage;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

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

    @Test(priority = 2, description = "Авторизованная зона. Предприятие. Моя Лента. Рекомендуемые анкеты", enabled = false)
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

    @Test(priority = 4, description = "Авторизованная зона. Предприятие. Моя Лента. Витрина Решений", enabled = false)
    public void MyFeed_SolutionShowcase_TEST() throws SQLException {
        HomeEnterprisePage homeEnterprisePage = open(ConfigProviderInterface.authorizedEnterpriseURL, HomeEnterprisePage.class);
       homeEnterprisePage.getSolutionShowcaseWidgetDataFromApi();
       homeEnterprisePage.getSolutionShowcaseWidgetDataFromDB();
       homeEnterprisePage.Assert_MyFeed_SolutionShowcase_Header();
       homeEnterprisePage.Assert_MyFeed_SolutionShowcase_Text();
       homeEnterprisePage.Assert_MyFeed_SolutionShowcase_Count();

    }

    @Test(priority = 5, description = "Авторизованная зона. Предприятие. Моя Лента. Рекомендуемая статья", enabled = false)
    public void MyFeed_RecommendedArticle_TEST() throws IOException {
        HomeEnterprisePage homeEnterprisePage = open(ConfigProviderInterface.authorizedEnterpriseURL, HomeEnterprisePage.class);
        homeEnterprisePage.getRecommendedArticleWidgetDataFromApi(super.proxy);
        homeEnterprisePage.Assert_MyFeed_RecommendedArticle_Title();
        homeEnterprisePage.Assert_MyFeed_RecommendedArticle_Description();
    }

    @Test(priority = 6, description = "Авторизованная зона. Предприятие. Моя Лента. Поиск в Базе знаний", enabled = false)
    public void MyFeed_KnowledgeBaseSearch_TEST(){
        HomeEnterprisePage homeEnterprisePage = open(ConfigProviderInterface.authorizedEnterpriseURL, HomeEnterprisePage.class);
        homeEnterprisePage.getKnowledgeBaseSearchWidgetAfterNotEmptySearch(super.proxy, "");
        homeEnterprisePage.Assert_MyFeed_KnowledgeBaseSearch_AfterSearch();
        homeEnterprisePage.getKnowledgeBaseSearchWidgetAfterNotEmptySearch(super.proxy, homeEnterprisePage.MyFeed_KnowledgeBaseSearch_GetArticleTitleForSearch());
        homeEnterprisePage.Assert_MyFeed_KnowledgeBaseSearch_AfterSearch();
    }

    @Test(priority = 7, description = "Авторизованная зона. Предприятие. Моя Лента. HTML Виджет контрагента 1", enabled = false)
    public void MyFeed_HTML_Widget_First_Counterparty_TEST() throws IOException {
        HomeEnterprisePage homeEnterprisePage = open(ConfigProviderInterface.authorizedEnterpriseURL, HomeEnterprisePage.class);
        homeEnterprisePage.TakeScreenshotOfCounterpartyWidget1(getEnvironment());
        boolean result_of_comparing = homeEnterprisePage.compareScreenshotsOfCounterpartyWidget1(getEnvironment());
        Assert.assertTrue(result_of_comparing, "Скриншоты не совпали. Вёрстка не такая, как в макете");
    }

    @Test(priority = 8, description = "Авторизованная зона. Предприятие. Моя Лента. HTML Виджет контрагента 2", enabled = false)
    public void MyFeed_HTML_Widget_Second_Counterparty_TEST() throws IOException {
        HomeEnterprisePage homeEnterprisePage = open(ConfigProviderInterface.authorizedEnterpriseURL, HomeEnterprisePage.class);
        homeEnterprisePage.TakeScreenshotOfCounterpartyWidget2(getEnvironment());
        boolean result_of_comparing = homeEnterprisePage.compareScreenshotsOfCounterpartyWidget2(getEnvironment());
        Assert.assertTrue(result_of_comparing, "Скриншоты не совпали. Вёрстка не такая, как в макете");
    }

    @Test(priority = 9, description = "Авторизованная зона. Предприятие. Проекты с экспертной поддержкой")
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
