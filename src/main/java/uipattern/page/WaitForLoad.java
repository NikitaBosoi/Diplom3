package uipattern.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForLoad {

    static WebDriver driver;

    WaitForLoad(WebDriver driver) {
        this.driver = driver;
    }

    static void waitForLoadXpath(By xpath) {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(xpath));
    }


}