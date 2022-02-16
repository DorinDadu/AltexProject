package Help;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ElementMethods {

    public WebDriver driver;

    public ElementMethods(WebDriver driver) {
        this.driver = driver;
    }

    public void clickElement(WebElement element){
        waitElement(element);
        element.click();

    }

    public void scrollElement(String value){
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript(value);
    }

    public void waitImplicitElement(long time){
        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);

    }

    public void waitElement(WebElement element){
        WebDriverWait Wait= new WebDriverWait(driver, Duration.ofSeconds(60));
        Wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void fillElement(WebElement element, String value){
        waitElement(element);
        element.sendKeys(value);
    }

    public void movetoElement(WebElement element){
        waitElement(element);
        Actions Action= new Actions(driver);
        Action.moveToElement(element).perform();
    }

    public void validateElementText(WebElement element, String value){

        waitElement(element);
        String actualmsg=element.getText();
        Assert.assertEquals("textul cautat nu e corect",value,actualmsg);
    }

    public void selectElementBytext(WebElement element, String value){
        Select dropdown= new Select(element);
        dropdown.selectByVisibleText(value);
    }

    public void selectElementByvalue(WebElement element, String value){
        Select dropdown= new Select(element);
        dropdown.selectByValue(value);
    }

    public void sendEnter(WebElement element){
        element.sendKeys(Keys.ENTER);
    }



}




