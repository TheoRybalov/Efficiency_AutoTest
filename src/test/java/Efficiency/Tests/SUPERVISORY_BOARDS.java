package Efficiency.Tests;

import Efficiency.Pages.ContactsPage;
import Efficiency.Pages.SupervisoryBoardsPage;
import Efficiency.Providers.ConfigProviderInterface;
import Efficiency.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.open;

public class SUPERVISORY_BOARDS extends TestBase {

    public String getEnvironment(){
        return super.getEnv();
    }

    @Test(priority = 4,description = "Вопросы и ответы. Тест вёрстки через скриншот")
    public void LayoutScreenshot_TEST() throws IOException {
        SupervisoryBoardsPage supervisoryBoards = open(ConfigProviderInterface.supervisoryBoardsURL, SupervisoryBoardsPage.class);
        supervisoryBoards.AddCookies();
        supervisoryBoards.TakeScreenshotOfFullPage(getEnvironment());
        boolean ResultOfComparing = supervisoryBoards.compareScreenshotsOfFullPage(getEnvironment());
        Assert.assertTrue(ResultOfComparing,"Скриншоты не совпали. Вёрстка не такая, как в макете");
    }
}
