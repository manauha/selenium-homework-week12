package homepage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

//1. create class "TopMenuTest"
public class TopMenuTest extends Utility {

    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    //1.1 create method with name "selectMenu" it has one parameter name "menu" of type string
    public void selectMenu(String menu) {

        //1.2 This method should click on the menu whatever name is passed as parameter.
        clickOnElement(By.xpath("//a[normalize-space()='" + menu + "']"));

    }

    //Write the following Test:

    //1. verifyUserShouldNavigateToDesktopsPageSuccessfully()
    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {

        //1.1 Mouse hover on “Desktops” Tab and click
        mouseHoverToElementAndClick(By.xpath("//a[@class='dropdown-toggle'][normalize-space()='Desktops']"));

        //1.2 call selectMenu method and pass the menu = “Show All Desktops”
        String menuName = "Show AllDesktops";
        selectMenu(menuName);

        //1.3 Verify the text ‘Desktops’
        String expectedMessage = "Desktops";
        String actualMessage = getTextFromElement(By.xpath("//a[normalize-space()='Desktops']"));
        Assert.assertEquals(expectedMessage, actualMessage);

    }

    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() {

        //2.1 Mouse hover on “Laptops & Notebooks” Tab and click
        mouseHoverToElementAndClick(By.xpath("//a[@class='dropdown-toggle'][normalize-space()='Laptops & Notebooks']"));

        //2.2 call selectMenu method and pass the menu = “Show All Laptops & Notebooks”
        String menuName = "Show AllLaptops & Notebooks";
        selectMenu(menuName);

        //2.3 Verify the text ‘Laptops & Notebooks’
        String expectedMessage = "Laptops & Notebooks";
        String actualMessage = getTextFromElement(By.xpath("//h2[normalize-space()='Laptops & Notebooks']"));
        Assert.assertEquals(expectedMessage, actualMessage);

    }


    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() {

        //3.1 Mouse hover on “Components” Tab and click
        mouseHoverToElementAndClick(By.xpath("//a[@class='dropdown-toggle'][normalize-space()='Components']"));

        //3.2 call selectMenu method and pass the menu = “Show All Components”
        String menuName = "Show AllComponents";
        selectMenu(menuName);

        //3.3 Verify the text ‘Components’
        String expectedMessage = "Components";
        String actualMessage = getTextFromElement(By.xpath("//h2[normalize-space()='Components']"));
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @After
    public void tearDown(){
        closeBrowser();
    }
}


