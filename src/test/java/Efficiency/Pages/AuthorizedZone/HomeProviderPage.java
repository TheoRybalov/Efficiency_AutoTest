package Efficiency.Pages.AuthorizedZone;

import Efficiency.AuthorizedCommonFunctions;
import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;
import org.testng.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;

public class HomeProviderPage extends AuthorizedCommonFunctions {
    //Боковое меню
    private static final ElementsCollection SideMenu_Widgets = $$x("//*[@id=\"root\"]/div/div[2]/main/aside/div/div/nav/div/div[1]/ul/li");
    private static final ElementsCollection SideMenu_Widgets_hrefs = $$x("//*[@id=\"root\"]/div/div[2]/main/aside/div/div/nav/div/div[1]/ul/li/a");
    private static final ElementsCollection SideMenu_Services = $$x("//*[@id=\"root\"]/div/div[2]/main/aside/div/div/nav/div/div[2]/div/div/div[1]/div/ul/li");
    private static final ElementsCollection SideMenu_Services_hrefs = $$x("//*[@id=\"root\"]/div/div[2]/main/aside/div/div/nav/div/div[2]/div/div/div[1]/div/ul/a");
    private Map<String, Object> SideMenuData = new HashMap<>();


    @Step("Получить данные из API для Бокового меню")
    public void getSideMenuDataFromApi() {
        Map<String, Object> apiData = super.getFullSideMenuDataFromApi("https://aksis.dev.qsupport.ru/onboarding/api/TableOfContents/Main");
        SideMenuData.putAll(apiData);

    }

    @Step("Сравнить названия из Api и на сайте для виджетов бокового меню")
    public void Assert_SideMenu_WidgetData_Titles() {
        List<Map<String, String>> widgetItems = (List<Map<String, String>>) SideMenuData.get("mainItems");
        SideMenu_Widgets.first().shouldBe(visible);
        for (int i = 0; i < SideMenu_Widgets.size(); i++) {
            String apiName = widgetItems.get(i).get("name");
            String elementText = SideMenu_Widgets.get(i).getText();
            Assert.assertEquals(apiName, elementText, "Название для элемента " + elementText + " не совпадает");
        }

    }

    @Step("Сравнить ссылки из Api и на сайте для виджетов бокового меню")
    public void Assert_SideMenu_WidgetData_URLs() {
        List<Map<String, String>> widgetItems = (List<Map<String, String>>) SideMenuData.get("mainItems");
        for (int i = 0; i < SideMenu_Widgets_hrefs.size(); i++) {
            String apiUrl = widgetItems.get(i).get("url");
            String elementUrl = SideMenu_Widgets_hrefs.get(i).getAttribute("href");
            Assert.assertEquals(apiUrl, elementUrl, "Ссылка для элемента " + SideMenu_Widgets.get(i).getText() + " не совпадает");
        }

    }


    @Step("Сравнить названия из Api и на сайте для сервисов бокового меню")
    public void Assert_SideMenu_ServicesData_Titles() {
        List<Map<String, String>> widgetItems = (List<Map<String, String>>) SideMenuData.get("serviceItems");
        SideMenu_Services.first().shouldBe(visible);
        for (int i = 0; i < SideMenu_Services.size(); i++) {
            String apiName = widgetItems.get(i).get("name");
            String elementText = SideMenu_Services.get(i).getText();
            Assert.assertEquals(apiName, elementText, "Название для элемента " + elementText + " не совпадает");
        }

    }

    @Step("Сравнить ссылки из Api и на сайте для сервисов бокового меню")
    public void Assert_SideMenu_ServicesData_URLs() {
        List<Map<String, String>> widgetItems = (List<Map<String, String>>) SideMenuData.get("serviceItems");
        for (int i = 0; i < SideMenu_Services_hrefs.size(); i++) {
            String apiUrl = widgetItems.get(i).get("url");
            String elementUrl = SideMenu_Services_hrefs.get(i).getAttribute("href");
            Assert.assertEquals(apiUrl, elementUrl, "Ссылка для элемента " + SideMenu_Widgets.get(i).getText() + " не совпадает");
        }

    }


}
