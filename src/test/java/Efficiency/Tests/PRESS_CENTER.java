package Efficiency.Tests;

import Efficiency.Pages.PressCenterPage;
import Efficiency.Providers.ConfigProviderInterface;
import Efficiency.TestBase;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

import static com.codeborne.selenide.Selenide.open;

public class PRESS_CENTER extends TestBase {

    @Test(priority = 2, description = "Пресс-Центр. Новости платформы. Проверка заголовков новостей")
    public void PlatformNews_TEST() throws IOException, SQLException {
        PressCenterPage pressCenterPage = open(ConfigProviderInterface.pressCenterURL, PressCenterPage.class);
        String newsTitleFromSite = pressCenterPage.getFirstLabelOfNewsPlatform();
        long id = pressCenterPage.getIdFromApi(newsTitleFromSite);
        String newsTitleFromDB = pressCenterPage.getNewsTitleFromDatabase(id);

        pressCenterPage.compareNewsTitles(newsTitleFromSite, newsTitleFromDB);

    }
}
