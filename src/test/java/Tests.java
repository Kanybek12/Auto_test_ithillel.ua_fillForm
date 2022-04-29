import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.assertEquals;


public class Tests {
    private WebDriver webDriver;
    public static final String URL = "https://ithillel.ua/";

    @Before
    public void setUp() {
        System.out.println("Start Testing...");
        System.setProperty("webdriver.chrome.driver", "C:\\WebDrivers\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.get(URL);
        System.out.println("Open website for Testing");
    }

    @After
    public void cleanUp() {
        System.out.println("Close browser");
        if(webDriver != null)
            webDriver.quit();
    }

    @Test
//    public void Test_1() {
//        System.out.println("Check URL");
//        System.out.println(webDriver.getCurrentUrl());
//        assertEquals(URL, webDriver.getCurrentUrl());
//        System.out.println(webDriver.getTitle());
//        System.out.println("Done test URL");
//        System.out.println("==============================");
//    }
//
//@Test
    public void Fill_Form() throws InterruptedException {
        System.out.println("Нажимаем на кнопку");
        webDriver.findElement(By.id("btn-consultation-hero")).click();
        webDriver.manage().window().maximize();
        System.out.println("Enter name");
        webDriver.findElement(By.id("form-consultation")).findElement(By.id("input-name-consultation")).sendKeys("Алманбек");
        System.out.println("Enter mail");
        webDriver.findElement(By.id("input-email-consultation")).sendKeys("chippi@mail.ru");
        System.out.println("Enter number");
        webDriver.findElement(By.id("input-tel-consultation")).sendKeys("501234567");

        System.out.println("Choice course");
        webDriver.findElement(By.xpath("//button[@id='listbox-btn-input-course-consultation']/span")).click();
        webDriver.findElement(By.xpath("//div[@id='container-input-course-consultation']/div/ul/li[3]")).click();
//        WebElement element = webDriver.findElement(By.xpath("//div[@id='container-input-course-consultation']/div/ul/li[4]"));
//        element.findElement(By.name("Front-end Pro")).getText().contains("Front-end Pro");
//        System.out.println(element);

        System.out.println("Enter comment");
        webDriver.findElement(By.id("input-comment-consultation")).sendKeys("No Comment");
        System.out.println("Mark");
        webDriver.findElement(By.className("checkbox_checkmark")).click();
        System.out.println("End");
        Thread.sleep(10000);


    }
}