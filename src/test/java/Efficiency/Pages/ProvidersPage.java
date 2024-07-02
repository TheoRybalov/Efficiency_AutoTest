package Efficiency.Pages;

import Efficiency.CommonFunctions;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$x;

public class ProvidersPage extends CommonFunctions {
    //Заполнить анкету поставщика
    public static final SelenideElement ProviderFormLink = $x("//*[@id=\"root\"]/div/main/div/article/section[6]/div/div/a");

    @Step("Проверка редиректа по ссылке 'Заполнить анкету поставщика'")
    public void ProviderFormLink_Redirect(){
        Assert.assertEquals(ProviderFormLink.getText(), "Заполнить анкету поставщика", "Текст элемента не соответствует заданному");
        super.Check_Redirect_By_Link(ProviderFormLink, "https://svi.ctp.devops.xn--b1afjhrgvdfla9hb.xn--p1ai/idm/Accounts/RegisterOrganizationMode?accountType=Vendor");
    }
}
