package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;


public class Waits {
    private WebDriverWait wait;


    public Waits(WebDriver driver, int seconds) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
    }


    public WebElement forClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}
