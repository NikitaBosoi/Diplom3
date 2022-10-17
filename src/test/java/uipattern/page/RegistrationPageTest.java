package uipattern.page;
import java.util.Random;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

public class RegistrationPageTest {

    private WebDriver driver;

    private MainPage objMainPage;
    private RegistrationPage objRegistrationPage;
    Random random = new Random();
    String name = "Nikita"+ random.nextInt(1000)+"@yandex.ru";
    String email = "Nikita"+ random.nextInt(1000)+"@yandex.ru";
    String password = "Nikita"+ random.nextInt(1000)+"@yandex.ru";
    String passwordFail = "N"+ random.nextInt(100);


    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\adm\\WebDriver\\bin\\chromedriver.exe");
//        System.setProperty("webdriver.chrome.driver","C:\Users\adm\WebDriver\bin\\yandexdriver.exe");
        driver = new ChromeDriver();

        objMainPage = new MainPage(driver);
        objRegistrationPage = new RegistrationPage(driver);
    }

    //Успешная регистрация
    @Test
    @DisplayName("Success user registration") // имя теста
    @Description("Success user registration") // описание теста
    public void testRegistrationUser() throws InterruptedException {
        objMainPage.openMainPage();
        objRegistrationPage.registrationUser(name, email, password);
        assertTrue(objRegistrationPage.getActualText(LoginPage.input).contains("Вход"));
    }

    //Неуспешная регистрация
    @Test
    @DisplayName("Fail user registration") // имя теста
    @Description("Fail user registration") // описание теста
    public void testFailRegistrationUser() throws InterruptedException {
        objMainPage.openMainPage();
        objRegistrationPage.registrationUser(name, email, passwordFail);
        assertTrue(objRegistrationPage.getActualText(objRegistrationPage.inputError).contains("Некорректный пароль"));
    }

    @After
    public void teardown() {
        driver.quit(); // Закрой браузер
    }

}
