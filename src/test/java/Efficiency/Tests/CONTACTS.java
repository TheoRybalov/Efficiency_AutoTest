package Efficiency.Tests;

import Efficiency.Pages.ContactsPage;
import Efficiency.Pages.FaqPage;
import Efficiency.Providers.ConfigProviderInterface;
import Efficiency.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.open;


public class CONTACTS extends TestBase {

    public String getEnvironment(){
        return super.getEnv();
    }

    @Test(priority = 1,description = "Контакты. Тест вёрстки через скриншот")
    public void LayoutScreenshot_TEST() throws IOException {
        ContactsPage contactsPage = open(ConfigProviderInterface.contactsURL,ContactsPage.class);
        contactsPage.AddCookies();
        contactsPage.TakeScreenshotOfFullPage(getEnvironment());
        boolean ResultOfComparing = contactsPage.compareScreenshotsOfFullPage(getEnvironment());
        Assert.assertTrue(ResultOfComparing,"Скриншоты не совпали. Вёрстка не такая, как в макете");
    }
}
