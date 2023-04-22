import PrimeKraftPOM.CatalogPage;
import com.codeborne.selenide.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;

public class ShoppingCartTest extends AbstractTest {

    @BeforeEach
    void logIn() {
        getMainPage().clickOnLoginBtn();
        getMainPage().loggingIn(getUsername(), getPassword());
        Selenide.Wait().until(ExpectedConditions.urlContains("private"));
        getUserProfilePage().getCatalogueBtn().should(Condition.visible);
    }

    @Test
    void goToShopCart() {
        step("if shop cart is working ", () -> {
            $(getUserProfilePage().getShopCartBtn()).click();
        });

    }

    @Test
    void addItemsToTheShopCart() throws InterruptedException {
        step("go to the catalog", () ->{
            $(getUserProfilePage().getCatalogueBtn()).click();
        });
        step("select three items", () ->{
            $(getCatalogPage().getItemsCatalog()).shouldBe(Condition.visible);

            for (int i = 1; i <= 3; i++) {
                String cssSelector = String.format("div.catalog-section > :nth-child(1) > :nth-child(%d) > div a.btn", i);
                $(cssSelector).click();

            }
        });
        step("ensure that those items are in the shopcart", () ->{
            $(getCatalogPage().getShopCartBtn()).click();

        });
    }
}
