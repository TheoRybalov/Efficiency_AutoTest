package Efficiency.TestListener;

import Efficiency.EmailUtil;
import org.testng.ISuite;
import org.testng.ISuiteListener;

public class SuiteListener implements ISuiteListener {

    @Override
    public void onStart(ISuite suite) {
        // Код, который нужно выполнить перед запуском suite (необязательно)
        System.out.println("Suite is started " + suite.getName());
    }

    @Override
    public void onFinish(ISuite suite) {
        // Код для отправки отчета после завершения suite
        System.out.println("Suite is finished " + suite.getName());

        int passedTests = TestListener.passedTests;
        int failedTests = TestListener.failedTests;
        int skippedTests = TestListener.skippedTests;
        int totalTests = passedTests + failedTests + skippedTests;
        int successPercentage = totalTests > 0 ? (int) Math.round(((double) passedTests / totalTests) * 100) : 0;

        try {
            String reportLink = "http://172.16.6.41:8085";
            String subject = "Отчет по тестам Эффективность.рф для набора " + suite.getName();
            String body = "Отчет по тестам Эффективность.рф доступен по ссылке: " + reportLink + "\n" +
                    "Процент успешных тестов: " + successPercentage + "%\n" +
                    "Количество успешных тестов: " + passedTests + "\n" +
                    "Количество пропущенных тестов: " + skippedTests + "\n" +
                    "Количество проваленных тестов: " + failedTests;
            EmailUtil.sendEmail("fedorrybalov@gmail.com", subject, body);
            EmailUtil.sendEmail("betliyk@quantumart.ru", subject, body);
            EmailUtil.sendEmail("paliys@quantumart.ru", subject, body);
            EmailUtil.sendEmail("rubina@quantumart.ru", subject, body);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
