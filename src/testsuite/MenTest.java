package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class MenTest extends Utility {
    String baseUrl ="https://magento.softwaretestingboard.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldAddProductSuccessFullyToShoppinCart(){
        //* Mouse Hover on Men Menu
        mouseHover(By.xpath("//a[@id='ui-id-5']//span[@class='ui-menu-icon ui-icon ui-icon-carat-1-e']"));
        //* Mouse Hover on Bottoms
        mouseHover(By.cssSelector("a[id='ui-id-18'] span:nth-child(2)"));
        //* Click on Pants
        mouseHoverAndClick(By.xpath("//a[@id='ui-id-23']//span[contains(text(),'Pants')]"));
        //* Mouse Hover on product name ‘Cronus Yoga Pant’ and click on size 32
        mouseHover(By.xpath("//a[normalize-space()='Cronus Yoga Pant']"));
        mouseHoverAndClick(By.xpath("//div[@class='swatch-opt-880']//div[@id='option-label-size-143-item-175']"));
        //* Mouse Hover on product name ‘Cronus Yoga Pant’ and click on colour black
        mouseHover(By.cssSelector("body > div:nth-child(5) > main:nth-child(4) > div:nth-child(4) > div:nth-child(1) > div:nth-child(4) > ol:nth-child(1) > li:nth-child(1) > div:nth-child(1) > div:nth-child(2) > strong:nth-child(1) > a:nth-child(1)"));
        mouseHoverAndClick(By.xpath("(//div[@id='option-label-color-93-item-49'])[1]"));
        //* Mouse Hover on product name ‘Cronus Yoga Pant’ and click on ‘Add To Cart’ Button.
        mouseHover(By.xpath("//a[normalize-space()='Cronus Yoga Pant']"));
        mouseHoverAndClick(By.xpath("(//span[contains(text(),'Add to Cart')])[1]"));
        // verify the text ‘You added Cronus Yoga Pant to your shopping cart.’
        String actualVerifyMessage = driver.findElement(By.cssSelector("div[data-bind='html: $parent.prepareMessageForHtml(message.text)']")).getText();
        String expectedVerifyMessage ="You added Cronus Yoga Pant to your shopping cart.";
        Assert.assertEquals("Massage not matched",expectedVerifyMessage,actualVerifyMessage);

        //* Click on ‘shopping cart’ Link into message
        mouseHoverAndClick(By.xpath("//a[normalize-space()='shopping cart']"));
        // Verify the text ‘Shopping Cart.’
        String actualMessage = driver.findElement(By.xpath("//span[@class='base']")).getText();
        String expectedMessage ="Shopping Cart";
        Assert.assertEquals("Massage not matched",expectedMessage,actualMessage);

        // Verify the text ‘Cronus Yoga Pant.’
        String actualMessageForPant = driver.findElement(By.cssSelector("td[class='col item'] div[class='product-item-details'] a")).getText();
        String expectedMessageForPant ="Cronus Yoga Pant";
        Assert.assertEquals("Massage not matched",expectedMessageForPant,actualMessageForPant);

        // Verify the size 32.’
        String actualSizeOfPant = driver.findElement(By.xpath("//dd[contains(text(),'32')]")).getText();
        String expectedSizeOfPant ="32";
        Assert.assertEquals("Massage not matched",expectedSizeOfPant,actualSizeOfPant);

        // Verify the product colour black.
        String actualColorOfPant = driver.findElement(By.xpath("//dd[contains(text(),'Black')]")).getText();
        String expectedColorOfPant ="Black";
        Assert.assertEquals("Massage not matched",expectedColorOfPant,actualColorOfPant);

    }

    @After
    public void tearDown(){
        closeBrowser();
    }
}
