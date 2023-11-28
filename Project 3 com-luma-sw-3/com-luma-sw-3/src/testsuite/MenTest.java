package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class MenTest extends Utility {

    static String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldAddProductSuccessFullyToShoppingCart() throws InterruptedException {

        //* Mouse Hover on Men Menu
        mouseHoverToElement(By.cssSelector("li[class='level0 nav-3 category-item level-top parent ui-menu-item']"));

        //* Mouse Hover on Bottoms
        Thread.sleep(500);
        mouseHoverToElement(By.xpath("//a[@id='ui-id-18']"));

        //* Click on Pants
        Thread.sleep(500);
        clickOnElement(By.xpath("//a[@id='ui-id-23']//span[contains(text(),'Pants')]"));

        //* Mouse Hover on product name ‘Cronus Yoga Pant’ and click on size 32.
        mouseHoverToElementAndClick(By.xpath("//a[normalize-space()='Cronus Yoga Pant']"), By.id("option-label-size-143-item-175"));

        //* Mouse Hover on product name ‘Cronus Yoga Pant’ and click on colour Black.
        Thread.sleep(500);
        mouseHoverToElementAndClick(By.xpath("//a[normalize-space()='Cronus Yoga Pant']"), By.id("option-label-color-93-item-49"));

        //* Mouse Hover on product name ‘Cronus Yoga Pant’ and click on ‘Add To Cart’ Button.
        Thread.sleep(500);
        mouseHoverToElementAndClick(By.xpath("//a[normalize-space()='Cronus Yoga Pant']"), By.xpath("(//button[@title='Add to Cart'])[1]"));

        //* Verify the text ‘You added Cronus Yoga Pant to your shopping cart.’
        assertEqualsMethod("Text is not matched",
                "You added Cronus Yoga Pant to your shopping cart.",
                (By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")));

        //* Click on ‘shopping cart’ Link into message
        clickOnElement(By.cssSelector("div[data-bind='html: $parent.prepareMessageForHtml(message.text)'] a"));

        //* Verify the text ‘Shopping Cart.’
        Thread.sleep(500);
        assertEqualsMethod("Text is not matched",
                "Shopping Cart",
                (By.xpath("(//span[@class='base'])[1]")));

        //* Verify the product name ‘Cronus Yoga Pant’
        Thread.sleep(500);
        assertEqualsMethod("Name is not matched",
                "Cronus Yoga Pant",
                (By.xpath("//td[@class='col item']//a[normalize-space()='Cronus Yoga Pant']")));

        //* Verify the product size ‘32’
        Thread.sleep(500);
        assertEqualsMethod("Size is not matched", "32",
                (By.xpath("//dd[contains(text(),'32')]")));

        //* Verify the product colour ‘Black’
        Thread.sleep(500);
        assertEqualsMethod("", "Black", (By.xpath("//dd[contains(text(),'Black')]")));
    }

    @After
    public void setDown(){
        closeBrowser();
    }
}
