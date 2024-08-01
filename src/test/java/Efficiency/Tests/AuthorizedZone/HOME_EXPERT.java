package Efficiency.Tests.AuthorizedZone;

import Efficiency.Pages.AuthorizedZone.HomeEnterprisePage;
import Efficiency.Pages.AuthorizedZone.HomeExpertPage;
import Efficiency.Pages.LoginPage;
import Efficiency.Providers.ConfigProviderInterface;
import Efficiency.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
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
    }

    @Test(priority = 1, description = "Авторизованная зона. Боковое меню")
    public void Side_Menu_TEST(){
        HomeExpertPage homeExpertPage = open(ConfigProviderInterface.authorizedExpertURL, HomeExpertPage.class);
        homeExpertPage.getSideMenuDataFromApi();
        homeExpertPage.Assert_SideMenu_WidgetData_Titles();
        homeExpertPage.Assert_SideMenu_WidgetData_URLs();
        homeExpertPage.Assert_SideMenu_ServicesData_Titles();
        homeExpertPage.Assert_SideMenu_ServicesData_URLs();
    }
    @Test(priority = 1, description = "Авторизованная зона. Моя Лента.Виджет 'Витрина решений'")
    public void MyFeed_Solutions_TEST() throws SQLException {
        HomeExpertPage homeExpertPage = open(ConfigProviderInterface.authorizedExpertURL, HomeExpertPage.class);
        homeExpertPage.getSolutionsWidgetDataFromDB();
        homeExpertPage.getSolutionsWidgetDataFromApi();
        homeExpertPage.Assert_MyFeed_Solutions_Header();
        homeExpertPage.Assert_MyFeed_Solutions_Text();
        homeExpertPage.Assert_MyFeed_Solutions_Quantity();
    }

    @Test(priority = 2, description = "Моя Лента. Виджет 'Сообщения в чате'")
    public void MyFeed_ChatStatistic_TEST() throws SQLException {
        HomeExpertPage homeExpertPage = open(ConfigProviderInterface.authorizedExpertURL, HomeExpertPage.class);
        homeExpertPage.getChatStatisticWidgetDataFromDB();
        homeExpertPage.getChatStatisticWidgetDataFromApi();
        homeExpertPage.Assert_MyFeed_ChatStatistic_Header();
        homeExpertPage.Assert_MyFeed_ChatStatistic_Unread_Text();
        homeExpertPage.Assert_MyFeed_ChatStatistic_Unanswered_Text();
        homeExpertPage.Assert_MyFeed_ChatStatistic_Unread_Quantity();
        homeExpertPage.Assert_MyFeed_ChatStatistic_Unanswered_Quantity();
    }

    @Test(priority = 3, description = "Авторизованная зона. Предприятие. Моя Лента. Рекомендуемая статья")
    public void MyFeed_RecommendedArticle_TEST(){
        HomeExpertPage homeExpertPage = open(ConfigProviderInterface.authorizedExpertURL, HomeExpertPage.class);
        homeExpertPage.getRecommendedArticleWidgetDataFromApi(super.proxy);
        homeExpertPage.Assert_MyFeed_RecommendedArticle_Title();
        homeExpertPage.Assert_MyFeed_RecommendedArticle_Description();
    }

    @Test(priority = 4, description = "Авторизованная зона. Предприятие. Моя Лента. Поиск в Базе знаний")
    public void MyFeed_KnowledgeBaseSearch_TEST(){
        HomeExpertPage homeExpertPage = open(ConfigProviderInterface.authorizedExpertURL, HomeExpertPage.class);
        homeExpertPage.getKnowledgeBaseSearchWidgetAfterNotEmptySearch(super.proxy, "");
        homeExpertPage.Assert_MyFeed_KnowledgeBaseSearch_AfterSearch();
        homeExpertPage.getKnowledgeBaseSearchWidgetAfterNotEmptySearch(super.proxy, homeExpertPage.MyFeed_KnowledgeBaseSearch_GetArticleTitleForSearch());
        homeExpertPage.Assert_MyFeed_KnowledgeBaseSearch_AfterSearch();
    }

    @Test(priority = 5, description = "Авторизованная зоня. Виджет Контур Фокус")
    public void Counter_Agent_Display_TEST() throws IOException {
        HomeExpertPage homeExpertPage = open(ConfigProviderInterface.authorizedExpertURL, HomeExpertPage.class);
        homeExpertPage.Counter_Agent_Visible();
        homeExpertPage.TakeScreenshotOfCounterAgentSection(getEnvironment());
        boolean ResultOfComparing = homeExpertPage.compareScreenshotsOfCounterAgent(getEnvironment());
        Assert.assertTrue(ResultOfComparing, "Скриншоты не совпали. Вёрстка не такая, как в макете");
    }

}
