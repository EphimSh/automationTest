package PrimeKraftPOM;

import com.codeborne.selenide.SelenideElement;

public class CatalogPage extends AbstractPage {

    SelenideElement itemsCatalog = $("div.catalog-section");
    SelenideElement shopCartBtn = $("div[class*='control'] a[href*='personal/cart']");


    public SelenideElement getItemsCatalog() {
        return itemsCatalog;
    }

    public SelenideElement getShopCartBtn() {
        return shopCartBtn;
    }
}
