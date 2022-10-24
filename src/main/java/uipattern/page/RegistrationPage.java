package uipattern.page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RegistrationPage {

    private static WebDriver driver;
    private static WaitForLoad waitForLoad;

    //локатор кнопки Личный кабинет
    private By personalAccount = By.xpath("//p[contains(text(),'Личный Кабинет')]");

    //локатор перенаправления на форму Зарегистрироваться
    private By registr = By.xpath("//a[contains(text(),'Зарегистрироваться')]");

    //входные данные для регистрации
    private By inputName = By.xpath("//*[@id='root']/div/main/div/form/fieldset[1]/div/div/input");
    private By inputEmail = By.xpath("//*[@id='root']/div/main/div/form/fieldset[2]/div/div/input");
    private By inputPsswrd = By.xpath("//*[@id='root']/div/main/div/form/fieldset[3]/div/div/input");

    //локатор кнопки Зарегистрироваться
    private By registrationLogin = By.xpath("//button[contains(text(),'Зарегистрироваться')]");

    private By inputError = By.xpath(".//*[@id='root']/div/main/div/form/fieldset[3]/div/p");

    //авторизация с разных форм
    private By inputFromRegistr = By.xpath("//a[contains(text(),'Восстановить пароль')]");

    public By getInputError(){
        return inputError;
    }

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        waitForLoad = new WaitForLoad(driver);
    }


    // метод клика по кнопке Личный кабинет
    private void clickPersonalAccount() {
        driver.findElement(personalAccount).click();
    }

    // метод клика по "Зарегистрироваться"
    private void clickRegistr() {
        driver.findElement(registr).click();
    }

    //метод кликает по кнопке Войти с формы регистрации
    @Step
    public void clickInputFromRegistr() {
        driver.findElement(inputFromRegistr).click();
    }

    //метод заполняет поле ввода Имя, Email, Пароль
    private void setInputsPersonalInfo(String name, String email, String password) {
        driver.findElement(inputName).sendKeys(name);
        driver.findElement(inputEmail).sendKeys(email);
        driver.findElement(inputPsswrd).sendKeys(password);
    }

    //метод кликает по кнопке Зарегистрироваться
    private void clickRegistrationLoginButton() {
        driver.findElement(registrationLogin).click();
    }

    //Объединенный метод Регистрации пользователя
    @Step("User registration")
    public void registrationUser(String name, String email, String password) throws InterruptedException {
        waitForLoad.waitForLoadXpath(personalAccount);
        clickPersonalAccount();
        clickRegistr();
        setInputsPersonalInfo(name, email, password);
        clickRegistrationLoginButton();
        Thread.sleep(1000);
    }

    // метод получения текста элемента
    @Step
    public String getActualText(By by) {
        return driver.findElement(by).getText();
    }

}
