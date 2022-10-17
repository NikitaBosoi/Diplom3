package uipattern.page;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

public class LoginPageTest {

    private WebDriver driver;
    private final String email = "Niibosoi@Test.ru";
    private final String password = "123456";

    private MainPage objMainPage;
    private LoginPage objLoginPage;
    private RegistrationPage objRegistrationPage;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\adm\\WebDriver\\bin\\chromedriver.exe");
//        System.setProperty("webdriver.chrome.driver","C:\Users\adm\WebDriver\bin\\yandexdriver.exe");
        driver = new ChromeDriver();
        objMainPage = new MainPage(driver);
        objLoginPage = new LoginPage(driver);
        objRegistrationPage = new RegistrationPage(driver);
    }


    //Вход через "Личный кабинет"
    @Test
    @DisplayName("Login user with personal account") // имя теста
    @Description("Login user with personal account") // описание теста
    public void testLoginUserPersonalAccount() throws InterruptedException {
        objMainPage.openMainPage();
        objMainPage.clickPersonalAccount();
        objLoginPage.loginUser(email, password);
        assertTrue(objMainPage.getActualText(objMainPage.inputAccountOrder).contains("Оформить заказ"));
    }

    //Вход через "Войти в аккаунт"
    @Test
    @DisplayName("Login user with input account") // имя теста
    @Description("Login user with input account") // описание теста
    public void testLoginUserInputAccount() throws InterruptedException {
        objMainPage.openMainPage();
        objMainPage.clickLoginAccount();
        objLoginPage.loginUser(email, password);
        assertTrue(objMainPage.getActualText(objMainPage.inputAccountOrder).contains("Оформить заказ"));
    }

    //вход через кнопку в форме регистрации
    @Test
    @DisplayName("Login user from registration") // имя теста
    @Description("Login user from registration") // описание теста
    public void testLoginUserInputAccountFromRegistration() throws InterruptedException {
        objMainPage.openMainPage();
        objMainPage.clickLoginAccount();
        objLoginPage.clickRegistr();
        objRegistrationPage.clickInputFromRegistr();
        objLoginPage.loginUser(email, password);
        assertTrue(objMainPage.getActualText(objMainPage.inputAccountOrder).contains("Оформить заказ"));
    }

    //вход через кнопку "Восстановить пароль"
    @Test
    @DisplayName("Login user from forget password") // имя теста
    @Description("Login user from forget password") // описание теста
    public void testLoginUserInputAccountFromForgetPassword() throws InterruptedException {
        objMainPage.openMainPage();
        objMainPage.clickPersonalAccount();
        objLoginPage.clickInputFromForgetPassword();
        objLoginPage.clickInputFromRegistr();
        objLoginPage.loginUser(email, password);
        assertTrue(objMainPage.getActualText(objMainPage.inputAccountOrder).contains("Оформить заказ"));
    }

    @After
    public void teardown() {
        driver.quit(); // Закрой браузер
    }

}
