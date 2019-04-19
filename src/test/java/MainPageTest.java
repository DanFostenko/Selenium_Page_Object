import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class MainPageTest {
    private WebDriver driver;
    private MainPage mainPage;

    @Before
    public void setUpMethod() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\bfostenko\\IdeaProjects\\testselenium\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); //waiting for element appearance
        driver.manage().window().maximize(); //maximize browser window
        driver.get("https://github.com");
        mainPage = new MainPage(driver);
    }

    @Test
    public void signInTest() {
        LoginPage loginPage = mainPage.clickSignIn();
        String heading = loginPage.getHeadingText();
        Assert.assertEquals("Sign in to GitHub",heading);
    }

    @Test
    public void registerFailTest() {
        SignUpPage signUpPage = mainPage.register("testusername", "test@email.com", "password");
        String message = signUpPage.getHeadingText();
        Assert.assertEquals("Join GitHub", message);
    }

    @Test
    public void signUpEmptyUsernameTest() {
        SignUpPage signUpPage = mainPage.register("", "test@email.com", "password");
        String message = signUpPage.getHeadingText();
        Assert.assertEquals("Join GitHub", message);
    }

    @After
    public void tearDownMethod() {
        driver.quit();
    }
}
