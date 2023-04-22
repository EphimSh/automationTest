package PrimeKraftPOM;


import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;



public class UserProfilePage extends AbstractPage {
    private SelenideElement username = $(By.cssSelector("div.l-head__head a.text-primary"));
    private SelenideElement catalogueBtn = $(By.cssSelector("a[href*='catalog']"));
    private SelenideElement shopCartBtn = $(By.cssSelector("div.l-section__container ul.b-sidebar-nav a[href*='personal/cart']"));


    void clickOnUserProfile(){

    };

    public SelenideElement getUsername() {
        return username;
    }

    public SelenideElement getCatalogueBtn() {
        return catalogueBtn;
    }

    public SelenideElement getShopCartBtn() {
        return shopCartBtn;
    }
}
