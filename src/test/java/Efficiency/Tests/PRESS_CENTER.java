package Efficiency.Tests;

import Efficiency.Pages.PressCenterPage;
import Efficiency.Pages.ProvidersPage;
import Efficiency.Providers.ConfigProviderInterface;
import Efficiency.TestBase;
import com.typesafe.config.ConfigException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import static com.codeborne.selenide.Selenide.open;

public class PRESS_CENTER extends TestBase {

    public String getEnvironment(){
        return super.getEnv();
    }

//    @Test(priority = 1, description = "Пресс-Центр. Новости платформы. Проверка заголовков новостей")
//    public void PlatformNews_TEST() throws IOException, SQLException {
//        PressCenterPage pressCenterPage = open(ConfigProviderInterface.pressCenterURL, PressCenterPage.class);
//
//        String FirstNewsPlatformLabel = pressCenterPage.getFirstLabelOfNewsPlatform();
//        Map<String, Object> apiNewsData = pressCenterPage.getPlatformNewsDataFromApi( FirstNewsPlatformLabel);
//        Long contentItemId = ((Number) apiNewsData.get("id")).longValue();
//        Map<String, Object> dbNewsData = pressCenterPage.getNewsFromDatabase(contentItemId);
//        pressCenterPage.compareNewsData(dbNewsData, apiNewsData);
//
//        String SecondNewsPlatformLabel = pressCenterPage.getSecondLabelOfNewsPlatform();
//        apiNewsData = pressCenterPage.getPlatformNewsDataFromApi(SecondNewsPlatformLabel);
//        contentItemId = ((Number) apiNewsData.get("id")).longValue();
//        dbNewsData = pressCenterPage.getNewsFromDatabase(contentItemId);
//        pressCenterPage.compareNewsData(dbNewsData, apiNewsData);
//
//        String ThirdNewsPlatformLabel = pressCenterPage.getThirdLabelOfNewsPlatform();
//        apiNewsData = pressCenterPage.getPlatformNewsDataFromApi(ThirdNewsPlatformLabel);
//        contentItemId = ((Number) apiNewsData.get("id")).longValue();
//        dbNewsData = pressCenterPage.getNewsFromDatabase(contentItemId);
//        pressCenterPage.compareNewsData(dbNewsData, apiNewsData);
//
//    }
//
//    @Test(priority = 2, description = "Пресс-Центр. Новости нацпроекта. Проверка заголовков новостей")
//    public void NationalProjectNews_TEST() throws IOException, SQLException {
//        PressCenterPage pressCenterPage = open(ConfigProviderInterface.pressCenterURL, PressCenterPage.class);
//
//        String FirstNewsNationalProjectLabel = pressCenterPage.getFirstLabelOfNewsNationalProject();
//        Map<String, Object> apiNewsData = pressCenterPage.getNationalProjectNewsDataFromApi( FirstNewsNationalProjectLabel);
//        Long contentItemId = ((Number) apiNewsData.get("id")).longValue();
//        Map<String, Object> dbNewsData = pressCenterPage.getNewsFromDatabase(contentItemId);
//        pressCenterPage.compareNewsData(dbNewsData, apiNewsData);
//
//        String SecondNewsNationalProjectLabel = pressCenterPage.getSecondLabelOfNewsNationalProject();
//        apiNewsData = pressCenterPage.getNationalProjectNewsDataFromApi(SecondNewsNationalProjectLabel);
//        contentItemId = ((Number) apiNewsData.get("id")).longValue();
//        dbNewsData = pressCenterPage.getNewsFromDatabase(contentItemId);
//        pressCenterPage.compareNewsData(dbNewsData, apiNewsData);
//
//        String ThirdNewsNationalProjectLabel = pressCenterPage.getThirdLabelOfNewsNationalProject();
//        apiNewsData = pressCenterPage.getNationalProjectNewsDataFromApi(ThirdNewsNationalProjectLabel);
//        contentItemId = ((Number) apiNewsData.get("id")).longValue();
//        dbNewsData = pressCenterPage.getNewsFromDatabase(contentItemId);
//        pressCenterPage.compareNewsData(dbNewsData, apiNewsData);
//
//    }
//
//    @Test(priority = 5, description = "Пресс-Центр. Тест вёрстки через скриншот")
//    public void LayoutScreenshot_TEST() throws IOException {
//        PressCenterPage pressCenterPage = open(ConfigProviderInterface.pressCenterURL, PressCenterPage.class);
//        pressCenterPage.AddCookies();
//
//        pressCenterPage.TakeScreenshotOfPressCenterSection(getEnvironment());
//        boolean ResultOfComparing = pressCenterPage.compareScreenshotsOfSection(getEnvironment(), "PressCenterSection");
//        Assert.assertTrue(ResultOfComparing, "Скриншоты не совпали. Вёрстка не такая, как в макете");
//
//        pressCenterPage.TakeScreenshotOfMaterialsSection(getEnvironment());
//        ResultOfComparing = pressCenterPage.compareScreenshotsOfSection(getEnvironment(), "MaterialsSection");
//        Assert.assertTrue(ResultOfComparing, "Скриншоты не совпали. Вёрстка не такая, как в макете");
//
//        pressCenterPage.TakeScreenshotOfContactsSection(getEnvironment());
//        ResultOfComparing = pressCenterPage.compareScreenshotsOfSection(getEnvironment(), "ContactsSection");
//        Assert.assertTrue(ResultOfComparing, "Скриншоты не совпали. Вёрстка не такая, как в макете");
//
//        pressCenterPage.TakeScreenshotOfFooterSection(getEnvironment());
//        ResultOfComparing = pressCenterPage.compareScreenshotsOfSection(getEnvironment(), "FooterSection");
//        Assert.assertTrue(ResultOfComparing, "Скриншоты не совпали. Вёрстка не такая, как в макете");
//    }
//
//    @Test(priority = 2, description = "Пресс-Центр. Проверка ссылок под заголовком 'Пресс-центр'")
//    public void HeaderLinks_TEST() throws IOException {
//        PressCenterPage pressCenterPage = open(ConfigProviderInterface.pressCenterURL, PressCenterPage.class);
//        pressCenterPage.MaterialsLink_Redirect();
//    }
//
//    @Test(priority = 3, description = "Пресс-Центр. Проверка ссылок в разделе 'Материалы'")
//    public void DownloadLinks_TEST() throws IOException {
//        PressCenterPage pressCenterPage = open(ConfigProviderInterface.pressCenterURL, PressCenterPage.class);
//        pressCenterPage.DownloadPresentation_Redirect();
//        pressCenterPage.DownloadPlatformLink_Redirect();
//        pressCenterPage.PostingRecommendationsLink_Redirect();
//    }
//
//    @Test(priority = 4, description = "Пресс-центр. Проверка ссылки в разделе 'Новости платформы'")
//    public void NewsPlatform_TEST() throws IOException {
//        PressCenterPage pressCenterPage = open(ConfigProviderInterface.pressCenterURL, PressCenterPage.class);
//        pressCenterPage.AllNewsPlatform_Link_Redirect();
//    }
//
//    @Test(priority = 4, description = "Пресс-центр. Проверка ссылки в разделе 'Новости нацпроекта'")
//    public void NewsProject_TEST() throws IOException {
//        PressCenterPage pressCenterPage = open(ConfigProviderInterface.pressCenterURL, PressCenterPage.class);
//        pressCenterPage.AllNewsProject_Link_Redirect();
//    }
//
//    @Test(priority = 4, description = "Пресс-центр. Проверка ссылки в разделе 'Мероприятия'")
//    public void Events_TEST() throws IOException {
//        PressCenterPage pressCenterPage = open(ConfigProviderInterface.pressCenterURL, PressCenterPage.class);
//        pressCenterPage.AllEvents_Link_Redirect();
//    }

    @Test(priority = 9, description = "Пресс-центр. Проверка репозиционариования по кнопкам 'Материалы', 'Новости платформы', 'Новости нацпроекта', 'Контакты'")
    public void RepositioningButtons_TEST() throws IOException{
        PressCenterPage pressCenterPage = open(ConfigProviderInterface.pressCenterURL, PressCenterPage.class);
        pressCenterPage.Contacts_Repositioning();
        pressCenterPage.NewsPlatform_Repositioning();
        pressCenterPage.Materials_Repositioning();
        pressCenterPage.NewsProject_Repositioning();
    }

}
