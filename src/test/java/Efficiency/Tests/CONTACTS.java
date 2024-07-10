package Efficiency.Tests;

import Efficiency.Pages.ContactsPage;
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

<<<<<<< HEAD
    @Test(priority = 1,description = "Контакты. Тест вёрстки через скриншот")
=======
    @Test(priority = 1,description = "Контакты. Тест вёрстки через скриншот",enabled = false)
>>>>>>> 5adb282277f0525aa0134854a0addc20faae3563
    public void LayoutScreenshot_TEST() throws IOException {
        ContactsPage contactsPage = open(ConfigProviderInterface.contactsURL,ContactsPage.class);
        contactsPage.AddCookies();
        contactsPage.TakeScreenshotOfFullPage(getEnvironment());
        boolean ResultOfComparing = contactsPage.compareScreenshotsOfFullPage(getEnvironment());
        Assert.assertTrue(ResultOfComparing,"Скриншоты не совпали. Вёрстка не такая, как в макете");
    }

    @Test(priority = 2,description = "Контакты. Тест отправки сообщения")
    public void SendFeedback_TEST(){
        ContactsPage contactsPage = open(ConfigProviderInterface.contactsURL,ContactsPage.class);
        contactsPage.SendFeedback();
    }
}
