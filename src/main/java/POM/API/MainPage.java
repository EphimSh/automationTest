package POM.API;

import org.openqa.selenium.By;

public class MainPage extends AbstractPage {

    public static final MainPage INSTANCE = new MainPage();
    private static final By LOGIN_BTN_XPATH = By.xpath("//div[@class='b-header-user']//div/a");
    private static final By LOGIN_FIELD_XPATH = By.xpath("//div[@class='fancybox-content']//input[@type='text']");
    private static final By PASSWORD_FIELD_XPATH = By.xpath("//div[@class='fancybox-content']//input[@type='password']");
    private static final By CLOSE_SUBMIT_POP_UP_XPATH = By.xpath("//div[@class='exit_form']/div[@class='btn_close']");
    private static final By AUTHENTICATE_BTN = By.xpath("//div[@class='fancybox-content']//div[@class='cbaup_btn ']");




    public void closePopUP(){
        $(CLOSE_SUBMIT_POP_UP_XPATH).click();
    }

    public void clickOnLogInBtn(){
        $(LOGIN_BTN_XPATH).click();
    }

    public void auth(String username, String password){
        clickOnLogInBtn();
        $(LOGIN_FIELD_XPATH).setValue(username);
        $(PASSWORD_FIELD_XPATH).setValue(password);
        submit();
    }
    @Override
    public void submit() {
        $(AUTHENTICATE_BTN).click();
    }



    @Override
    public void setValue() {
    }

    @Override
    public void clickToAdd() {

    }

    @Override
    public void clickToSubtract() {

    }

    @Override
    public By getUserName() {
        return null;
    }
}
