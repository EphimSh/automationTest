package POM.API;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

public class CatalogPage extends AbstractPage{

    public static final SelenideElement ADD_TO_SHOP_CART_BUTTON = $(By.xpath("//div[@class='catalog-section']//div[@class='product-cat-button-container']"));

    @Override
    public void submit() {

    }
    @Override
    public By getUserName() {
        return null;
    }

}
