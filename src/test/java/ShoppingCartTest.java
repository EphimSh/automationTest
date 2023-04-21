import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.codeborne.selenide.Selenide.$;

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
        $(getUserProfilePage().getCatalogueBtn()).click();
    }


}
