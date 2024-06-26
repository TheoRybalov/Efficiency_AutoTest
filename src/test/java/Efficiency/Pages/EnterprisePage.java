package Efficiency.Pages;

import Efficiency.CommonFunctions;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.switchTo;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class EnterprisePage extends CommonFunctions {

    //Предприятиям
    private static final SelenideElement BecomePlatformParticipantLink = $x("//*[@id=\"root\"]/div/main/div/article/section[1]/div/div/div/div/a");
    //Наши отрасли
    private static final SelenideElement SelskoyeHozaystvoLink = $x("//*[@id=\"root\"]/div/main/div/article/section[6]/ul/li[1]/a");
    private static final SelenideElement ManufacrturingIndustriesLink = $x("//*[@id=\"root\"]/div/main/div/article/section[6]/ul/li[2]/a");
    private static final SelenideElement ConstructionLink = $x("//*[@id=\"root\"]/div/main/div/article/section[6]/ul/li[3]/a");
    private static final SelenideElement TradingLink = $x("//*[@id=\"root\"]/div/main/div/article/section[6]/ul/li[4]/a");
    private static final SelenideElement TransportLink = $x("//*[@id=\"root\"]/div/main/div/article/section[6]/ul/li[5]/a");
    //Подробнее о сервисах
    private static final SelenideElement AboutServicesLink = $x("//*[@id=\"root\"]/div/main/div/article/section[4]/div/div/div/a");
    //Производительность.рф
    private static final SelenideElement PerformanceLink = $x("//*[@id=\"root\"]/div/main/div/article/section[2]/div[2]/div/div/p/a");
    //Наши отрасли
    @Step("Проверка редиректа по ссылке 'Сельское хозяйство' в разделе 'Отрасли'")
    public void SelskoyeHozaystvoLink_Redirect(){
        Assert.assertEquals(SelskoyeHozaystvoLink.getText(), "Сельское хозяйство", "Текст элемента не соответствует заданному");
        super.Check_Redirect_By_Link(SelskoyeHozaystvoLink, "https://aksis.dev.qsupport.ru/industries/selskoye-hozaystvo");
    }
    @Step("Проверка редиректа по ссылке 'Обрабатывающая промышленность' в разделе 'Отрасли'")
    public void ManufacrturingIndustriesLink_Redirect(){
        Assert.assertEquals(ManufacrturingIndustriesLink.getText(), "Обрабатывающая промышленность", "Текст элемента не соответствует заданному");
        super.Check_Redirect_By_Link(ManufacrturingIndustriesLink, "https://aksis.dev.qsupport.ru/industries/manufacturing-industries");
    }
    @Step("Проверка редиректа по ссылке 'Строительство' в разделе 'Отрасли'")
    public void ConstructionLink_Redirect(){
        Assert.assertEquals(ConstructionLink.getText(), "Строительство", "Текст элемента не соответствует заданному");
        super.Check_Redirect_By_Link(ConstructionLink, "https://aksis.dev.qsupport.ru/industries/construction");
    }
    @Step("Проверка редиректа по ссылке 'Торговля' в разделе 'Отрасли'")
    public void TradingLink_Redirect(){
        Assert.assertEquals(TradingLink.getText(), "Торговля", "Текст элемента не соответствует заданному");
        super.Check_Redirect_By_Link(TradingLink, "https://aksis.dev.qsupport.ru/industries/trading");
    }
    @Step("Проверка редиректа по ссылке 'Транспортировка и хранение' в разделе 'Отрасли'")
    public void TransportLink_Redirect(){
        Assert.assertEquals(TransportLink.getText(), "Транспортировка и хранение", "Текст элемента не соответствует заданному");
        super.Check_Redirect_By_Link(TransportLink, "https://aksis.dev.qsupport.ru/industries/transport");
    }
    //Подробнее о сервисах
    @Step("Проверка редиректа по ссылке 'Подробнее о сервисах'")
    public void AboutServicesLink_Redirect(){
        Assert.assertEquals(AboutServicesLink.getText(), "Подробнее о сервисах", "Текст элемента не соответствует заданному");
        super.Check_Redirect_By_Link(AboutServicesLink, "https://aksis.dev.qsupport.ru/services");
    }
    //Производительность.рф
    @Step("Проверка редиректа по ссылке 'производительность.рф'")
    public void PerformanceLink_Redirect(){
        Assert.assertEquals(PerformanceLink.getText(), "производительность.рф ↗", "Текст элемента не соответствует заданному");
        super.Check_RedirectToOtherTab_By_Link(PerformanceLink, "https://xn--b1aedfedwqbdfbnzkf0oe.xn--p1ai/");
    }

    //Предприятим
    @Step("Проверка редиректа по ссылке 'Стать участником платформы'")
    public void BecomePlatformParticipantLink_Redirect_Check(){
        Assert.assertEquals(BecomePlatformParticipantLink.getText(), "Стать участником платформы", "Текст элемента не соответствует заданному");
        super.Check_Redirect_By_Link(BecomePlatformParticipantLink, "https://svi.ctp.devops.xn--b1afjhrgvdfla9hb.xn--p1ai/idm/Accounts/RegisterOrganizationMode?accountType=Company");
    }
}
