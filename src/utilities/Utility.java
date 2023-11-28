package utilities;

import browserfactory.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Utility extends BaseTest {

    public void clickOnElement(By by){
        driver.findElement(by).click();
    }

    public void sendTextToElement(By by, String text){
        driver.findElement(by).sendKeys(text);
    }

    public String getTextFromElement(By by){
        return driver.findElement(by).getText();
    }

    //********************************This is Select method*********************************************************//

    /**
     * selectByValueFromDropDown is generic method to select element by Value from dropdown
     */
    public void selectByValueFromDropDown(By by, String value){
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown); //Create object of select class
        select.selectByValue(value);
    }
    //selectbyindex

    public void selectByIndexFromDropDown(By by, int index){
        WebElement dropDown = driver.findElement(by); //Create object of select class
        Select select = new Select(dropDown);
        select.selectByIndex(index);
    }
    //select
    //************************************This is Action method ****************************************************//


    public void mouseHoverAndClick(By by){
        Actions actions = new Actions(driver); //Create object of alert class
        actions.moveToElement(driver.findElement(by)).click().build().perform();
    }
    /**
     * mouseHover is generic method for move to the specific element and click on it
     */
    public void mouseHover(By by){
        Actions actions = new Actions(driver); //Create object of alert class
        actions.moveToElement(driver.findElement(by)).build().perform();
    }
    //************************************This is Alert method*********************************************************//

}
