package Efficiency.TestListener;

import Efficiency.EmailUtil;
import org.testng.ISuite;
import org.testng.ISuiteListener;

public class SuiteListener implements ISuiteListener {

    @Override
    public void onStart(ISuite suite) {
        // Код, который нужно выполнить перед запуском suite (необязательно)
        System.out.println("Начато выполнение набора тестов: " + suite.getName());
    }

    @Override
    public void onFinish(ISuite suite) {
        // Код для отправки отчета после завершения suite
        System.out.println("Завершено выполнение набора тестов: " + suite.getName());

        try {
            String reportLink = "http://localhost:8085";
            String subject = "Отчет по тестам Allure для набора " + suite.getName();
            String body = "Отчет по тестам Allure доступен по ссылке: " + reportLink;
            EmailUtil.sendEmail("fedorrybalov@gmail.com", subject, body);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
