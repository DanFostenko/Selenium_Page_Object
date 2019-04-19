import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class SignUpPageTest {
    private WebDriver driver;
    private SignUpPage signUpPage;

    @Before
    public void setUpMethod() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\bfostenko\\IdeaProjects\\testselenium\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); //waiting for element appearance
        driver.manage().window().maximize(); //maximize browser window
        driver.get("https://github.com/join");
        signUpPage = new SignUpPage(driver);
    }

    @Test
    public void signUpWithReservedUsername() {
        SignUpPage sp = signUpPage.typeUsername("testusername");
    }

    @Test
    public void signUpWithReservedEmail() {
        SignUpPage sp = signUpPage.typeEmail("test@email.com");
    }

    @Test
    public void signUpWithShortPass() {
        SignUpPage sp = signUpPage.typePassword("pass");
    }

    @Test
    public void getHeadingText() {
        String heading = signUpPage.getHeadingText();
        Assert.assertEquals("Join GitHub",heading);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
