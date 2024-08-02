package Efficiency.Tests;

import Efficiency.Pages.AboutNationalProject;
import Efficiency.Pages.PressCenterPage;
import Efficiency.Providers.ConfigProviderInterface;
import Efficiency.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.open;

public class ABOUT_NATIONAL_PROJECT extends TestBase {
    public String getMode(){
        return super.getMode();
    }
    @Test(priority = 1, description = "Пресс-Центр. Проверка ссылок под заголовком 'Пресс-центр'")
    public void NationalProjectLinks_TEST() throws IOException {
        AboutNationalProject aboutNationalProject = open(ConfigProviderInterface.nationalProjectURL, AboutNationalProject.class);
        aboutNationalProject.PassportTargetedSupportLink_Redirect(getMode());
        aboutNationalProject.PassportSystemicMeasuresLink_Redirect(getMode());
        aboutNationalProject.PassportLaborProductivityLink_Redirect(getMode());
        aboutNationalProject.ProjectPresentationLink_Redirect();
        aboutNationalProject.AboutProjectOnSiteLink_Redirect();
    }

    public String getEnvironment() {return super.getEnv();}

    @Test(priority = 2, description = "Страница 'О национальном проекте'. Проверка верстки по скриншотам")
    public void MarkupScreenshot_TEST() throws IOException {
        AboutNationalProject aboutNationalProject = open(ConfigProviderInterface.nationalProjectURL, AboutNationalProject.class);
        aboutNationalProject.AcceptCookies();
        aboutNationalProject.TakeScreenshotOfFullPage(getEnvironment());
        Boolean result_of_comparing = aboutNationalProject.compareScreenshotsOfFullPage(getEnvironment());
        Assert.assertTrue(result_of_comparing, "Скриншоты не совпали. Вёрстка не такая, как в макете");
    }
}
