import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) { //class constructor
        this.driver = driver;
    }

    private By signInButton = By.xpath("//a[@class='HeaderMenu-link no-underline mr-3']"); //locator for Sign in button
    private By signUpButton = By.xpath("//a[@class='HeaderMenu-link d-inline-block no-underline border border-gray-dark rounded-1 px-2 py-1']"); //locator for Sign up button
    private By usernameField = By.xpath("//*[@id='user[login]']"); //locator for Username field
    private By emailField = By.xpath("//*[@id='user[email]']"); //locator for Email field
    private By passwordField = By.xpath("//*[@id='user[password]']"); //locator for Password field
    private By signUpFormButton = By.xpath("//button[text()='Sign up for free']"); //locator for Sign up for free button

    public LoginPage clickSignIn() { //Method: click Sign in, go to Login page
        driver.findElement(signInButton).click();
        return new LoginPage(driver);
    }

    public SignUpPage clickSignUpButton() { //Method: click Sign up, go to Join GitHub page
        driver.findElement(signUpButton).click();
        return new SignUpPage(driver);
    }

    public SignUpPage clickSignUpFormButton() { //Method: click Sign up for free, go to Join GitHub page
        driver.findElement(signUpFormButton).click();
        return new SignUpPage(driver);
    }

    public MainPage typeUsername(String username) { //Method: open Main Page, input username
        driver.findElement(usernameField).sendKeys(username);
        return this; //return Main Page page
    }

    public MainPage typeEmail(String email) { //Method: open Main Page, input email
        driver.findElement(emailField).sendKeys(email);
        return this; //return Main Page page
    }

    public MainPage typePassword(String password) { //Method: open Main Page, input password
        driver.findElement(passwordField).sendKeys(password);
        return this; //return Main Page page
    }

    public SignUpPage register(String username, String email, String password) {
        this.typeUsername(username);
        this.typeEmail(email);
        this.typePassword(password);
        this.clickSignUpFormButton();
        return new SignUpPage(driver);
    }

}
