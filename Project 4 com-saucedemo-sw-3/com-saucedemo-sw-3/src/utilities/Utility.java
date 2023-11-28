package utilities;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Utility extends BaseTest {

    //*********************************Element Methods************************************

    /**
     * This method will click on element
     */
    public void clickOnElement(By by) {
        driver.findElement(by).click();
    }

    /**
     * This method will send text on element
     */
    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    /**
     * This method will get text from element
     */
    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }

   // **********************Clear Method***********************************************

    public void clearTextField(By by) {
        driver.findElement(by).clear();
    }

    //***********************************Alert Methods*************************************

    /**
     * This method will switch to alert
     */
    public void switchToAlert() {
        driver.switchTo().alert();

    }

    /**
     * This method will accept the alert
     */
    public void acceptAlert(){
        driver.switchTo().alert().accept();
    }

    /**
     * This method will dismiss the alert
     */
    public void dismissAlert(){
        driver.switchTo().alert().dismiss();
    }

    /**
     * This method will send text to the Alert
     */
    public void sentTextToAlert(String text){
        driver.switchTo().alert().sendKeys(text);
    }

    /**
     * This method will get text from the alert
     */
    public String getTextFromAlert(){
        return driver.switchTo().alert().getText();
    }

    //****************************** Action Methods ************************************

    /**
     * This method will use to hover mouse on element
     */
    public void mouseHoverToElement(By by){
        Actions actions = new Actions(driver);
        WebElement text1 = driver.findElement(by);
        WebElement text2 = driver.findElement(by);
        actions.moveToElement(text1).moveToElement(text2).build().perform();
    }

    public void mouseHoverToElementAndClick(By by){
        Actions hover = new Actions(driver);
        WebElement text1 = driver.findElement(by);
        WebElement text2 = driver.findElement(by);
        hover.moveToElement(text1).moveToElement(text2).click().build().perform();
    }

    //***********************************Select Method***************************************

    public void selectByValueFromDropDown(By by, String value){
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByValue(value);
    }
    public void selectByIndexFromDropDown(By by, int value){
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByIndex(value);
    }
    public void selectByVisibleTextFromDropDown(By by, String text){
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByVisibleText(text);
    }
    public void selectByContainsGetTextFromDropDown(By by, int text){
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByValue(String.valueOf(text));
    }

   // ============================Assert Method =========================================

    //This method will verify the expected and actual result
    //verify the text
    public void verifyElements(String expected, By by, String Message) {
        String actual = getTextFromElement(by);
        Assert.assertEquals(Message, expected, actual);
    }

    public void assertEqualsMethod(String message, String expected, By by) {
        String actual = getTextFromElement(by);
        Assert.assertEquals(" ", expected, actual);

    }
     // This method will get text from element and check whether it is displayed or not.
    public boolean isTextDisplayed(By by, String expectedText) {
        boolean actualText = (driver.findElement(by).getText()).contains(expectedText); // Find and get actual text on page and check whether it contains expected text or not?
        assert actualText : "Text is not found" + expectedText;
        return true;
    }


    // This method will display size of the element in the List
    public void sizeOfElement(By by) {
        List<WebElement> productsElement = driver.findElements(by);
        System.out.println("Total number of products on display are: " + productsElement.size());
    }


}




