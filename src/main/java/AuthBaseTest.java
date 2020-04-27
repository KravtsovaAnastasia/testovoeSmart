import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class AuthBaseTest {
    protected WebDriver driver;
    JavascriptExecutor js;
    private Map<String, Object> vars;
    public static final String patToProps = "src/test/resource/config.properties";
    public static String loginUrl;
    public static String pathTodriver = "C:/Users/f0urth/IdeaProjects/geckodriver.exe";

    @Before
    public void setUp() {
        getDriverPath();
        System.setProperty("webdriver.gecko.driver", pathTodriver);
        driver = new FirefoxDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();

    }

    @After
    public void tearDown() {
        driver.quit();
    }

    protected void login(String user, String password) {

        getLoginUrl();
        goToPage(loginUrl);
        driver.manage().window().setSize(new Dimension(885, 693));
        driver.findElement(By.id("auth-username")).clear();
        driver.findElement(By.id("auth-username")).sendKeys(user);
        driver.findElement(By.id("auth-password")).clear();
        driver.findElement(By.id("auth-password")).sendKeys(password);
        driver.findElement(By.cssSelector(".btn-primary")).click();
    }

    public void getLoginUrl() {
        FileInputStream fileInputStream;
        Properties prop = new Properties();

        try {
            fileInputStream = new FileInputStream(patToProps);
            prop.load(fileInputStream);

            loginUrl = prop.getProperty("loginUrl");

        } catch (IOException e) {
            System.out.println("Ошибка в программе: файл " + patToProps + " не обнаружено");
            e.printStackTrace();
        }
    }

    public void getDriverPath() {
        FileInputStream fileInputStream;
        Properties prop = new Properties();

        try {
            fileInputStream = new FileInputStream(patToProps);
            prop.load(fileInputStream);

            pathTodriver = prop.getProperty("geckoPath");

        } catch (IOException e) {
            System.out.println("Ошибка в программе: файл " + patToProps + " не обнаружено");
            e.printStackTrace();
        }
    }

    protected void goToPage(String PageURL) {
        driver.get(PageURL);
    }
}
