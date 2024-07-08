package Pages;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DialogContent {
    public DialogContent() {
        PageFactory.initElements(GWD.getDriver(),this);
    }

    @FindBy(name = "username")
    public WebElement username;

    @FindBy(name = "password")
    public WebElement password;

    @FindBy(xpath = "//button[@class=\"oxd-button oxd-button--medium oxd-button--main orangehrm-login-button\"]")
    public WebElement loginButton;

    public void Click(WebElement element){

        WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        //scrol
        element.click();
    }

    public void SendKeys(WebElement element, String typo){

        WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(element));
        //scrol
        element.clear();
        element.sendKeys(typo);
    }
}
