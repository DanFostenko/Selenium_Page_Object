import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class MainClass {
    static WebDriver driver;
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\bfostenko\\IdeaProjects\\testselenium\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //waiting for element appearance
        driver.manage().window().maximize(); //maximize browser window

        driver.get("https://github.com");
        MainPage mainPage = new MainPage(driver);
        //MainPage mainPage = PageFactory.initElements(driver, MainPage.class); //get mainPage object, initialize class
        mainPage.register("testusername", "test@email.com", "password");
        driver.quit(); //end work of driver
    }
}
