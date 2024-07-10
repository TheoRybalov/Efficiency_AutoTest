package Efficiency.Tests;

import Efficiency.Pages.AboutNationalProject;
import Efficiency.Pages.AboutProjectPage;
import Efficiency.Pages.HomePage;
import Efficiency.Providers.ConfigProviderInterface;
import Efficiency.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.open;

public class ABOUT_PROJECT extends TestBase {
    public String getEnvironment(){
        return super.getEnv();
    }
    @Test(priority = 1, description = "Об операторе. Тест вёрстки через скриншот")
    public void LayoutScreenshot_TEST() throws IOException {
        AboutProjectPage aboutProjectPage = open(ConfigProviderInterface.aboutProjectURL, AboutProjectPage.class);
        aboutProjectPage.AddCookies();
        aboutProjectPage.TakeScreenshotOfFullPage(getEnvironment());
        boolean ResultOfComparing = aboutProjectPage.compareScreenshotsOfFullPage(getEnvironment());
        Assert.assertTrue(ResultOfComparing, "Скриншоты не совпали. Вёрстка не такая, как в макете");
    }
}
