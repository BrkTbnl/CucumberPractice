package Pages;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeftNav extends Parent{
    public LeftNav() {
        PageFactory.initElements(GWD.getDriver(),this);
    }

    @FindBy(xpath = "//span[text()='PIM']")
    public WebElement PIM;

    @FindBy(xpath = "//span[text()='Recruitment']")
    public WebElement Recruitment;


    public WebElement getWebElement(String strElement){

        switch (strElement){
            case "pim": return this.PIM;
            case "recruitment": return this.Recruitment;
        }
        return null;
    }

}
