
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;


public class ShopcartTest extends AbstractTest {
    private static final String SCREENSHOT_NAME = "shopcart_page";
    private static final By MENU_CATALOG_BUTTON_XPATH = By.xpath("//div/a[@href='/catalog/']");
    private static final By BASKET_TOTAL_PRICE_XPATH = By.xpath("//div/div[@data-entity='basket-total-price']");
    private static final By REMOVE_ITEM_BUTTON_XPATH = By.xpath("//td/div[@class='basket-item-block-actions']");
    private static final By FIRST_IN_ROW_ITEM_ADD_BUTTON_XPATH = By.xpath("//div[@class='catalog-section']/div//div[@class='product-cat-button-container']");

    private static final By AMOUNT_OF_ITEM_PLUS_BUTTON_XPATH = By.xpath("//div[@class='basket-item-block-amount']//span[@class='basket-item-amount-btn-plus']");

    private static final By BASKET_EMPTY_TITLE_XPATH = By.xpath("//h2[@class='basket-empty__title']");


    @BeforeEach
    void logInAndGoToItemsCatalog() {
        getMainPage().auth(getUsername(), getPassword());
        $(MENU_CATALOG_BUTTON_XPATH).click();
    }


    @Test
    void addItemsAndGoToShopCartThenRemove() {

        for (int i = 1; i <= 3; i++) {
            String cssSelector = String.format("div.catalog-section > :nth-child(1) > :nth-child(%d) > div a.btn", i);
            $(cssSelector).click();
        }
        open("https://primekraft.ru/personal/cart/");
        Selenide.executeJavaScript("window.scrollBy(0, 300)");


        Selenide.screenshot(SCREENSHOT_NAME + "_items_added");

        for (int i = 1; i <= 3; i++) {
            String cssSelector = String.format("tbody[id='basket-item-table'] > :nth-child(%d) > td > div[class='basket-item-block-actions']", i);
            $(cssSelector).shouldBe(Condition.interactable).click();
        }

        $(BASKET_TOTAL_PRICE_XPATH).shouldBe(Condition.text("0 руб."));
        Selenide.screenshot(SCREENSHOT_NAME + "_items_removed");
    }

    @Test
    void addItemGoToShopCartThenIncreaseAmountOfItem() {
        $(FIRST_IN_ROW_ITEM_ADD_BUTTON_XPATH).click();
        open("https://primekraft.ru/personal/cart/");

        $(AMOUNT_OF_ITEM_PLUS_BUTTON_XPATH).click();
        $(BASKET_TOTAL_PRICE_XPATH).shouldBe(Condition.visible);
        Selenide.screenshot(SCREENSHOT_NAME + "_item_plus_button_works");
    }
}
