package Efficiency.Tests;

import Efficiency.Pages.FaqPage;
import Efficiency.Providers.ConfigProviderInterface;
import Efficiency.TestBase;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.open;

public class FAQ extends TestBase {
    @Test(priority = 1, description = "Вопросы и ответы. Проверка ссылки 'Отправить сообщение'")
    public void SendMessageLink_TEST() throws IOException {
        FaqPage faqPage = open(ConfigProviderInterface.faqURL,FaqPage.class);
        faqPage.SendMessageLink_Redirect();
    }

    @Test(priority = 2, description = "Вопросы и ответы. Проверка ссылок в ответах")
    public void AnswerLinks_TEST() throws IOException{
        FaqPage faqPage = open(ConfigProviderInterface.faqURL,FaqPage.class);
        faqPage.PlatformRecommendationsLink_Redirect();
        faqPage.WhoUsePlatformLink_Redirect();
    }

    @Test(priority = 3, description = "Вопросы и ответы. Проверка работы кнопок и отображение ответа")
    public void QuestionsAndAnswers_TEST() throws IOException{
        FaqPage faqPage = open(ConfigProviderInterface.faqURL,FaqPage.class);
        faqPage.StartWorkQuestion_Visible();
        faqPage.ExpertVisitQuestion_Visible();
        faqPage.ExpertExperienceQuestion_Visible();
        faqPage.BenefitPlatformQuestion_Visible();
        faqPage.WorkOnPlatformQuestion_Visible();
        faqPage.WhoUsePlatformQuestion_Visible();
        faqPage.PurposePlatformQuestion_Visible();
        faqPage.PlatformRecommendationsQuestion_Visible();
        faqPage.ConnectionPlatformQuestion_Visible();
        faqPage.AnalogsQuestion_Visible();
        faqPage.WorkingGroupQuestion_Visible();
        faqPage.DigitalizationQuestion_Visible();
        faqPage.OveragingBusinessQuestion_Visible();
        faqPage.BudgetQuestion_Visible();
        faqPage.PrincipleQuestion_Visible();
    }
}
