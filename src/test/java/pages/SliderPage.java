package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class SliderPage extends BasePage {
    private final By slider = By.cssSelector("input[type='range']");
    private final By sliderValue = By.id("sliderValue");


    public SliderPage(WebDriver driver) {
        super(driver);
    }


    public void open() {
        driver.get("https://demoqa.com/slider");
    }


    public void moveSliderTo(int target) {
// target: 0..100
        wait.until(ExpectedConditions.visibilityOfElementLocated(slider));
        Actions actions = new Actions(driver);
// Move by offset - calculation is approximate; test asserts value after action
        int width = driver.findElement(slider).getSize().getWidth();
        int xOffset = (int) ((target - Integer.parseInt(driver.findElement(sliderValue).getAttribute("value"))) * (width / 100.0));
        actions.clickAndHold(driver.findElement(slider)).moveByOffset(xOffset, 0).release().perform();
    }


    public int getSliderValue() {
        return Integer.parseInt(driver.findElement(sliderValue).getAttribute("value"));
    }
}
