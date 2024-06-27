package Efficiency.Tests;

import Efficiency.Pages.HomePage;
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

    @Test(priority = 1, description = "Домашняя страница. Редиректы на хэдере", enabled = false)
    public void Header_TEST() throws IOException {
        HomePage homePage = open(ConfigProviderInterface.baseURL, HomePage.class);
        homePage.Header_ServicesLink_Redirect();
        homePage.Header_IndustriesLink_Redirect();
        homePage.Header_EnterpriseLink_Redirect();
        homePage.Header_ProvidersLink_Redirect();
        homePage.Header_AboutProjectLink_Redirect();
        homePage.Header_PressCenterLink_Redirect();

    }

    @Test(priority = 2, description = "Домашняя страница. Редиректы на футере ", enabled = false)
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

    @Test(priority = 3, description = "Домашняя страница. Редиректы в разделе 'Наши отрасли'", enabled = false)
    public void OurIndustries_TEST() throws IOException {
        HomePage homePage = open(ConfigProviderInterface.baseURL, HomePage.class);
        homePage.SelskoyeHozaystvoLink_Redirect();
        homePage.ManufacrturingIndustriesLink_Redirect();
        homePage.ConstructionLink_Redirect();
        homePage.TradingLink_Redirect();
        homePage.TransportLink_Redirect();
    }

    @Test(priority = 4, description = "Домашняя страница. Анимация кнопки 'Смотреть видео о платформе'", enabled = false)
    public void VideoAboutPlatformAnimation_TEST() throws IOException {
        HomePage homePage = open(ConfigProviderInterface.baseURL, HomePage.class);
        homePage.TakeScreenshotOfVideoButtonBeforeAnimation(getEnvironment());
        homePage.VideoAboutPlatformButton_Hover();
        homePage.TakeScreenshotOfVideoButtonAfterAnimation(getEnvironment());
        boolean ResultOfComparing = homePage.compareScreenshotsOfVideoButton(getEnvironment());
        Assert.assertFalse(ResultOfComparing, "Скриншоты совпали. Анимация не сработала");
    }

    @Test(priority = 5, description = "Домашняя страница. Тест вёрстки через скриншот", enabled = false)
    public void LayoutScreenshot_TEST() throws IOException {
        HomePage homePage = open(ConfigProviderInterface.baseURL, HomePage.class);
        homePage.AddCookies();
        homePage.TakeScreenshotOfFullPage(getEnvironment());
        boolean ResultOfComparing = homePage.compareScreenshotsOfFullPage(getEnvironment());
        Assert.assertTrue(ResultOfComparing, "Скриншоты не совпали. Вёрстка не такая, как в макете");
    }
    @Test(priority = 6, description = "Домашняя страница. Редиректы на 'Путь цифровой трансформации'")
    public void TransformationRedirect_TEST() throws IOException {
        HomePage homePage = open(ConfigProviderInterface.baseURL, HomePage.class);
        homePage.TransformationFinancingServiceLink_Redirect();
        homePage.TransformationImplementationServiceLink_Redirect();
        homePage.TransformationInitiationServiceLink_Redirect();
        homePage.TransformationStrategyServiceLink_Redirect();
    }
    @Test(priority = 7, description = "Домашняя страница. Проверка отображения данных по нажатию на 'Стратегия','Инициация','Финансирование','Реализация'")
    public void TransformationVisible_TEST() throws IOException {
        HomePage homePage = open(ConfigProviderInterface.baseURL, HomePage.class);
        homePage.TransformationInitiation_Visible();
        homePage.TransformationFinancing_Visible();
        homePage.TransformationImplementation_Visible();
        homePage.TransformationStrategy_Visible();
    }
    @Test(priority = 8, description = "Проверка работоспособности кнопки 'Смотреть видео о платформе'")
    public void VideoAboutPlatformButton_Performance() throws IOException {
        HomePage homePage = open(ConfigProviderInterface.baseURL, HomePage.class);
        homePage.VideoAboutPlatformButton_Performance();
    }


}
