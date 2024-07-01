package Efficiency.Tests;

import Efficiency.Pages.AboutNationalProject;
import Efficiency.Pages.PressCenterPage;
import Efficiency.Providers.ConfigProviderInterface;
import Efficiency.TestBase;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.open;

public class ABOUT_NATIONAL_PROJECT extends TestBase {
    @Test(priority = 1, description = "Пресс-Центр. Проверка ссылок под заголовком 'Пресс-центр'")
    public void NationalProjectLinks_TEST() throws IOException {
        AboutNationalProject aboutNationalProject = open(ConfigProviderInterface.nationalProjectURL, AboutNationalProject.class);
        aboutNationalProject.PassportTargetedSupportLink_Redirect();
        aboutNationalProject.PassportSystemicMeasuresLink_Redirect();
        aboutNationalProject.PassportTargetedSupportLink_Redirect();
        aboutNationalProject.ProjectPresentationLink_Redirect();
        aboutNationalProject.AboutProjectOnSiteLink_Redirect();
    }
}
