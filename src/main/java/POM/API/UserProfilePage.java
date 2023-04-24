package POM.API;

import org.openqa.selenium.By;

public class UserProfilePage extends AbstractPage {

    private static final By USERNAME_ELEMENT_XPATH = By.xpath("//div[@class='b-header-user']/div//a");
    private static final By EXIT_BUTTON_XPATH = By.xpath("//div[@class='l-main__inner-content']//div/a[@href='/?logout=yes']");


    public void logOut() {
        $(EXIT_BUTTON_XPATH).click();
    }

    public void goToPersonalSectionControl() {
        $(USERNAME_ELEMENT_XPATH).click();
    }

    @Override
    public By getUserName() {
        return USERNAME_ELEMENT_XPATH;
    }

    @Override
    public void submit() {
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
}
