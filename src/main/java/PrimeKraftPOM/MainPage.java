package PrimeKraftPOM;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.time.Duration;

import static io.qameta.allure.Allure.step;

public class MainPage extends AbstractPage {
    private SelenideElement annoyingWindowCloseBtn = $(By.cssSelector("div[class*='exit_form'] div.btn_close"));
    private SelenideElement logInBtn = $(By.cssSelector("div.b-header-user__personal a[class*='js-btn-show-auth']"));
    private SelenideElement authWindowLoginField = $(By.cssSelector("div.fancybox-content input[type='text']"));
    private SelenideElement authWindowPasswordField = $(By.cssSelector("div.fancybox-content input[type='password']"));
    private SelenideElement authWindowLoginBtn = $(By.cssSelector("div.fancybox-content div[data-auth-title='Войти']"));



    public void closeAnnoyingWindow(){
        annoyingWindowCloseBtn.shouldBe(Condition.visible, Duration.ofSeconds(15)).click();
    }

    public void clickOnLoginBtn(){
        logInBtn.click();
    }

    public void loggingIn(String username, String password){
        authWindowLoginField.setValue(username);
        authWindowPasswordField.setValue(password);
        authWindowLoginBtn.click();
    }

    public SelenideElement getAuthWindowLoginField() {
        return authWindowLoginField;
    }

    public SelenideElement getAuthWindowPasswordField() {
        return authWindowPasswordField;
    }

    public SelenideElement getAuthWindowLoginBtn() {
        return authWindowLoginBtn;
    }
}
