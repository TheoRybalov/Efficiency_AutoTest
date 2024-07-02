package Efficiency.Tests;

import Efficiency.Pages.ProvidersPage;
import Efficiency.Providers.ConfigProviderInterface;
import Efficiency.TestBase;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.open;

public class PROVIDERS extends TestBase {
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
}
