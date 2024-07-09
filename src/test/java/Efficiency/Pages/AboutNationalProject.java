package Efficiency.Pages;

import Efficiency.CommonFunctions;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.testng.Assert;

import java.io.IOException;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class AboutNationalProject extends CommonFunctions {

    private static final SelenideElement cookieButton = $x("//*[@id=\"rcc-confirm-button\"]");

    //Паспорт федерального проекта «Адресная поддержка повышения производительности труда на предприятиях» ↗
    private static final SelenideElement PassportTargetedSupportLink = $x("//*[@id=\"root\"]/div/main/section[4]/div/div/div[1]/div/a");
    //Паспорт федерального проекта «Системные меры по повышению производительности труда» ↗
    private static final SelenideElement PassportSystemicMeasuresLink = $x("//*[@id=\"root\"]/div/main/section[4]/div/div/div[2]/div/a");
    //Паспорт Национального проекта «Производительность труда» ↗
    private static final SelenideElement PassportLaborProductivityLink= $x("//*[@id=\"root\"]/div/main/section[5]/div/div/div[1]/a");
    //Презентация проекта ↗
    private static final SelenideElement ProjectPresentationLink= $x("//*[@id=\"root\"]/div/main/section[5]/div/div/div[2]/a");
    //О проекте на сайте ФЦК ↗
    private static final SelenideElement AboutProjectOnSiteLink = $x("//*[@id=\"root\"]/div/main/section[5]/div/div/div[3]/a");

    @Step("Проверка редиректа по ссылке 'Паспорт федерального проекта «Адресная поддержка повышения производительности труда на предприятиях» ↗'")
    public void PassportTargetedSupportLink_Redirect(){
        Assert.assertEquals(PassportTargetedSupportLink.getText(), "Паспорт федерального проекта «Адресная поддержка повышения производительности труда на предприятиях» ↗", "Текст элемента не соответствует заданному");
        super.Check_Redirect_By_Link(PassportTargetedSupportLink, "https://qua-storage-qp.xn--b1afjhrgvdfla9hb.xn--p1ai/minpromtorg_catalog/upload/images/national-project/%D0%9F%D0%B0%D1%81%D0%BF%D0%BE%D1%80%D1%82-L2-%D0%A4%D0%9F%20%D0%90%D0%B4%D1%80%D0%B5%D1%81%D0%BD%D0%B0%D1%8F%20%D0%BF%D0%BE%D0%B4%D0%B4%D0%B5%D1%80%D0%B6%D0%BA%D0%B0.pdf");
    }

    @Step("Проверка редиректа по ссылке 'Паспорт федерального проекта «Системные меры по повышению производительности труда» ↗'")
    public void PassportSystemicMeasuresLink_Redirect(){
        Assert.assertEquals(PassportSystemicMeasuresLink.getText(), "Паспорт федерального проекта «Системные меры по повышению производительности труда» ↗", "Текст элемента не соответствует заданному");
        super.Check_Redirect_By_Link(PassportSystemicMeasuresLink, "https://qua-storage-qp.xn--b1afjhrgvdfla9hb.xn--p1ai/minpromtorg_catalog/upload/images/national-project/%D0%9F%D0%B0%D1%81%D0%BF%D0%BE%D1%80%D1%82-L1-%D0%A4%D0%9F%20%D0%A1%D0%B8%D1%81%D1%82%D0%B5%D0%BC%D0%BD%D1%8B%D0%B5%20%D0%BC%D0%B5%D1%80%D1%8B.pdf");
    }

    @Step("Проверка редиректа по ссылке 'Паспорт Национального проекта «Производительность труда» ↗'")
    public void PassportLaborProductivityLink_Redirect(){
        Assert.assertEquals(PassportLaborProductivityLink.getText(), "Паспорт Национального проекта «Производительность труда» ↗", "Текст элемента не соответствует заданному");
        super.Check_Redirect_By_Link(PassportLaborProductivityLink, "https://qua-storage-qp.xn--b1afjhrgvdfla9hb.xn--p1ai/minpromtorg_catalog/upload/images/national-project/%D0%9F%D0%B0%D1%81%D0%BF%D0%BE%D1%80%D1%82_L_%D0%9D%D0%9F_%D0%9F%D1%80%D0%BE%D0%B8%D0%B7%D0%B2%D0%BE%D0%B4%D0%B8%D1%82%D0%B5%D0%BB%D1%8C%D0%BD%D0%BE%D1%81%D1%82%D1%8C_%D1%82%D1%80%D1%83%D0%B4%D0%B0.pdf");
    }

    @Step("Проверка редиректа по ссылке 'Презентация проекта ↗'")
    public void ProjectPresentationLink_Redirect(){
        Assert.assertEquals(ProjectPresentationLink.getText(), "Презентация проекта ↗", "Текст элемента не соответствует заданному");
        super.Check_Redirect_By_Link(ProjectPresentationLink, "https://www.economy.gov.ru/material/directions/nacionalnyy_proekt_proizvoditelnost_truda/");
    }

    @Step("Проверка редиректа по ссылке 'О проекте на сайте ФЦК ↗'")
    public void AboutProjectOnSiteLink_Redirect(){
        Assert.assertEquals(AboutProjectOnSiteLink.getText(), "О проекте на сайте ФЦК ↗", "Текст элемента не соответствует заданному");
        super.Check_Redirect_By_Link(AboutProjectOnSiteLink, "https://xn--b1aedfedwqbdfbnzkf0oe.xn--p1ai/national-project/about_project/");
    }

    @Step("Принимаем куки")
    public void AcceptCookies() {cookieButton.shouldBe(visible).click();}

    @Step("Создаем скриншот всей страницы")
    public void TakeScreenshotOfFullPage(String environment) throws IOException {
        String screenshotPath = null;

        switch (environment){
            case "PC":
                screenshotPath = ("src/test/resources/screenshots/aboutNationalProject/PC/current.png");
                break;
            case "phone":
                screenshotPath = ("src/test/resources/screenshots/aboutNationalProject/phone/current.png");
                break;
            case "tablet":
                screenshotPath = ("src/test/resources/screenshots/aboutNationalProject/tablet/current.png");
                break;
            default:
                throw new IllegalArgumentException("Неверный параметр окружения: " + environment);

        }
        super.TakeScreenshotOfFullPage(screenshotPath);

    }

    @Step("Сравниваем скришоты")
    public boolean compareScreenshotsOfFullPage(String environment) throws IOException {
        String screenshotPath = null;
        String referencePath = null;
        String resultPath = null;
        switch (environment){
            case "PC":
                screenshotPath = "src/test/resources/screenshots/aboutNationalProject/PC/current.png";
                referencePath = "src/test/resources/screenshots/aboutNationalProject/PC/reference.png";
                resultPath = "src/test/resources/screenshots/aboutNationalProject/PC/result.png";
                break;
            case "phone":
                screenshotPath = "src/test/resources/screenshots/aboutNationalProject/phone/current.png";
                referencePath = "src/test/resources/screenshots/aboutNationalProject/phone/reference.png";
                resultPath = "src/test/resources/screenshots/aboutNationalProject/phone/result.png";
                break;
            case "tablet":
                screenshotPath = "src/test/resources/screenshots/aboutNationalProject/tablet/current.png";
                referencePath = "src/test/resources/screenshots/aboutNationalProject/tablet/reference.png";
                resultPath = "src/test/resources/screenshots/aboutNationalProject/tablet/result.png";
                break;
            default:
                throw new IllegalArgumentException("Неверный параметр окружения: " + environment);

        }
        return super.compareScreenshots(screenshotPath, referencePath, resultPath);

}
}
