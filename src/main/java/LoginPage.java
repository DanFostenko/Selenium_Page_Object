import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) { //class constructor
        this.driver = driver;
    }

    private By loginField = By.xpath("//*[@id='login_field']"); //create element
    private By passwordField = By.xpath("//*[@id='password']");
    private By signInButton = By.xpath("//input[@type='submit']");
    private By heading = By.xpath("//div[@class='auth-form-header p-0']/h1");
    private By error = By.xpath("//*[@id='js-flash-container']//div[@class='container']");
    private By createAcclink = By.xpath("//a[text()='Create an account']");

    public LoginPage typeUsername(String username) { //Method to input Username; method typeUsername accepts username
        driver.findElement(loginField).sendKeys(username);
        return this;
    }

    public LoginPage typePassword(String password) { //Method to input Password; method typePassword accepts password
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public LoginPage loginWithInvalidCreds(String username, String password) { //Method to check whether login was incorrect; method loginWithInvalidCreds accepts username and password
        this.typeUsername(username);
        this.typePassword(password);
        driver.findElement(signInButton).click();
        return new LoginPage(driver);
    }

    public String getHeadingText() { //Method to check 'Sign in to GitHub' text on the page
        return driver.findElement(heading).getText();
    }

    public String getErrorText() { //Method to check error message
        return driver.findElement(error).getText();
    }

    public SignUpPage createAccount() { //Click the link and go to Sign up page
        driver.findElement(createAcclink).click();
        return new SignUpPage(driver);
    }
}
