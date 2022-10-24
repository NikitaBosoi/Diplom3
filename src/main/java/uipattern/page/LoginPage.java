package uipattern.page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginPage {

    private static WaitForLoad waitForLoad;
    private static By input = By.xpath("//*[@id='root']/div/main/div/h2");
    private WebDriver driver;
    private By inputAccountOrder = By.cssSelector(".button_button__33qZ0.button_button_type_primary__1O7Bx.button_button_size_large__G21Vg");

    //входные данные для регистрации
    private By inputName = By.name("name");
    private By inputSurname = By.name("Пароль");
    private By registrationLogin = By.cssSelector(".button_button__33qZ0.button_button_type_primary__1O7Bx.button_button_size_medium__3zxIa");

    //локатор перенаправления на форму Зарегистрироваться
    private By registr = By.xpath(".//a[contains(text(),'Войти')]");

    //авторизация с разных форм
    private By inputFromRegistr = By.xpath("//a[contains(text(),'Зарегистрироваться')]");
    private By inputFromForgetPassword = By.xpath("//a[contains(text(),'Восстановить пароль')]");

    public By getInput(){
        return input;
    }

    public By getRegistrationLogin(){
        return registrationLogin;
    }

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
    private void setInputsPersonalLogin(String email, String password) {
        driver.findElement(inputName).sendKeys(email);
        driver.findElement(inputSurname).sendKeys(password);
    }

    //метод кликает по кнопке Зарегистрироваться
    private void clickRegistrationLoginButton() {
        driver.findElement(registrationLogin).click();
    }

    // метод клика по "Зарегистрироваться"
    @Step
    public void clickRegistr() {
        driver.findElement(registr).click();
    }

    //метод кликает по кнопке Восстановить пароль
    @Step
    public void clickInputFromForgetPassword() {
        driver.findElement(inputFromForgetPassword).click();
    }

    // метод получения текста элемента
    @Step
    public String getActualText(By by) {
        return driver.findElement(by).getText();
    }
}
