
import static POM.API.MainHeader.*;
import static POM.API.CatalogPage.*;
import static POM.API.ShopcartPage.*;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;


import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;


public class ShopcartTest extends AbstractTest {
    @BeforeEach
    void logInAndGoToItemsCatalog() {
        getMainPage().auth(getUsername(), getPassword());
        $(MENU_CATALOG_BUTTON_XPATH).click();
    }

    @AfterEach
    void deleteItemsFromShopCart(){
        $(SHOP_CART_ITEM_LIST).$(By.xpath("tr//div[@class='basket-item-block-actions']")).click();
        $(SHOP_CART_TOTAL_PRICE).shouldBe(Condition.text("0 руб."));
    }

    @Test
    void addItemToShopCart(){
        $(ADD_TO_SHOP_CART_BUTTON).click();
        $(USER_SHOPCART_XPATH).click();
        $(SHOP_CART_ITEM_LIST).$(By.xpath("tr")).shouldBe(Condition.visible);
    }

    @Test
    void addItemThenAddMoreUsingItemControl(){
        $(ADD_TO_SHOP_CART_BUTTON).click();
        $(USER_SHOPCART_XPATH).click();
        String cssSelector = "td.basket-items-list-item-amount > div > span.basket-item-amount-btn-plus";
        sleep(1500);
        Selenide.executeJavaScript("document.querySelector('" + cssSelector + "').click()");
        sleep(1500);
        $(ADD_AMOUNT).shouldBe(Condition.visible);
    }

}
