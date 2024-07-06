package Efficiency.Pages;

import Efficiency.CommonFunctions;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$x;

public class ProvidersPage extends CommonFunctions {
    //Заполнить анкету поставщика
    public static final SelenideElement ProviderFormLink = $x("//*[@id=\"root\"]/div/main/div/article/section[6]/div/div/a");

    //Стать поставщиком
    public static final SelenideElement BecomeAProviderLink = $x("//*[@id=\"root\"]/div/main/div/article/section[1]/div/div/div/div/div/div[1]/a");

    //Вход для поставщика
    public static final SelenideElement LoginAsProviderLink = $x("//*[@id=\"root\"]/div/main/div/article/section[1]/div/div/div/div/div/div[2]/a");

    @Step("Проверка редиректа по ссылке 'Заполнить анкету поставщика'")
    public void ProviderFormLink_Redirect(){
        Assert.assertEquals(ProviderFormLink.getText(), "Заполнить анкету поставщика", "Текст элемента не соответствует заданному");
        super.Check_Redirect_By_Link(ProviderFormLink, "https://svi.ctp.devops.xn--b1afjhrgvdfla9hb.xn--p1ai/idm/Accounts/RegisterOrganizationMode?accountType=Vendor");
    }

    @Step("")
    public void BecomeAProviderLink_Redirect(){
        Assert.assertEquals(BecomeAProviderLink.getText(), "Стать поставщиком", "Текст элемента не соответствует заданному");
        super.Check_Redirect_By_Link(BecomeAProviderLink, "https://svi.ctp.devops.xn--b1afjhrgvdfla9hb.xn--p1ai/idm/Accounts/RegisterOrganizationMode?accountType=Vendor");
    }

    @Step("")
    public void LoginAsProviderLink_Redirect(){
        Assert.assertEquals(LoginAsProviderLink.getText(), "Вход для поставщика", "Текст элемента не соответствует заданному");
        super.Check_Redirect_By_Link(LoginAsProviderLink, "https://aksis.dev.qsupport.ru/partner");
    }
}
