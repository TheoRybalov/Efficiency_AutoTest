package Efficiency.Pages;

import com.codeborne.selenide.SelenideElement;
import org.testng.Assert;

import java.util.HashMap;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class HomePage {

    //header
    private static final SelenideElement WebSiteLabel = $x("//*[@id=\"root\"]/div/header/div[1]/span");
    private static final SelenideElement ServicesLink = $x("//*[@id=\"root\"]/div/header/div[2]/div/nav/ul/li[1]/a");
    private static final SelenideElement IndustriesLink = $x("//*[@id=\"root\"]/div/header/div[2]/div/nav/ul/li[2]/a");
    private static final SelenideElement EnterpriseLink = $x("//*[@id=\"root\"]/div/header/div[2]/div/nav/ul/li[3]/a");
    private static final SelenideElement ProvidersLink = $x("//*[@id=\"root\"]/div/header/div[2]/div/nav/ul/li[4]/a");
    private static final SelenideElement AboutProjectLink = $x("//*[@id=\"root\"]/div/header/div[2]/div/nav/ul/li[5]/span/span");
    private HashMap<String, SelenideElement> selenideElementHashMap;
    public SelenideElement getHeaderElement(String key) {
        //Creating hash-map, like key-value List to get elements
        selenideElementHashMap = new HashMap<>();
        selenideElementHashMap.put("webSiteLabel", WebSiteLabel);
        selenideElementHashMap.put("servicesLink", ServicesLink);
        selenideElementHashMap.put("industriesLink", IndustriesLink);
        selenideElementHashMap.put("enterpriseLink", EnterpriseLink);
        selenideElementHashMap.put("providersLink", ProvidersLink);
        selenideElementHashMap.put("aboutProjectLink", AboutProjectLink);

        return selenideElementHashMap.get(key).shouldBe(visible);
    }



    public void ServicesLinkIsCorrect(){
        Assert.assertEquals(getHeaderElement("servicesLink").getText(), "эффективность.рф");
    }

    public void IndustriesLinkIsCorrect(){
        Assert.assertEquals(getHeaderElement("industriesLink").getText(), "эффективность.рф");
    }

    public void EnterpriseLinkIsCorrect(){
        Assert.assertEquals(getHeaderElement("enterpriseLink").getText(), "эффективность.рф");
    }

    public void ProvidersLinkIsCorrect(){
        Assert.assertEquals(getHeaderElement("providersLink").getText(), "эффективность.рф");
    }






}
