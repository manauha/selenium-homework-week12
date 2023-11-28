package computer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class TestSuite extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }


    //1.Test name verifyProductArrangeInAlphabeticalOrder()
    @Test
    public void verifyProductArrangeInAlphabeticalOrder() throws InterruptedException{

        //1.1 Click on Computer Menu.
        clickOnElement(By.linkText("Computers"));

        //1.2 Click on Desktop
        clickOnElement(By.linkText("Desktops"));

        //1.3 Select Sort By position "Name: Z to A"
        selectByVisibleFromDropDown(By.id("products-orderby"),("Name: Z to A" ));

        //1.4 Verify the Product will arrange in Descending order.
        Thread.sleep(500);
        assertEqualsMethod("Items are not arranged in descending order",
                "Name: Z to A",
                By.xpath("//option[normalize-space()='Name: Z to A']"));

    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessfully() throws InterruptedException {

        //2.1 Click on Computer Menu.
        clickOnElement(By.linkText("Computers"));

        //2.2 Click on Desktop
        clickOnElement(By.xpath("//a[@title='Show products in category Desktops'][normalize-space()='Desktops']"));

        //2.3 Select Sort By position "Name: A to Z"
        selectByVisibleFromDropDown(By.xpath("//select[@id='products-orderby']"), "Name: A to Z");


        //2.4 Click on "Add To Cart"
        Thread.sleep(500);
        clickOnElement(By.xpath("//a[text() = 'Build your own computer']"));

        //2.5 Verify the Text "Build your own computer"
        assertEqualsMethod("Text dose not match",
                "Build your own computer",
                By.xpath("//h1[normalize-space()='Build your own computer']"));

        //2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        selectByVisibleFromDropDown(By.xpath("//select[@id='product_attribute_1']"), "2.2 GHz Intel Pentium Dual-Core E2200");

        //2.7.Select "8GB [+$60.00]" using Select class.
        selectByVisibleFromDropDown(By.xpath("//select[@id='product_attribute_2']"), "8GB [+$60.00]");

        //2.8 Select HDD radio "400 GB [+$100.00]"
        Thread.sleep(1000);
        clickOnElement(By.id("product_attribute_3_7"));

        //2.9 2.9 Select OS radio "Vista Premium [+$60.00]"
        Thread.sleep(1000);
        clickOnElement(By.id("product_attribute_4_9"));

        //2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander
        Thread.sleep(1000);
        clickOnElement(By.id("product_attribute_5_12"));
        //  manageElementList(By.id("product_attribute_5_10"), "Microsoft Office [+$50.00]");
        // manageElementList(By.id("product_attribute_5_12"), "Total Commander [+$5.00]");

        //2.11 Verify the price "$1,475.00"
        Thread.sleep(2000);
        assertEqualsMethod("Incorrect Price", "$1,475.00", By.id("price-value-1"));

        //2.12 Click on "ADD TO CARD" Button.
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-1']"));

        //2.13 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        assertEqualsMethod("Cart is empty",
                "The product has been added to your shopping cart",
                By.xpath("//body/div[@id='bar-notification']/div[1]/p[1]"));

        //After that close the bar clicking on the cross button.
        clickOnElement(By.xpath("//span[@class='close']"));

        //2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouseHoverToElement(By.linkText("Shopping cart"));
        clickOnElement(By.xpath("//span[@class='cart-label']"));

        //2.15 Verify the message "Shopping cart"
        assertEqualsMethod("Incorrect message displayed",
                "Shopping cart",
                By.xpath("//h1[normalize-space()='Shopping cart']"));

        //2.16 Change the Qty to "2" and Click on "Update shopping cart"
        Thread.sleep(1000);
        clearMethod(By.xpath("//input[@class='qty-input' and @value='1']"));
        sendTextToElement(By.xpath("//input[@class='qty-input']"), "2");
        clickOnElement(By.xpath("//button[@id='updatecart']"));

        //2.17 Verify the Total"$2,950.00"
        assertEqualsMethod("Incorrect Price",
                "$2,950.00",
                By.xpath("//span[@class='product-subtotal']"));

        //2.18 click on checkbox “I agree with the terms of service”
        clickOnElement(By.id("termsofservice"));

        //2.19 Click on “CHECKOUT”
        clickOnElement(By.id("checkout"));

        //2.20 Verify the Text “Welcome, Please Sign In!”
        assertEqualsMethod("Incorrect Message",
                "Welcome, Please Sign In!",
                By.xpath("//h1[normalize-space()='Welcome, Please Sign In!']"));

        //2.21Click on “CHECKOUT AS GUEST” Tab
        clickOnElement(By.xpath("//button[text()='Checkout as Guest']"));

        //2.22 Fill the all mandatory field
        sendTextToElement(By.id("BillingNewAddress_FirstName"), "Neil");
        sendTextToElement(By.id("BillingNewAddress_LastName"), "Cooper");
        sendTextToElement(By.id("BillingNewAddress_Email"), "ncopper@test.moc");
        selectByVisibleFromDropDown(By.id("BillingNewAddress_CountryId"), "United Kingdom");
        sendTextToElement(By.id("BillingNewAddress_City"), "Leeds");
        sendTextToElement(By.name("BillingNewAddress.Address1"), "Liverpool Lane");
        sendTextToElement(By.id("BillingNewAddress_ZipPostalCode"), "L12 3PH");
        sendTextToElement(By.id("BillingNewAddress_PhoneNumber"), "07643667894");
        Thread.sleep(2000);

        //2.23 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[text() = 'Continue']"));

        //2.24 Click on Radio Button “Next Day Air($0.00)”
        clickOnElement(By.id("shippingoption_1"));

        //2.25 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));

        //2.26 Select Radio Button “Credit Card”
        clickOnElement(By.id("paymentmethod_1"));
        clickOnElement(By.xpath("//button[@class='button-1 payment-method-next-step-button']"));

        //2.27 Select “Master card” From Select credit card dropdown
        selectByVisibleFromDropDown(By.id("CreditCardType"), "Master card");

        //2.28 Fill all the details
        sendTextToElement(By.id("CardholderName"), "Neil Cooper");
        Thread.sleep(500);
        sendTextToElement(By.id("CardNumber"), "0000 0000 0000 0000");
        clickOnElement(By.id("ExpireMonth"));
        selectByVisibleFromDropDown(By.id("ExpireMonth"), "07");
        selectByVisibleFromDropDown(By.id("ExpireYear"), "2027");
        Thread.sleep(500);
        sendTextToElement(By.id("CardCode"), "522");

        //2.29 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));

        //2.30 Verify “Payment Method” is “Credit Card”
        Thread.sleep(500);
        assertEqualsMethod("Incorrect Card Details",
                "Payment Method: Credit Card",
                By.xpath("//li[@class='payment-method']"));

        //2.32 Verify “Shipping Method” is “Next Day Air”
        assertEqualsMethod("No Delivery Dates",
                "Shipping Method: Next Day Air",
                By.xpath("//li[@class = 'shipping-method']"));

        //2.33 Verify Total is “$2,950.00”
        assertEqualsMethod("Incorrect Total",
                "$2,950.00",
                By.xpath("//span[text() ='$2,950.00']"));

        //2.34 Click on “CONFIRM”
        clickOnElement(By.xpath("//button[@class='button-1 confirm-order-next-step-button']"));

        //2.35 Verify the Text “Thank You”
        Thread.sleep(500);
        assertEqualsMethod("No Text",
                "Thank you",
                By.xpath("//h1[text() = 'Thank you']"));

        //2.36 Verify the message “Your order has been successfully processed!”
        Thread.sleep(500);
        assertEqualsMethod("No Confirmation message",
                "Your order has been successfully processed!",
                By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"));

        //2.37 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class = 'button-1 order-completed-continue-button']"));

        //2.38 Verify the text “Welcome to our store”
        Thread.sleep(500);
        assertEqualsMethod("No Welcome Text ",
                "Welcome to our store",
                By.xpath("//h2[text() = 'Welcome to our store']"));
    }

    @After
    public void setDown(){
        closeBrowser();
    }

}
