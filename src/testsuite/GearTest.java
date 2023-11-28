package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class GearTest extends Utility {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldAddProductSuccessFullyToShoppinCart(){
        // Mouse Hover on Gear Menu
        mouseHover(By.xpath("(//span[normalize-space()='Gear'])[1]"));
        //click on begs
        mouseHoverAndClick(By.xpath("//span[normalize-space()='Bags']"));
        //* Click on Product Name ‘Overnight Duffle’
        mouseHoverAndClick(By.xpath("(//a[normalize-space()='Overnight Duffle'])[1]"));
        //change quality 3
        driver.findElement(By.xpath("(//input[@id='qty'])[1]")).clear();
        sendTextToElement(By.xpath("(//input[@id='qty'])[1]"),"3");
        //click on 'add to cart'
        mouseHoverAndClick(By.xpath("(//button[@id='product-addtocart-button'])[1]"));
        //verify the text ‘You added Overnight Duffle to your shopping cart.’
        String expectedText = "You added Overnight Duffle to your shopping cart.";
        String actualText = driver.findElement(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")).getText();
        Assert.assertEquals("Text not matched",expectedText,actualText);
        //click on shopping cart link into msg
        mouseHoverAndClick(By.xpath("//a[normalize-space()='shopping cart']"));
        //* Verify the product name ‘Cronus Yoga Pant’
        String actualNameOfPant = driver.findElement(By.xpath("//td[@class='col item']//a[normalize-space()='Cronus Yoga Pant']")).getText();
        String expectedNameOfPant = "Cronus Yoga Pant";
        Assert.assertEquals(expectedNameOfPant,actualNameOfPant);

        //* Verify the quality is ‘3’
        String actualQualityOfPant = driver.findElement(By.xpath("(//input[@id='cart-488517-qty'])[1][@value = '3']")).getText();
        String expectedQualityOfPant = "3";
        Assert.assertEquals(expectedQualityOfPant,actualQualityOfPant);

        //* Verify the product price
        String actualProductPrice = driver.findElement(By.xpath("(//span[contains(text(),'$144.00')]")).getText();
        String expectedProductPrice = "$144.00";
        Assert.assertEquals(expectedProductPrice,actualProductPrice);

        //change quality to 5
        driver.findElement(By.xpath("(//input[@id='cart-488517-qty'])[1]")).clear();
        sendTextToElement(By.xpath("(//input[@id='cart-490190-qty'][@value='5']"),"5");

        mouseHoverAndClick(By.xpath("//span[normalize-space()='Update Shopping Cart']"));

        //* Verify the product price
        String actualProductPriceUpdate = driver.findElement(By.xpath("(//span[contains(text(),'$240.00')]")).getText();
        String expectedProductPriceUpdate = "$240.00";
        Assert.assertEquals(expectedProductPriceUpdate,actualProductPriceUpdate);
    }

    @After
    public void tearDown(){
        closeBrowser();
    }
}
