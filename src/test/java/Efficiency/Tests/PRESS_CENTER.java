package Efficiency.Tests;

import Efficiency.Pages.PressCenterPage;
import Efficiency.Providers.ConfigProviderInterface;
import Efficiency.TestBase;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

import static com.codeborne.selenide.Selenide.open;

public class PRESS_CENTER extends TestBase {

    @Test(priority = 1, description = "Пресс-Центр. Новости платформы. Проверка заголовков новостей", enabled = false)
    public void PlatformNews_TEST() throws IOException, SQLException {
        PressCenterPage pressCenterPage = open(ConfigProviderInterface.pressCenterURL, PressCenterPage.class);
        String newsTitleFromSite = pressCenterPage.getFirstLabelOfNewsPlatform();
        long id = pressCenterPage.getIdFromApi(newsTitleFromSite);
        String newsTitleFromDB = pressCenterPage.getNewsTitleFromDatabase(id);

        pressCenterPage.compareNewsTitles(newsTitleFromSite, newsTitleFromDB);

    }
    @Test(priority = 2, description = "Пресс-Центр. Проверка ссылок под заголовком 'Пресс-центр'")
    public void HeaderLinks_TEST() throws IOException {
        PressCenterPage pressCenterPage = open(ConfigProviderInterface.pressCenterURL, PressCenterPage.class);
        pressCenterPage.MaterialsLink_Redirect();
    }

    @Test(priority = 3, description = "Пресс-Центр. Проверка ссылок в разделе 'Материалы'")
    public void DownloadLinks_TEST() throws IOException {
        PressCenterPage pressCenterPage = open(ConfigProviderInterface.pressCenterURL, PressCenterPage.class);
        pressCenterPage.DownloadPresentation_Redirect();
        pressCenterPage.DownloadPlatformLink_Redirect();
        pressCenterPage.PostingRecommendationsLink_Redirect();
    }

    @Test(priority = 4, description = "Пресс-центр. Проверка ссылки в разделе 'Новости платформы'")
    public void NewsPlatform_TEST() throws IOException {
        PressCenterPage pressCenterPage = open(ConfigProviderInterface.pressCenterURL, PressCenterPage.class);
        pressCenterPage.AllNewsPlatform_Link_Redirect();
    }

    @Test(priority = 4, description = "Пресс-центр. Проверка ссылки в разделе 'Новости нацпроекта'")
    public void NewsProject_TEST() throws IOException {
        PressCenterPage pressCenterPage = open(ConfigProviderInterface.pressCenterURL, PressCenterPage.class);
        pressCenterPage.AllNewsProject_Link_Redirect();
    }

    @Test(priority = 4, description = "Пресс-центр. Проверка ссылки в разделе 'Мероприятия'")
    public void Events_TEST() throws IOException {
        PressCenterPage pressCenterPage = open(ConfigProviderInterface.pressCenterURL, PressCenterPage.class);
        pressCenterPage.AllEvents_Link_Redirect();
    }

}
