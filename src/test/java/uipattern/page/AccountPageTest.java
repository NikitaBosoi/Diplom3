package uipattern.page;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

public class AccountPageTest {

    private WebDriver driver;
    private final String email = "Niibosoi@Test.ru";
    private final String password = "123456";
    private MainPage objMainPage;
    private LoginPage objLoginPage;

    private AccountPage objAccountPage;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\adm\\WebDriver\\bin\\chromedriver.exe");
//        System.setProperty("webdriver.chrome.driver","C:\Users\adm\WebDriver\bin\\yandexdriver.exe");
        driver = new ChromeDriver();

        objMainPage = new MainPage(driver);
        objLoginPage = new LoginPage(driver);
        objAccountPage = new AccountPage(driver);
    }


    //Вход авторизованного в "Конструктор" через клик по "Конструктор"
    @Test
    @DisplayName("Go to Constructor from personal account with Constructor") // имя теста
    @Description("Go to Constructor from personal account with Constructor") // описание теста
    public void testGoToConstructor() throws InterruptedException {
        InAccount();
        objAccountPage.clickConstructor();
        assertTrue(objMainPage.getActualText(objMainPage.getMakeBurger()).contains("Соберите бургер"));
    }

    //Вход авторизованного в "Конструктор" через клик по Лого
    @Test
    @DisplayName("Go to Constructor from personal account with Logo") // имя теста
    @Description("Go to Constructor from personal account with Logo") // описание теста
    public void testGoToConstructorWithLogo() throws InterruptedException {
        InAccount();
        objAccountPage.clickLogo();
        assertTrue(objMainPage.getActualText(objMainPage.getMakeBurger()).contains("Соберите бургер"));
    }

    //Выход авторизованного из аккаунта
    @Test
    @DisplayName("Logout user") // имя теста
    @Description("Logout user") // описание теста
    public void testLogoutUser() throws InterruptedException {
        InAccount();
        WaitForLoad.waitForLoadXpath(objAccountPage.getLogout());
        objAccountPage.clickLogout();
        Thread.sleep(1000);
        assertTrue(objLoginPage.getActualText(objLoginPage.getRegistrationLogin()).contains("Войти"));
    }

    @After
    public void teardown() {
        driver.quit(); // Закрой браузер
    }

    //Объединенный метод для нахождения пользователя в личном кабинете
    @Step("User Personal Account")
    public void InAccount() throws InterruptedException {
        objMainPage.openMainPage();
        objMainPage.clickPersonalAccount();
        objLoginPage.loginUser(email, password);
        objMainPage.clickPersonalAccount();
    }
}
