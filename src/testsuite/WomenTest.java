package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class WomenTest extends Utility {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyTheSortByProductNameFilter() {
        //Mouse Hover on Women Menu
        mouseHover(By.xpath("//span[normalize-space()='Women']"));

        // Mouse Hover on Tops
        mouseHover(By.xpath("//a[@id='ui-id-9']//span[contains(text(),'Tops')]"));

        //Click on Jackets
        mouseHoverAndClick(By.xpath("//a[@id='ui-id-11']//span[contains(text(),'Jackets')]"));

        //Select Sort By filter “Product Name”

        selectByValueFromDropDown(By.xpath("//div[@class='page-wrapper']//div[2]//div[3]//select[1]"), "name");

        ////select[@id='sorter'and @fdprocessedid='a36cnx']//option[@value='name' and contains(text(), 'Product Name')]
        String expectedValueOfFirstImage = driver.findElement(By.xpath("(//select[@id='sorter'and @fdprocessedid='a36cnx']//option[@value='name' and contains(text(),'Product Name')]")).getText();
        String actualValueOfFirstImage = "Product Name";
        Assert.assertEquals("Both value should match",expectedValueOfFirstImage,actualValueOfFirstImage);

    }

    @Test
    public void verifyTheSortByPriceFilter() {
        //Mouse Hover on Women Menu
        mouseHover(By.xpath("//span[normalize-space()='Women']"));

        // Mouse Hover on Tops
        mouseHover(By.xpath("//a[@id='ui-id-9']//span[contains(text(),'Tops')]"));

        //Click on Jackets
        mouseHoverAndClick(By.xpath("//a[@id='ui-id-11']//span[contains(text(),'Jackets')]"));

        //Select Sort By filter “Price//”
        selectByIndexFromDropDown(By.xpath("(//select[@id='sorter'])[1]"), 2);
        //* Verify the products price display in Low to High
       String expectedValueOfFirstImage = driver.findElement(By.xpath("(//select[@id='sorter'])[1]//option[@value='price']")).getText();
       String actualValueOfFirstImage = "Price";
       Assert.assertEquals("Both value should match",expectedValueOfFirstImage,actualValueOfFirstImage);
    }

    @After
        public void tearDown(){
            closeBrowser();
        }
    }
