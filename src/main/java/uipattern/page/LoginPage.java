package uipattern.page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginPage {

    private static WaitForLoad waitForLoad;
    public static By input = By.xpath(".//*[@id='root']/div/main/div/h2");
    private WebDriver driver;
    public By inputAccountOrder = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg']");

    //входные данные для регистрации
    private By inputs = By.xpath(".//input[@class='text input__textfield text_type_main-default']");
    public By registrationLogin = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']");

    //локатор перенаправления на форму Зарегистрироваться
    private By registr = By.xpath(".//*[@id='root']/div/main/div/div/p[1]/a");

    //авторизация с разных форм
    public By inputFromRegistr = By.xpath(".//*[@id='root']/div/main/div/div/p/a");
    public By inputFromForgetPassword = By.xpath(".//*[@id='root']/div/main/div/div/p[2]/a");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.waitForLoad = new WaitForLoad(driver);
    }

    //Объединенный метод Login пользователя
    @Step("User Login")
    public void loginUser(String email, String password) throws InterruptedException {
        setInputsPersonalLogin(email, password);
        clickRegistrationLoginButton();
        waitForLoad.waitForLoadXpath(inputAccountOrder);
    }

    //метод заполняет поле ввода Email, Пароль
    public void setInputsPersonalLogin(String email, String password) {
        List<WebElement> listInputs = driver.findElements(inputs);
        listInputs.get(0).sendKeys(email);
        listInputs.get(1).sendKeys(password);
    }

    //метод кликает по кнопке Зарегистрироваться
    public void clickRegistrationLoginButton() {
        driver.findElement(registrationLogin).click();
    }

    // метод клика по "Зарегистрироваться"
    public void clickRegistr() {
        driver.findElement(registr).click();
    }

    //метод кликает по кнопке Войти с формы регистрации
    public void clickInputFromRegistr() {
        driver.findElement(inputFromRegistr).click();
    }

    //метод кликает по кнопке Восстановить пароль
    public void clickInputFromForgetPassword() {
        driver.findElement(inputFromForgetPassword).click();
    }

    // метод получения текста элемента
    public String getActualText(By by) {
        return driver.findElement(by).getText();
    }
}
