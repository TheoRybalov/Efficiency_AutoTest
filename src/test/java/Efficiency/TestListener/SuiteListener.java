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

        try {
            String reportLink = "http://172.16.6.41:8085";
            String subject = "Отчет по тестам Эффектинвность.рф для набора " + suite.getName();
            String body = "Отчет по тестам Эффектинвность.рф доступен по ссылке: " + reportLink;
            EmailUtil.sendEmail("fedorrybalov@gmail.com", subject, body);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
