package Efficiency.Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.testng.Assert;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {
    private static final SelenideElement loginField = $x("//*[@id=\"Login\"]");
    private static final SelenideElement passwordField = $x("//*[@id=\"Password\"]");
    private static final SelenideElement loginButton = $x("//*[@id=\"loginForm\"]/button[1]");

    @Step("Ввести имя пользователя в поле Логин")
    public void enterLogin(String login){
        loginField.sendKeys(login);
        Assert.assertEquals(loginField.getValue(), login);
    }
    @Step("Ввести пароль для пользователя")
    public void enterPassword(String password){
        passwordField.sendKeys(password);
        Assert.assertEquals(passwordField.getValue(), password);
    }
    @Step("Нажать кнопку 'Войти'")
    public void loginButton_click(){
        loginButton.shouldBe(visible).click();
    }

    public void login(String user, String password){
        enterLogin(user);
        enterPassword(password);
        loginButton_click();
    }
}
