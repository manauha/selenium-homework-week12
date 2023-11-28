package desktops;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class DesktopsTest extends Utility {

    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    //Write the following Test:
    //1.Test name verifyProductArrangeInAlphabeticalOrder()
    @Test
    public void verifyProductArrangeInAlphabeticalOrder() {

        //1.1 Mouse hover on Desktops Tab.and click
        mouseHoverToElementAndClick(By.xpath("//a[normalize-space()='Desktops']"));

        //1.2 Click on “Show All Desktops”
        clickOnElement(By.xpath("//a[normalize-space()='Show AllDesktops']"));

        //1.3 Select Sort By position "Name: Z to A"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"), "Name (Z - A)");

        //1.4 Verify the Product will arrange in Descending order.
        String expectedMessage = "Name (Z - A)";
        String actualMessage = getTextFromElement(By.xpath("//option[@value='https://tutorialsninja.com/demo/index.php?route=product/category&path=20&sort=pd.name&order=DESC']"));
        Assert.assertEquals(expectedMessage, actualMessage);

    }

    //2. Test name verifyProductAddedToShoppingCartSuccessFully()
   @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException{

       //2.1 Mouse hover on Currency Dropdown and click
       mouseHoverToElementAndClick(By.xpath("//i[@class='fa fa-caret-down']"));

       //2.2 Mouse hover on £Pound Sterling and click
       mouseHoverToElementAndClick(By.xpath("//button[normalize-space()='£Pound Sterling']"));

       //2.3 Mouse hover on Desktops Tab.
       mouseHoverToElement(By.xpath("//a[normalize-space()='Desktops']"));

       //2.4 Click on “Show All Desktops”
       clickOnElement(By.xpath("//a[normalize-space()='Show AllDesktops']"));

       //2.5 Select Sort By position "Name: A to Z"
       selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"), "Name (Z - A)");

       //2.6 Select product “HP LP3065”
       clickOnElement(By.xpath("//a[normalize-space()='HP LP3065']")); ////img[@title='HP LP3065']

       //2.7 Verify the Text "HP LP3065"
       String expectedMessage = "HP LP3065";
       String actualMessage = getTextFromElement(By.xpath("//h1[normalize-space()='HP LP3065']"));
       Assert.assertEquals(expectedMessage, actualMessage); ////h1[normalize-space()='HP LP3065']


       //2.8 Select Delivery Date "2023-11-27"
//       clearTextField(By.xpath("//input[@id='input-option225']"));
//       sendTextToElement(By.xpath("//input[@id='input-option225']"),"2023-11-27");
       String year = "2023";
       String month = "November";
       String date = "27";
       clickOnElement(By.xpath("//span[@class = 'input-group-btn']//button[@class = 'btn btn-default']")); // open the calendar
       while (true) {

           String monthYear = getTextFromElement(By.xpath("//div[@class = 'datepicker-days']//th[@class = 'picker-switch']"));
           //System.out.println(monthYear);
           String[] a = monthYear.split(" ");
           String mon = a[0];
           String yer = a[1];
           if (mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)) {
               break;
           } else {
               clickOnElement(By.xpath("//div[@class = 'datepicker-days']//th[@class = 'next']"));
           }
       }
       // Select the date
       List<WebElement> allDates = driver.findElements(By.xpath("//tbody/tr/td"));
       for (WebElement dt : allDates) {
           if (dt.getText().equalsIgnoreCase(date)) {
               dt.click();
               break;
           }
       }

       //2.9.Enter Qty "1” using Select class.
       clickOnElement(By.id("input-quantity"));
       sendTextToElement(By.className("form-control"),"1");

       //2.10 Click on “Add to Cart” button
       clickOnElement(By.id("button-cart"));

       //2.11 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
       assertEqualsMethod("Incorrect Message",
               "Success: You have added HP LP3065 to your shopping cart!\n×",
               By.xpath("//div[@class='alert alert-success alert-dismissible']"));

       //2.12 Click on link “shopping cart” display into success message
       clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));

       //2.13 Verify the text "Shopping Cart"
       assertEqualsMethod("Empty Shopping Cart",
               "Shopping Cart  (1.00kg)",
               By.xpath("//h1[contains(text(),'Shopping Cart')]"));


       //2.14 Verify the Product name "HP LP3065"
       assertEqualsMethod("No product",
               "HP LP3065",
               By.xpath("//body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]"));

       //2.15 Verify the Delivery Date "2023-11-27"
       assertEqualsMethod("No Delivery Date selected",
               "Delivery Date:2023-11-27",
               By.xpath("//small[normalize-space()='Delivery Date:2023-11-27']"));

       //2.16 Verify the Model "Product21"
       assertEqualsMethod("No product","Product 21",By.xpath("//td[normalize-space()='Product 21']"));

       System.out.println(getTextFromElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[4]/td[2]")));
       //2.17 Verify the Total "£74.73"
       assertEqualsMethod("Incorrect Total",
               "£74.73",
               By.xpath("(//td[contains(text(),'£74.73')])[5]"));
   }
    @After
    public void tearDown() {
        closeBrowser();
    }

}
