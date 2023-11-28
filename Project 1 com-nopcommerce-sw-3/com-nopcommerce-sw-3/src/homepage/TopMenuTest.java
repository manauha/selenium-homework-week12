package homepage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

import java.util.ArrayList;
import java.util.List;

public class TopMenuTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public  void setUp(){
        openBrowser(baseUrl);
    }


    //1.1 create method with name "selectMenu" it has one parameter name "menu" of type string
    public void  selectMenu(String menu){


        //1.2 This method should click on the menu whatever name is passed as parameter.
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='" + menu + "']"));

    }


    // 1.3. create the @Test method name verifyPageNavigation.
    // use selectMenu method to select the Menu and click on it and verify the page navigation.
    @Test
    public void verifyPageNavigation(){

        List<String> topMenus = new ArrayList<>();
        topMenus.add("Computers");
        topMenus.add("Electronics");
        topMenus.add("Apparel");
        topMenus.add("Digital downloads");
        topMenus.add("Books");
        topMenus.add("Jewelry");
        topMenus.add("Gift Cards");

        for(String topMenu : topMenus){
        selectMenu(topMenu);
        String actualMessage = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='" + topMenu + "']")).getText();
        //System.out.println(actualMessage);
        Assert.assertEquals(topMenu,actualMessage);
        }
    }

    @After
    public void tearDown(){
        closeBrowser();
    }

}
