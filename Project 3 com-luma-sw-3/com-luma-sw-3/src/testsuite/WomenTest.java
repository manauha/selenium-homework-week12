package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class WomenTest extends Utility {

    static String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);

    }

    @Test
    public void verifyTheSortByProductNameFilter() throws InterruptedException {
        // * * Mouse Hover on Women Menu
        Thread.sleep(500);
        mouseHoverToElement(By.xpath("//span[normalize-space()='Women']"));

        // * * Mouse Hover on Tops
        Thread.sleep(700);
        mouseHoverToElement(By.xpath("//a[@id='ui-id-9']"));

        // * * Click on Jackets
        Thread.sleep(700);
        clickOnElement(By.id("ui-id-11"));

        // * * Select Sort By filter “Product Name”
        Thread.sleep(700);
        selectByVisibleTextFromDropDown(By.xpath("//div[@class='page-wrapper']//div[2]//div[3]//select[1]"), "Product Name ");

        // * * Verify the products name display in alphabetical order
        List<WebElement> element1 = driver.findElements(By.xpath("//strong[@class = 'product name product-item-name']"));
        for (WebElement result : element1) {
            System.out.println(result.getText());
        }
    }

    @Test
    public void verifyTheSortByPriceFilter() throws InterruptedException {

        // * * Mouse Hover on Women Menu
        Thread.sleep(500);
        mouseHoverToElement(By.xpath("//span[normalize-space()='Women']"));
        Thread.sleep(500);

        // * * Mouse Hover on Tops
        Thread.sleep(500);
        mouseHoverToElement(By.xpath("//a[@id='ui-id-9']"));

        // * * Click on Jackets
        Thread.sleep(500);
        clickOnElement(By.id("ui-id-11"));

        // * * Select Sort By filter “Price”
        selectByVisibleTextFromDropDown(By.id("sorter"), "Price");

        // * * Verify the products price display in Low to High
        List<WebElement> element1 = driver.findElements(By.xpath("//span[@class ='price-wrapper ']"));
        for (WebElement result : element1) {
            System.out.println(result.getText());
        }
    }


    @After
    public void setDown() {
        closeBrowser();
    }
}
