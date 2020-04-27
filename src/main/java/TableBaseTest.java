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

public class TableBaseTest {
    JavascriptExecutor js;
    private WebDriver driver;
    private Map<String, Object> vars;
    public static final String patToProps = "src/test/resource/config.properties";
    public static String tableUrl;
    public static String loginUrl;

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
        String user = "user";
        String password = "user";
        login(user, password);
    }

    @After
    public void tearDown() {
        deleteLine(".grid-row:nth-child(1) .dt-icon");
        driver.quit();
    }

    protected String getTextFromElement(String elementName) {
        return driver.findElement(By.name(elementName)).getText();
    }

    protected void closeReviewMode() {
        driver.findElement(By.cssSelector(".close:nth-child(2) > .dt-icon")).click();
    }

    protected void openReviewMode() {
        driver.findElement(By.cssSelector(".grid-row:nth-child(1) .vis-icon-grid-review")).click();
    }

    protected void deleteLine(String lineMenuSelector) {
        driver.findElement(By.cssSelector(lineMenuSelector)).click();
        driver.findElement(By.linkText("Удалить")).click();
        isDeleteLine(".btn-warning");
    }

    private void isDeleteLine(String yesOrNoButton) {
        driver.findElement(By.cssSelector(yesOrNoButton)).click();
    }

    protected void addNewLine(String s1, String n) {
        driver.findElement(By.cssSelector(".button-title")).click();
        driver.findElement(By.cssSelector(".close:nth-child(2) > .dt-icon")).click();
        driver.findElement(By.cssSelector(".add-button")).click();
        driver.findElement(By.name("element_003a85d6-5d6d-4c37-2238-ffa119363a00")).sendKeys(s1);
        driver.findElement(By.name("element_cb2573c6-7f33-dc15-a9c2-bf7c43e702c7")).sendKeys(n);
        driver.findElement(By.cssSelector(".element-c2338469-1159-83a0-4dc7-8ca56e123187")).click();
    }

    protected void goToPage(String PageURL) {
        driver.get(PageURL);
    }

    private void login(String password, String user) {

        getLoginUrl();
        goToPage(loginUrl);
        driver.manage().window().setSize(new Dimension(885, 694));
        driver.findElement(By.id("auth-username")).click();
        driver.findElement(By.id("auth-username")).sendKeys(user);
        driver.findElement(By.id("auth-password")).sendKeys(password);
        driver.findElement(By.cssSelector(".btn-primary")).click();
        getTableUrl();
        goToPage(tableUrl);
    }

    public void getTableUrl() {
        FileInputStream fileInputStream;
        Properties prop = new Properties();

        try {
            //обращаемся к файлу и получаем данные
            fileInputStream = new FileInputStream(patToProps);
            prop.load(fileInputStream);

            tableUrl = prop.getProperty("tableUrl");

        } catch (IOException e) {
            System.out.println("Ошибка в программе: файл " + patToProps + " не обнаружено");
            e.printStackTrace();
        }
    }

    public void getLoginUrl() {
        FileInputStream fileInputStream;
        Properties prop = new Properties();

        try {
            //обращаемся к файлу и получаем данные
            fileInputStream = new FileInputStream(patToProps);
            prop.load(fileInputStream);

            loginUrl = prop.getProperty("loginUrl");

        } catch (IOException e) {
            System.out.println("Ошибка в программе: файл " + patToProps + " не обнаружено");
            e.printStackTrace();
        }
    }
    
    
}
