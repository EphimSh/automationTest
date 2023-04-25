package POM.API;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

public class MainHeader extends AbstractPage{
    //Controls

    public static final SelenideElement HEADER_USER_CONTROLS_XPATH = $(By.xpath("//div[@class='l-head__controls d-flex align-items-center mx-4']"));
    public static final SelenideElement USERPROFILE_ICON_XPATH = HEADER_USER_CONTROLS_XPATH.$(By.xpath("a[@href='/personal/']"));
    public static final SelenideElement USERNAME_ELEMENT_XPATH = HEADER_USER_CONTROLS_XPATH.$(By.xpath("div[@class='b-header-user']/div//a[@href='/personal/']"));
    public static final SelenideElement USER_SHOPCART_XPATH = HEADER_USER_CONTROLS_XPATH.$(By.xpath("a[@href='/personal/cart/']"));
    public static final SelenideElement USER_WISHLIST_XPATH = HEADER_USER_CONTROLS_XPATH.$(By.xpath("a[@href='/personal/wishlist/']"));

    //Menu
    public static final SelenideElement MENU_CATALOG_BUTTON_XPATH = $(By.xpath("//div/a[@href='/catalog/']"));



    @Override
    public void submit() {

    }

    @Override
    public By getUserName() {
        return null;
    }
}
