package Efficiency.Tests.AuthorizedZone;

import Efficiency.Pages.AuthorizedZone.HomeEnterprisePage;
import Efficiency.Pages.AuthorizedZone.HomeExpertPage;
import Efficiency.Pages.AuthorizedZone.HomeProviderPage;
import Efficiency.Pages.LoginPage;
import Efficiency.Providers.ConfigProviderInterface;
import Efficiency.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

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

    @Test(priority = 2, description = "Авторизованная зона. Предприятие. Моя Лента. Рекомендуемая статья")
    public void MyFeed_RecommendedArticle_TEST(){
        HomeProviderPage homeProviderPage = open(ConfigProviderInterface.authorizedProviderURL, HomeProviderPage.class);
        homeProviderPage.getRecommendedArticleWidgetDataFromApi(super.proxy);
        homeProviderPage.Assert_MyFeed_RecommendedArticle_Title();
        homeProviderPage.Assert_MyFeed_RecommendedArticle_Description();
    }

    @Test(priority = 3, description = "Авторизованная зона. Предприятие. Моя Лента. Поиск в Базе знаний")
    public void MyFeed_KnowledgeBaseSearch_TEST(){
        HomeProviderPage homeProviderPage = open(ConfigProviderInterface.authorizedProviderURL, HomeProviderPage.class);
        homeProviderPage.getKnowledgeBaseSearchWidgetAfterNotEmptySearch(super.proxy, "");
        homeProviderPage.Assert_MyFeed_KnowledgeBaseSearch_AfterSearch();
        homeProviderPage.getKnowledgeBaseSearchWidgetAfterNotEmptySearch(super.proxy, homeProviderPage.MyFeed_KnowledgeBaseSearch_GetArticleTitleForSearch());
        homeProviderPage.Assert_MyFeed_KnowledgeBaseSearch_AfterSearch();
    }

    @Test(priority = 5, description = "Авторизованная зоня. Виджет Контур Фокус")
    public void Counter_Agent_Display_TEST() throws IOException {
        HomeProviderPage homeProviderPage = open(ConfigProviderInterface.authorizedProviderURL, HomeProviderPage.class);
        homeProviderPage.Counter_Agent_Visible();
        homeProviderPage.TakeScreenshotOfCounterAgentSection(getEnvironment());
        boolean ResultOfComparing = homeProviderPage.compareScreenshotsOfCounterAgent(getEnvironment());
        Assert.assertTrue(ResultOfComparing, "Скриншоты не совпали. Вёрстка не такая, как в макете");
    }
}
