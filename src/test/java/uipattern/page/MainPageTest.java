package uipattern.page;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertTrue;

public class MainPageTest {

    private WebDriver driver;
    private MainPage objMainPage;
    private LoginPage objLoginPage;
    private AccountPage objAccountPage;

    private final String email = "Niibosoi@Test.ru";
    private final String password = "123456";

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

    //Переход к разделу Соусы
    @Test
    @DisplayName("Constructor. Go to sauce") // имя теста
    @Description("Constructor. Go to sauce") // описание теста
    public void testGoToSauce() {
        objMainPage.openMainPage();
        objMainPage.clickSauce();
        MatcherAssert.assertThat(objMainPage.getElementClassName(objMainPage.getSection(), 1), containsString("current"));
    }

    //Переход к разделу Начинки
    @Test
    @DisplayName("Constructor. Go to filling") // имя теста
    @Description("Constructor. Go to filling") // описание теста
    public void testGoToFilling() {
        objMainPage.openMainPage();
        objMainPage.clickFilling();
        MatcherAssert.assertThat(objMainPage.getElementClassName(objMainPage.getSection(), 2), containsString("current"));
    }

    //Переход к разделу Булки
    @Test
    @DisplayName("Constructor. Go to buns") // имя теста
    @Description("Constructor. Go to buns") // описание теста
    public void testGoToBuns() {
        objMainPage.openMainPage();
        objMainPage.clickSauce();
        objMainPage.clickBun();
        MatcherAssert.assertThat(objMainPage.getElementClassName(objMainPage.getSection(), 0), containsString("current"));
    }

    //Вход авторизованного в "Личный кабинет"
    @Test
    @DisplayName("Go to personal account") // имя теста
    @Description("Go to personal account") // описание теста
    public void testGoToPersonalAccount() throws InterruptedException {
        objMainPage.openMainPage();
        objMainPage.clickPersonalAccount();
        objLoginPage.loginUser(email, password);
        objMainPage.clickPersonalAccount();
        WaitForLoad.waitForLoadXpath(objAccountPage.getUserAccount());
        assertTrue(objAccountPage.getActualText(objAccountPage.getUserAccount()).contains("В этом разделе вы можете изменить свои персональные данные"));
    }

    @After
    public void teardown() {
        driver.quit(); // Закрой браузер
    }

}
