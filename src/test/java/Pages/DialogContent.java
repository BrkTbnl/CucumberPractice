package Pages;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class DialogContent extends Parent {
    public DialogContent() {
        PageFactory.initElements(GWD.getDriver(),this);
    }

    @FindBy(name = "username")
    public WebElement username;

    @FindBy(name = "password")
    public WebElement password;

    @FindBy(xpath = "//button[@class=\"oxd-button oxd-button--medium oxd-button--main orangehrm-login-button\"]")
    public WebElement loginButton;

    @FindBy(xpath = "//*[contains(@class, 'oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module')]")
    public WebElement LoginCheck;

    @FindBy(xpath = "//*[contains(text(), \"Add\")]")
    public WebElement addButton;

    @FindBy(css = "[placeholder=\"First Name\"]")
    public WebElement nameInput;

    @FindBy(css = "[placeholder = \"Last Name\"]")
    public WebElement lastNameInput;

    @FindBy(xpath = "//button[@class=\"oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space\"]")
    public WebElement saveButton;

    @FindBy(xpath = "//div[@class=\"orangehrm-edit-employee-name\"]")
    public WebElement employeeName;

}
