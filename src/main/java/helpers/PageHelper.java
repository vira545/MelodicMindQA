package helpers;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;

import java.time.Duration;

public class PageHelper {
    protected WebDriver driver;
    public PageHelper(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@id='nav-icon']")
    WebElement dropDown;

    protected HomePage clickDropDown(){
        click(dropDown, 5);
        return new HomePage(driver);
    }

    protected void waitUntilElementClickable(WebElement element, int time){
        try {
            new WebDriverWait(driver, Duration.ofSeconds(time)).until(ExpectedConditions.elementToBeClickable(element));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    protected void waitUntilElementVisible(WebElement element, int time){
        try {
            new WebDriverWait(driver, Duration.ofSeconds(time)).until(ExpectedConditions.visibilityOf(element));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void pause(int time){
        try {
            Thread.sleep(time*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void click(WebElement element, int time){
        waitUntilElementClickable(element, time);
        element.click();
    }

    public void type(WebElement element, String text, int time){
        click(element, time);
        element.sendKeys(Keys.CONTROL+"a"); //element.clear() doesn't work
        element.sendKeys(Keys.DELETE);
        element.sendKeys(text);
    }

    public boolean isElementVisible(WebElement element, int time) {
        try {
            new WebDriverWait(driver,Duration.ofSeconds(time))
                    .until(ExpectedConditions.visibilityOf(element));
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
