package tests;

import tests.BaseTest;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.TextBoxPage;
import utils.ScreenshotListener;


@Listeners({ScreenshotListener.class})
public class TextBoxTests extends BaseTest {


    @Test(description = "Positive: submit valid data in Text Box")
    @Description("Заполняем форму Text Box валидными данными и проверяем вывод")
    public void testTextBoxPositive() {
        TextBoxPage p = new TextBoxPage(driver);
        p.open();
        p.enterFullName("Ivan Ivanov");
        p.enterEmail("ivan@example.com");
        p.enterCurrentAddress("Some address");
        p.enterPermanentAddress("Permanent");
        p.submit();
        Assert.assertTrue(p.getOutputName().contains("Ivan Ivanov"));
        Assert.assertTrue(p.getOutputEmail().contains("ivan@example.com"));
    }


    @Test(description = "Negative: submit invalid email")
    public void testTextBoxInvalidEmail() {
        TextBoxPage p = new TextBoxPage(driver);
        p.open();
        p.enterFullName("Ivan Ivanov");
        p.enterEmail("invalid-email");
        p.enterCurrentAddress("Some address");
        p.enterPermanentAddress("Permanent");
        p.submit();
        Assert.assertFalse(p.isEmailValid(), "Ожидалось, что email будет невалидным, но checkValidity() вернул true");
        String validationMsg = p.getEmailValidationMessage();
        Assert.assertTrue(validationMsg != null && validationMsg.length() > 0, "Ожидалось сообщение валидации от браузера");
    }
}
