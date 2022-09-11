
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.Keys.BACK_SPACE;


public class SelenideTest {
//    private WebDriver driver;
//
//    @BeforeAll
//    static void setupAll() {
//        WebDriverManager.chromedriver().setup();
//
//    }
//
//
//    @BeforeEach
//    void setup() {
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--disable-dev-shm-usage");
//        options.addArguments("--no-sandbox");
//        options.addArguments("--headless");
//        driver = new ChromeDriver(options);
//
//
//    }
//
//
//
//
//
//    @AfterEach
//    void teardown() {
//        driver.quit();
//        driver = null;
//    }

//    @BeforeEach
//    void openBrowser() {
//        open("http://localhost:9999");
//    }

    //xpath
//public String generateDate(int days) {
//    return LocalDate.now().plusDays(days).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
//}
//    @Test
//    void test() {
//        String planningDate = generateDate(5);
//        Configuration.holdBrowserOpen = true;
//        open("http://localhost:9999");
//        $x("//input[@placeholder='Город']").setValue("Махачкала");
//        $x("//input [@placeholder='Дата встречи']").doubleClick();
//        $x("//input [@placeholder='Дата встречи']").sendKeys(Keys.DELETE);
//        $x("//input [@placeholder='Дата встречи']").setValue(planningDate);
//        $x("//input[@name='name']").setValue("Дарья Се-ливерстова");
//        $x("//input[@name='phone']").setValue("+74951384061");
//        $x("//span[@class='checkbox__box']").click();
//        $x("//*[text()='Забронировать']").click();
//        $x("//div[@class='notification notification_visible notification_has-closer notification_stick-to_right notification_theme_alfa-on-white']").
//                should(visible, Duration.ofSeconds(15));
//        $(".notification__content")
//                .shouldHave(Condition.text("Встреча успешно забронирована на " + planningDate), Duration.ofSeconds(15))
//                .shouldBe(Condition.visible);

    //xpath end

    //var 1
//    public String generateDate(int days) {
//        return LocalDate.now().plusDays(days).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
//    }
//
//    //нужна логика для даты
//    @Test
//    void test() {
//        open("http://localhost:9999");
//        $("[data-test-id='city'] input").setValue("Кострома");
//        $("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);
//        String planningDate = generateDate(4);
//        $("[data-test-id='date'] input").val(planningDate);
//
//        $("[data-test-id=name] input").setValue("Мария");
//        $("[data-test-id=phone] input").setValue("+79103729929");
//        $("[data-test-id=agreement]").click();
//        $x("//span[@class='button__text']").click();
//        $(".notification__content")
//                .shouldBe(text("Встреча успешно забронирована на " + planningDate), Duration.ofSeconds(15))
//                .shouldBe(visible);
//
//
//    }
// var1 end

    @BeforeEach
    void open() {
        Selenide.open("http://localhost:9999/");
    }

    public String generateDate(int days) {
        return LocalDate.now().plusDays(days).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    @Test
    void test() {
        $("[data-test-id=city] input").setValue("Москва");
        $("[data-test-id=date] .input__control").click();
        $("[data-test-id=date] .input__control").sendKeys(Keys.CONTROL + "A");
        $("[data-test-id=date] .input__control").sendKeys(BACK_SPACE);
        $("[data-test-id=date] .input__control").setValue(generateDate(7));
        $("[data-test-id=name] .input__control").setValue("Иван Иванов");
        $("[data-test-id=phone] .input__control").setValue("+71234567891");
        $("[data-test-id=agreement]").click();
        $x("//button[contains(@class, 'button_view_extra')]").click();
        $("[data-test-id=notification]").shouldBe(visible, Duration.ofSeconds(15));
        $("[data-test-id=notification] [class='notification__content']").shouldHave(exactText("Встреча успешно забронирована на " + generateDate(7)));
    }

//
//
//        open("http://localhost:9999");
//        $("[data-test-id='city'] input").setValue("Кострома");
//        $("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);
//        String planningDate = generateDate(4);
//        $("[data-test-id='date'] input").val(planningDate);
//
//        $("[data-test-id=name] input").setValue("Мария");
//        $("[data-test-id=phone] input").setValue("+79103729929");
//        $("[data-test-id=agreement]").click();
//        $x("//span[@class='button__text']").click();
//        $(".notification__content")
//                .shouldBe(text("Встреча успешно забронирована на " + planningDate), Duration.ofSeconds(15))
//                .shouldBe(visible);

//        Configuration.holdBrowserOpen = true;
//      $("span[data-test-id='name'] input").setValue("Иванова Мария");
//        driver.findElement(By.cssSelector("span[data-test-id='phone'] input")).sendKeys("+79123456789");
//        driver.findElement(By.cssSelector("[data-test-id='agreement']")).click();
//        driver.findElement(By.className("button_view_extra")).click();
//        String text = driver.findElement(By.className("paragraph")).getText();
//        assertEquals("  Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.", text);
    }


