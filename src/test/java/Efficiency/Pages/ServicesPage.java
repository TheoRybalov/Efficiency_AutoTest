package Efficiency.Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.testng.Assert;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class ServicesPage {
    private static final SelenideElement MainHeader = $x("//*[@id=\"root\"]/div/main/div/div/div/div/h1");

    public void HeaderVisible(){
        Assert.assertEquals(MainHeader.shouldBe(visible).getText(), "Сервисы");
    }
}
