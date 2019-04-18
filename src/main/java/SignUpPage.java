import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage {
    WebDriver driver;

    public SignUpPage(WebDriver driver) { //class constructor
        this.driver = driver;
    }

    private By heading = By.xpath("//div[@class='setup-header setup-org']//h1"); //import class, create locator
    private By usernameField = By.xpath("//*[@id='user_login']");
    //private By userName = By.id("user_login"); //import class, create locator by ID
    private By emailField = By.xpath("//*[@id='user_email']");
    private By passwordField = By.xpath("//*[@id='user_password']");
    private By signUpButton = By.xpath("//button[@id='signup_button']");

    //methods to work with elements on SignUpPage
    public SignUpPage typeUsername(String username) { //Method: open SignUpPage, input username, return SignUpPage
        driver.findElement(usernameField).sendKeys(username);
        return this; //return Main Page page
    }

    public SignUpPage typeEmail(String email) { //Method: open SignUpPage, input email, return SignUpPage
        driver.findElement(emailField).sendKeys(email);
        return this; //return Main Page page
    }

    public SignUpPage typePassword(String password) { //Method: open SignUpPage, input password, return SignUpPage
        driver.findElement(passwordField).sendKeys(password);
        return this; //return Main Page page
    }

    public SignUpPage registerWithInvalidCreds(String username, String email, String password) {
        this.typeUsername(username);
        this.typeEmail(email);
        this.typePassword(password);
        driver.findElement(signUpButton).click();
        return new SignUpPage(driver);
    }

    public String getHeadingText() {
        return driver.findElement(heading).getText();
    }

}
