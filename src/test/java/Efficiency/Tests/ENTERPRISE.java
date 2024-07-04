package Efficiency.Tests;

import Efficiency.Pages.EnterprisePage;
import Efficiency.Providers.ConfigProviderInterface;
import Efficiency.TestBase;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.open;

public class ENTERPRISE extends TestBase {

    //Получение окружения для тестирования верстки
    public String getEnvironment() {return super.getEnv();}

    @Test(priority = 4, description = "Страница 'Предприятиям' Сравнение верстки по скриншотам")
    public void MarkupScreenshot_TEST() throws IOException {
        EnterprisePage enterprisePage = open(ConfigProviderInterface.enterpriseURL, EnterprisePage.class);
        enterprisePage.AcceptCookies();
        enterprisePage.TakeScreenshotOfFullPage(getEnvironment());
        Boolean result_of_comparing = enterprisePage.compareScreenshotsOfFullPage(getEnvironment());
        enterprisePage.AssertionCompareScreenshots(result_of_comparing);
    }

    @Test(priority = 1, description = "Страница 'Предприятиям'. Редиректы в разделе 'Наши отрасли'")
    public void OurIndustries_TEST() throws IOException {
        EnterprisePage enterprisePage = open(ConfigProviderInterface.enterpriseURL, EnterprisePage.class);
        enterprisePage.SelskoyeHozaystvoLink_Redirect();
        enterprisePage.ManufacrturingIndustriesLink_Redirect();
        enterprisePage.ConstructionLink_Redirect();
        enterprisePage.TradingLink_Redirect();
        enterprisePage.TransportLink_Redirect();
    }

    @Test(priority = 2, description = "Страница 'Предприятиям'. Редирект 'Подробнее о сервисах'")
    public void AboutServices_TEST() throws IOException {
        EnterprisePage enterprisePage = open(ConfigProviderInterface.enterpriseURL, EnterprisePage.class);
        enterprisePage.AboutServicesLink_Redirect();
    }

    @Test(priority = 3, description = "Страница 'Предприятиям'. Редирект 'Производительность.рф'")
    public void PerformanceLink_TEST() throws IOException {
        EnterprisePage enterprisePage = open(ConfigProviderInterface.enterpriseURL, EnterprisePage.class);
        enterprisePage.PerformanceLink_Redirect();
    }


}
