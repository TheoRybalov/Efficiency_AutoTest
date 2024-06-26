package Efficiency.Providers;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
public interface ConfigProviderInterface {

    Config config = readConfig();

    static Config readConfig(){
        return ConfigFactory.load("project.conf");
    }


    String baseURL = readConfig().getString("baseURL");
    String servicesURL = readConfig().getString("ServicesURL");
    String industriesURL = readConfig().getString("IndustriesURL");
    String enterpriseURL = readConfig().getString("EnterpriseURL");
    String providersURL = readConfig().getString("ProvidersURL");
    String aboutProjectURL = readConfig().getString("AboutProjectURL");
    String pressCenterURL = readConfig().getString("PressCenterURL");
    String supervisoryBoardsURL = readConfig().getString("SupervisoryBoardsURL");
    String nationalProjectURL = readConfig().getString("NationalProjectURL");
    String faqURL = readConfig().getString("FaqURL");
    String contactsURL = readConfig().getString("ContactsURL");

}
