package Efficiency.Tests;

import Efficiency.Pages.HomePage;
import Efficiency.Pages.IndustriesPage;
import Efficiency.Providers.ConfigProviderInterface;
import Efficiency.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.open;

public class HOME extends TestBase {

    public String getEnvironment(){
        return super.getEnv();
    }

    @Test(priority = 1, description = "Домашняя страница. Изменение кнопки 'Смотреть видео о платформе' ", enabled = false)
    public void PlatesCorrectData_TEST() throws IOException {
        HomePage homePage = open(ConfigProviderInterface.baseURL, HomePage.class);

    }

    @Test(priority = 1, description = "Домашняя страница. Редиректы на хэдере")
    public void Header_TEST() throws IOException {
        HomePage homePage = open(ConfigProviderInterface.baseURL, HomePage.class);
        homePage.Header_ServicesLink_Redirect();
        homePage.Header_IndustriesLink_Redirect();
        homePage.Header_EnterpriseLink_Redirect();
        homePage.Header_ProvidersLink_Redirect();
        homePage.Header_AboutProjectLink_Redirect();
        homePage.Header_PressCenterLink_Redirect();

    }

    @Test(priority = 2, description = "Домашняя страница. Редиректы на футере ")
    public void Footer_TEST() throws IOException {
        HomePage homePage = open(ConfigProviderInterface.baseURL, HomePage.class);
        homePage.Footer_ServicesLink_Redirect();
        homePage.Footer_ProvidersLink_Redirect();
        homePage.Footer_FAQLink();
        homePage.Footer_IndustriesLink_Redirect();
        homePage.Footer_PressCenterLink_Redirect();
        homePage.Footer_ContactsLink_Redirect();
        homePage.Footer_BecomeParticipantLink_Redirect();
        homePage.Footer_BecomeProviderLink_Redirect();
        homePage.Footer_VKLink_Redirect();
        homePage.Footer_TelegramLink_Redirect();

    }

    @Test(priority = 3, description = "Домашняя страница. Редиректы в разделе 'Наши отрасли'")
    public void OurIndustries_TEST() throws IOException {
        HomePage homePage = open(ConfigProviderInterface.baseURL, HomePage.class);
        homePage.SelskoyeHozaystvoLink_Redirect();
        homePage.ManufacrturingIndustriesLink_Redirect();
        homePage.ConstructionLink_Redirect();
        homePage.TradingLink_Redirect();
        homePage.TransportLink_Redirect();
    }

    @Test(priority = 4, description = "Домашняя страница. Анимация кнопки 'Смотреть видео о платформе'")
    public void VideoAboutPlatformAnimation_TEST() throws IOException {
        HomePage homePage = open(ConfigProviderInterface.baseURL, HomePage.class);
        homePage.TakeScreenshotOfVideoButtonBeforeAnimation(getEnvironment());
        homePage.VideoAboutPlatformButton_Hover();
        homePage.TakeScreenshotOfVideoButtonAfterAnimation(getEnvironment());
        boolean ResultOfComparing = homePage.compareScreenshotsOfVideoButton(getEnvironment());
        Assert.assertFalse(ResultOfComparing, "Скриншоты совпали. Анимация не сработала");
    }



}
