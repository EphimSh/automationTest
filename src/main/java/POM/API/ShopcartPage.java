package POM.API;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

public class ShopcartPage extends AbstractPage {

    public static final SelenideElement SHOP_CART_ITEM_LIST = $(By.xpath("//tbody[@id='basket-item-table']"));
    public static final SelenideElement SHOP_CART_TOTAL_PRICE = $(By.xpath("//div[@class='basket-checkout-total-block-value font-weight-bold']"));

    public static final SelenideElement SHOP_CART_ITEM_AMOUNT_CONTROLS = SHOP_CART_ITEM_LIST.$(By.xpath("tr//td[@class='basket-items-list-item-amount']/div"));
    public static final SelenideElement SUBTRACT_AMOUNT = SHOP_CART_ITEM_AMOUNT_CONTROLS.$(By.xpath("span[@data-entity='basket-item-quantity-minus']"));
    public static final SelenideElement ADD_AMOUNT = SHOP_CART_ITEM_AMOUNT_CONTROLS.$(By.xpath("span[@data-entity='basket-item-quantity-minus']"));
    public static final SelenideElement QUANTITY_OF_AN_ITEM = SHOP_CART_ITEM_AMOUNT_CONTROLS.$(By.xpath("div//input"));


    @Override
    public void submit() {

    }

    @Override
    public By getUserName() {
        return null;
    }
}
