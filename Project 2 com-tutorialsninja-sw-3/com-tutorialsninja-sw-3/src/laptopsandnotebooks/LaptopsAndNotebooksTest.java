package laptopsandnotebooks;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LaptopsAndNotebooksTest extends Utility {
    static String baseUrl = "http://tutorialsninja.com/demo/index.php";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully() {
        //1.1 Mouse hover on Laptops & Notebooks Tab.and click
        mouseHoverToElement(By.xpath("//a[normalize-space()='Laptops & Notebooks']"));


        //1.2 Click on “Show All Laptops & Notebooks”
        clickOnElement(By.xpath("//a[normalize-space()='Show AllLaptops & Notebooks']"));

        //1.3 Select Sort By "Price (High > Low)"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"), "Price (High > Low)");

        //1.4 Verify the Product price will arrange in High to Low order.
        assertEqualsMethod("Displayed are not arranged by High to Low",
                "Price (High > Low)",
                By.xpath("//option[@value='https://tutorialsninja.com/demo/index.php?route=product/category&path=18&sort=p.price&order=DESC']"));
    }


    //2. Test name verifyThatUserPlaceOrderSuccessfully()
    @Test
    public void verifyThatUserPlaceOrderSuccessfully() throws InterruptedException {
        //2.1 Mouse hover on Laptops & Notebooks Tab and click
        mouseHoverToElement(By.xpath("//a[normalize-space()='Laptops & Notebooks']"));

        //2.2 Click on “Show All Laptops & Notebooks”
        clickOnElement(By.xpath("//a[normalize-space()='Show AllLaptops & Notebooks']"));

        //2.3 Select Sort By "Price (High > Low)"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"), "Price (High > Low)");

        //2.4 Select Product “MacBook”
        clickOnElement(By.xpath("//a[normalize-space()='MacBook']"));

        //2.5 Verify the text “MacBook”
        assertEqualsMethod("Incorrect Text", "MacBook", By.xpath("//a[normalize-space()='MacBook']"));

        //2.6 Click on ‘Add To Cart’ button
        clickOnElement(By.xpath("//button[@id='button-cart']"));

        //2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
        assertEqualsMethod("Incorrect Message",
                "Success: You have added MacBook to your shopping cart!\n×",
                By.xpath("//div[@class='alert alert-success alert-dismissible']"));

        //2.8 Click on link “shopping cart” display into success message
        clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));

        //2.9 Verify the text "Shopping Cart"
        assertEqualsMethod("Wrong Text", "Shopping Cart  (0.00kg)",
                By.xpath("//h1[contains(text(),'Shopping Cart')]"));

        //2.10 Verify the Product name "MacBook"
        assertEqualsMethod("Incorrect product name",
                "MacBook",
                By.xpath("(//a[contains(text(),'MacBook')])[2]"));

        //2.11 Change Quantity "2"
        clearTextField(By.xpath("//input[@class='form-control']"));
        Thread.sleep(500);
        sendTextToElement(By.xpath("//input[@class='form-control']"), "2");

        //2.12 Click on “Update” Tab
        clickOnElement(By.xpath("//button[@type='submit']"));

        //2.13 Verify the message “Success: You have modified your shopping cart!”
        Thread.sleep(500);
        assertEqualsMethod("Message Incorrect", "Success: You have modified your shopping cart!\n×", By.xpath("//div[@class='alert alert-success alert-dismissible']"));

        //Changing currency
        mouseHoverToElementAndClick(By.xpath("//span[text()='Currency']"));
        //Mouse hover on £Pound Sterling and click
        mouseHoverToElementAndClick(By.xpath("//button[text()='£Pound Sterling']"));

        //2.14 Verify the Total £737.45
        Thread.sleep(500);
        assertEqualsMethod("Incorrect Total",
                "£737.45",
                By.xpath("//tbody//tr//td[6]"));

        //2.15 Click on “Checkout” button
        clickOnElement(By.xpath("//a[@class='btn btn-primary']"));

        //2.16 Verify the text “Checkout”
        Thread.sleep(500);
        assertEqualsMethod("Incorrect Text",
                "Checkout",
                By.xpath("//h1[normalize-space()='Checkout']"));

        //2.17 Verify the Text “New Customer”
        assertEqualsMethod("Incorrect Text",
                "New Customer",
                By.xpath("//h2[normalize-space()='New Customer']"));

        //2.18 Click on “Guest Checkout” radio button
        Thread.sleep(500);
        clickOnElement(By.xpath("//input[@value='guest']"));

        //2.19 Click on “Continue” tab
        clickOnElement(By.id("button-account"));

        //2.20 Fill the mandatory fields
        Thread.sleep(500);
        sendTextToElement(By.id("input-payment-firstname"), "Neil");
        sendTextToElement(By.id("input-payment-lastname"), "Cooper");
        sendTextToElement(By.id("input-payment-email"), "Neil.Cooper1@test.com");
        sendTextToElement(By.id("input-payment-telephone"), "Pen2Paper");
        sendTextToElement(By.id("input-payment-address-1"), "11 Liverpool Lane");
        sendTextToElement(By.name("city"), "Leeds");
        sendTextToElement(By.name("postcode"), "L12 3MN");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-payment-country']"), "United Kingdom");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-payment-zone']"), "Kent");

        //2.21 Click on “Continue” Button
        Thread.sleep(500);
        clickOnElement(By.id("button-guest"));

        //2.22 Add Comments About your order into text area
        Thread.sleep(500);
        sendTextToElement(By.xpath("//textarea[@name='comment']"), "Best product.");

        //2.23 Check the Terms & Conditions check box
        clickOnElement(By.xpath("//input[@type='checkbox']"));

        //2.24 Click on “Continue” button
        Thread.sleep(500);
        clickOnElement(By.xpath("//input[@id='button-payment-method']"));

        //2.25 Verify the message “Warning: Payment method required!”
        Thread.sleep(500);
        assertEqualsMethod("Incorrect Message",
                "Warning: Payment method required!\n×",
                By.xpath("//div[@class='alert alert-danger alert-dismissible']"));

    }

    @After
    public void tearDown(){
        closeBrowser();
    }
}
