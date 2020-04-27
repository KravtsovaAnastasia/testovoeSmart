import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.HashMap;
import java.util.Map;

public class AuthBaseTest {
    protected WebDriver driver;
    JavascriptExecutor js;
    private Map<String, Object> vars;

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "C:/Users/f0urth/IdeaProjects/geckodriver.exe");
////        FirefoxOptions options = new FirefoxOptions().addArguments("--incognito");options
//        driver = new FirefoxDriver();
        driver = new FirefoxDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();

    }

    @After
    public void tearDown() {
        driver.quit();
    }

    protected void login(String user, String password) {
        driver.get("http://point3.smart-consulting.ru/");
        driver.manage().window().setSize(new Dimension(885, 693));
        driver.findElement(By.id("auth-username")).clear();
        driver.findElement(By.id("auth-username")).sendKeys(user);
        driver.findElement(By.id("auth-password")).clear();
        driver.findElement(By.id("auth-password")).sendKeys(password);
        driver.findElement(By.cssSelector(".btn-primary")).click();
    }
}
