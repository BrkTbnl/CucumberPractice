package Pages;

import Utilities.GWD;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;


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

    @FindBy(xpath = "//p[@class='oxd-text oxd-text--p oxd-text--toast-title oxd-toast-content-text' and text()='Success']\n")
    public WebElement SuccessCheck;

    @FindBy(xpath = "//p[@class='oxd-text oxd-text--p oxd-text--toast-title oxd-toast-content-text' and text()='Already Exist']\n")
    public WebElement errorCheck;

    @FindBy(xpath = "(//*[@placeholder = \"Type here\"])[1]")
    public WebElement emailInput;

    @FindBy(xpath = "//button[@class=\"oxd-button oxd-button--medium oxd-button--secondary\"]")
    public WebElement AddButtonNew;

    @FindBy(xpath = "(//input[contains(@placeholder, \"Type for hints\")])[1]")
    public WebElement searchInput;

    @FindBy(xpath = "(//div[@class=\"oxd-form-actions\"]/button)[2]")
    public WebElement searchButton;

    @FindBy(xpath = "(//div[@class=\"orangehrm-paper-container\"]/div)[2]/div/span")
    public WebElement foundBy;

    @FindBy(xpath = "(//i[@class=\"oxd-icon bi-trash\"])[1]")
    public WebElement deleteButton;

    @FindBy(xpath = "//i[@class=\"oxd-icon bi-trash oxd-button-icon\"]")
    public WebElement deleteDialogButton;


    public void deleteItem(String searchText){
        mySendKeys(searchInput, searchText);
        myClick(searchButton);
        wait.until(ExpectedConditions.elementToBeClickable(deleteButton));
        myClick(deleteButton);
        myClick(deleteDialogButton);



    }














}
