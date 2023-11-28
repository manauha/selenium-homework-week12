package Electronics;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class ElectronicsTest extends Utility {

    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    //    1. Test name verifyUserShouldNavigateToCellPhonesPageSuccessfully()
    @Test
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully() throws InterruptedException {

        //1.1 Mouse Hover on “Electronics” Tab
        mouseHoverToElement(By.linkText("Electronics"));

        //1.2 Mouse Hover on “Cell phones” and click
        mouseHoverToElementAndClick(By.linkText("Cell phones"));

        Thread.sleep(2000);
        //1.3 Verify the text “Cell phones”
        assertEqualsMethod("Cell Phones text not displayed", "Cell phones", By.linkText("Cell phones"));

    }


    //2. Test name verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully()
    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {

        //2.1 Mouse Hover on “Electronics” Tab
        mouseHoverToElement(By.linkText("Electronics"));

        //2.2 Mouse Hover on “Cell phones” and click
        mouseHoverToElementAndClick(By.linkText("Cell phones"));

        //2.3 Verify the text “Cell phones”
        assertEqualsMethod("Cell Phones text not displayed", "Cell phones", By.linkText("Cell phones"));

        //2.4 Click on List View Tab
        Thread.sleep(500);
        clickOnElement(By.xpath("//a[contains(text(),'List')]")); //a[text()='List']

        //2.5 Click on product name “Nokia Lumia 1020” link
        Thread.sleep(500);
        clickOnElement(By.xpath("//h2[@class='product-title']//a[contains(text(),'Nokia Lumia 1020')]"));

        //2.6 Verify the text “Nokia Lumia 1020”
        Thread.sleep(500);
        assertEqualsMethod("Nokia Lumia 1020 not found",
                "Nokia Lumia 1020", By.cssSelector("div[class='product-name'] h1"));

        //2.7 Verify the price “$349.00”
        assertEqualsMethod("Price not found", "$349.00", By.id("price-value-20"));

        //2.8 Change quantity to 2
        clearMethod(By.id("product_enteredQuantity_20"));
        sendTextToElement(By.id("product_enteredQuantity_20"), "2");

        //2.9 Click on “ADD TO CART” tab
        clickOnElement(By.id("add-to-cart-button-20"));

        //2.10 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        Thread.sleep(500);
        assertEqualsMethod("The product has not been added",
                "The product has been added to your shopping cart",
                (By.xpath("//p[@class='content']")));

        //After that close the bar clicking on the cross button.
        Thread.sleep(500);
        clickOnElement(By.xpath("//span[@class='close']"));

        //2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouseHoverToElement(By.xpath("//a[@class='ico-cart']"));
        Thread.sleep(500);
        clickOnElement(By.xpath("//span[@class='cart-label']"));

        //2.12 Verify the message "Shopping cart"
        Thread.sleep(500);
        assertEqualsMethod("Shopping cart not found",
                "Shopping cart",
                By.xpath("//h1[normalize-space()='Shopping cart']"));

        //2.13 Verify the quantity is 2
        Thread.sleep(500);
        //assertEqualsMethod("Incorrect Quantity", "2", By.xpath("//input[@class = 'qty-input']"));

        //2.14 Verify the Total $698.00
        assertEqualsMethod("Incorrect Amount",
                "$698.00",
                (By.xpath("//span[@class='product-subtotal']")));

        //2.15 click on checkbox “I agree with the terms of service”
        clickOnElement(By.id("termsofservice"));

        //2.16 Click on “CHECKOUT”
        clickOnElement(By.id("checkout"));

        //2.17 Verify the Text “Welcome, Please Sign In!”
        Thread.sleep(700);
        assertEqualsMethod("Incorrect Message",
                "Welcome, Please Sign In!",
                By.xpath("//h1[normalize-space()='Welcome, Please Sign In!']"));

        //2.18 Click on “REGISTER” tab
        clickOnElement(By.linkText("Register"));

        //2.19 Verify the text “Register”
        assertEqualsMethod("Registration Page not displayed",
                "Register", By.linkText("Register"));

        //2.20 Fill the mandatory fields
        sendTextToElement(By.id("FirstName"), "Neill");
        sendTextToElement(By.id("LastName"), "Coopers");
        sendTextToElement(By.id("Email"), "Neill.Coopeer99@test.moc");
        sendTextToElement(By.id("Password"), "Kris2Cross");
        sendTextToElement(By.id("ConfirmPassword"), "Kris2Cross");

        //2.21 Click on “REGISTER” Button
        clickOnElement(By.id("register-button"));

        //2.22 Verify the message “Your registration completed”
        assertEqualsMethod("Registration Incomplete",
                "Your registration completed",
                By.xpath("//div[@class='result']"));

        //2.23 Click on “CONTINUE” tab
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));

        //2.24 Verify the text “Shopping card”
        assertEqualsMethod("Incorrect Shopping Cart",
                "Shopping cart", By.linkText("Shopping cart"));

        //Click on login button
        clickOnElement(By.linkText("Log in"));

        //Verify the Text "Welcome, Please Sign in!"
        assertEqualsMethod("Incorrect text displayed","Welcome, Please Sign in!",
                By.xpath("//h1[contains(text()='Welcome, Please Sign in!')]"));

        //Enter Email
        sendTextToElement(By.id("Email"), "Neill.Coopeers16@test.moc");

        //Enter Password
        sendTextToElement(By.name("Password"), "Kris2Cross");

        //Click on Login button
        Thread.sleep(500);
        clickOnElement(By.xpath("//button[contains(text(),'Log in')]"));

        //2.25 click on checkbox “I agree with the terms of service”
        Thread.sleep(500);
        clickOnElement(By.xpath("//input[@id='termsofservice']"));

        //2.26 Click on “CHECKOUT”
        clickOnElement(By.id("checkout"));

        //2.27 Fill the Mandatory fields
        Thread.sleep(500);
        selectByValueFromDropDown(By.id("BillingNewAddress_CountryId"), "234");
        sendTextToElement(By.id("BillingNewAddress_City"), "Bath");
        sendTextToElement(By.name("BillingNewAddress.Address1"), "Barr Road");
        sendTextToElement(By.id("BillingNewAddress_ZipPostalCode"), "BA1 2AB");
        sendTextToElement(By.id("BillingNewAddress_PhoneNumber"), "07999666444");

        //2.28 Click on “CONTINUE”
        Thread.sleep(500);
        clickOnElement(By.xpath("//button[@class = 'button-1 new-address-next-step-button']"));

        //2.29 Click on Radio Button “2nd Day Air ($0.00)”
        clickOnElement(By.id("shippingoption_2"));

        //2.30 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));

        //2.31 Select Radio Button “Credit Card”
        clickOnElement(By.id("paymentmethod_1"));
        Thread.sleep(2000);
        clickOnElement(By.xpath("//button[@class='button-1 payment-method-next-step-button']"));

        //2.32 Select “Visa” From Select credit card dropdown
        selectByVisibleFromDropDown(By.id("CreditCardType"), "Visa");

        //2.33 Fill all the details
        sendTextToElement(By.id("CardholderName"), "Neil Cooper");
        Thread.sleep(2000);
        sendTextToElement(By.id("CardNumber"), "0000 0000 0000 0000");
        clickOnElement(By.id("ExpireMonth"));
        selectByValueFromDropDown(By.id("ExpireMonth"), "09");
        selectByValueFromDropDown(By.id("ExpireYear"), "2025");
        Thread.sleep(2000);
        sendTextToElement(By.id("CardCode"), "576");

        //2.34 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));

        //2.35 Verify “Payment Method” is “Credit Card”
        assertEqualsMethod("Incorrect Card Details", "Payment Method: Credit Card", By.xpath("//li[@class='payment-method']"));

        //2.36 Verify “Shipping Method” is “2nd Day Air”
        assertEqualsMethod("Incorrect Message","Shipping Method: 2nd Day Air", By.xpath("//li[@class='shipping-method']"));

        //2.37 Verify Total is “$698.00”
        assertEqualsMethod("Incorrect Total","$698.00", By.xpath("//span[text() ='$698.00']"));

        //2.38 Click on “CONFIRM”
        clickOnElement(By.xpath("//button[@class='button-1 confirm-order-next-step-button']"));

        //2.39 Verify the Text “Thank You”
        assertEqualsMethod("Incorrect Message Displayed", "Thank you", By.xpath("//h1[text() = 'Thank you']"));

        //2.40 Verify the message “Your order has been successfully processed!”
        assertEqualsMethod(" ", "Your order has been successfully processed!", By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"));

        //2.41 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class = 'button-1 order-completed-continue-button']"));

        //2.42 Verify the text “Welcome to our store”
        assertEqualsMethod("Welcome to our store","Incorrect Welcome Text",By.xpath("//h2[text() = 'Welcome to our store']"));

        //2.43 Click on “Logout” link
        clickOnElement(By.xpath("//a[contains(text(),'Log out')]"));

        //2.44 Verify the URL is “https://demo.nopcommerce.com/”
        String expectedUrl = "https://demo.nopcommerce.com/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals("URL not matching", expectedUrl, actualUrl);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
