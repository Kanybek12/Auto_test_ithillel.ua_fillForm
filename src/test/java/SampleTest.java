import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SampleTest {

    private WebDriver webDriver;

    @Before
    public void setUp() {
        System.out.println("Start Browser");
        System.setProperty("webdriver.chrome.driver", "C:\\WebDrivers\\chromedriver.exe");
        webDriver = new ChromeDriver();
        System.out.println("Open website");
        webDriver.get("https://ithillel.ua/");
    }

    @After
    public void cleanUp() {
        System.out.println("Close browser");
        if(webDriver != null)
            webDriver.quit();
    }

    @Test
    public void Test_new() {
        System.out.println("Check url");
        assertEquals("https://ithillel.ua/ua", webDriver.getCurrentUrl());

        System.out.println("Check title");
        assertEquals("Комп'ютерна школа Hillel у Києві: курси IT-технологій", webDriver.getTitle());
    }

    @Test
    public void registerToCourse() throws InterruptedException {
        System.out.println("Click free consultation");
        webDriver.findElement(By.id("btn-consultation-hero")).click();
        System.out.println("Enter name");
        webDriver.findElement(By.id("form-consultation")).findElement(By.id("input-name-consultation")).sendKeys("Алманбек");
        System.out.println("Enter mail");
        webDriver.findElement(By.id("input-email-consultation")).sendKeys("chippi@mail.ru");
        System.out.println("Enter number");
        webDriver.findElement(By.id("input-tel-consultation")).sendKeys("501234567");
        System.out.println("Choice course");
        webDriver.findElement(By.id("container-input-course-consultation")).click();
        System.out.println("Enter comment");
        webDriver.findElement(By.id("input-comment-consultation")).sendKeys("No Comment");
        System.out.println("Mark");
        webDriver.findElement(By.className("checkbox_checkmark")).click();
        System.out.println("End");

     //   webDriver.findElements(By.xpath("\\input[@checked='true']");
      //  System.out.println(option.getText());
       // webDriver.findElement(By.linkText("Front-end Basic"));
        Thread.sleep(1000);

//        System.out.println("Enter email");
  //      webDriver.findElement(By.id("signCourses")).findElement(By.id("modal_email")).click();
   //     webDriver.findElement(By.id("signCourses")).findElement(By.id("modal_email")).sendKeys("ivan@gmail.com");

   //     System.out.println("Enter phonenumber");
    //    webDriver.findElement(By.id("signCourses")).findElement(By.id("modal_phone")).click();
    //    webDriver.findElement(By.id("signCourses")).findElement(By.id("modal_phone")).sendKeys("+38 (012) 345-67-89");

      //  System.out.println("Check error message");
      //  assertTrue(webDriver.findElement(By.id("signCourses")).findElement(By.className("modal__error")).getText().contains("Обязательно выберите курс, на который хотите отправить заявку"));

    }
}