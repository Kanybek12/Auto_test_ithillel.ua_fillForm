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
    public void Fill_Form() throws InterruptedException {
        Integer hash = webDriver.hashCode();                //два равных объекта должны иметь одинаковое значение hashCode()
        String title = webDriver.getTitle();
        System.out.println("Сайт для тестов: " + webDriver.getCurrentUrl());
        assertEquals(URL, webDriver.getCurrentUrl());
        System.out.println("Количества символов в сайте: " + URL.length());
        System.out.println("Тест Заговолка: " + webDriver.getTitle());
        System.out.println("==============================");
        System.out.println("Нажимаем на кнопку консултация");
        webDriver.findElement(By.id("btn-consultation-hero")).click();
        webDriver.manage().window().maximize();
        System.out.println("Вводим имя");
        webDriver.findElement(By.id("form-consultation")).findElement(By.id("input-name-consultation")).sendKeys("Алманбек");
        System.out.println("Вводим mail");
        webDriver.findElement(By.id("input-email-consultation")).sendKeys("chippi@mail.ru");
        System.out.println("Вводим номер");
        webDriver.findElement(By.id("input-tel-consultation")).sendKeys("501234567");

        //Выбор курс через ListBox
        System.out.println("Выбираем курс");
        WebElement element = webDriver.findElement(By.xpath("//button[@id='listbox-btn-input-course-consultation']/span"));
        element.click();
        element.findElement(By.xpath("//div[@id='container-input-course-consultation']/div/ul/li[2]")).click();

        System.out.println("Выбранный курс: "+element.getText());
        System.out.println("Вводим коментарий");
        webDriver.findElement(By.id("input-comment-consultation")).sendKeys("Добавил No Comment");
        webDriver.findElement(By.className("checkbox_checkmark")).click();
        System.out.println("============================================");
        Thread.sleep(1000);
    }
}