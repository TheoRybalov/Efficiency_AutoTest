package Efficiency.Tests;

import Efficiency.Pages.HomePage;
import Efficiency.Pages.ProvidersPage;
import Efficiency.Providers.ConfigProviderInterface;
import Efficiency.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.open;

public class PROVIDERS extends TestBase {

    public String getEnvironment(){
        return super.getEnv();
    }
    @Test(priority = 1, description = "Страница 'Поставщикам'. Редирект 'Заполнить анкету поставщика'")
    public void PerformanceLink_TEST() throws IOException {
        ProvidersPage providersPage = open(ConfigProviderInterface.providersURL, ProvidersPage.class);
        providersPage.ProviderFormLink_Redirect();
    }

    @Test(priority = 2, description = "Страница 'Поставщикам'. Редирект 'Стать поставщиком'")
    public void BecomeAProviderLink_TEST() throws IOException {
        ProvidersPage providersPage = open(ConfigProviderInterface.providersURL, ProvidersPage.class);
        providersPage.BecomeAProviderLink_Redirect();
    }

    @Test(priority = 3, description = "Страница 'Поставщикам'. Редирект 'Войти как поставщик'")
    public void LoginAsProviderLink_TEST() throws IOException {
        ProvidersPage providersPage = open(ConfigProviderInterface.providersURL, ProvidersPage.class);
        providersPage.LoginAsProviderLink_Redirect();
    }

    @Test(priority = 5, description = "Страница 'Поставщикам'. Тест вёрстки через скриншот")
    public void LayoutScreenshot_TEST() throws IOException {
        ProvidersPage providersPage = open(ConfigProviderInterface.providersURL, ProvidersPage.class);
        providersPage.AddCookies();
        providersPage.TakeScreenshotOfFullPage(getEnvironment());
        boolean ResultOfComparing = providersPage.compareScreenshotsOfFullPage(getEnvironment());
        Assert.assertTrue(ResultOfComparing, "Скриншоты не совпали. Вёрстка не такая, как в макете");
    }
}
