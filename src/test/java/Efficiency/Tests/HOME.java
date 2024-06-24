package Efficiency.Tests;

import Efficiency.Pages.HomePage;
import Efficiency.Pages.IndustriesPage;
import Efficiency.Providers.ConfigProviderInterface;
import Efficiency.TestBase;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.open;

public class HOME extends TestBase {

    public String getEnvironment(){
        return super.getEnv();
    }

    @Test(priority = 1, description = "Домашняя страница. Изменение кнопки 'Смотреть видео о платформе' ")
    public void PlatesCorrectData_TEST() throws IOException {
        HomePage homePage = open(ConfigProviderInterface.baseURL, HomePage.class);

    }
}
