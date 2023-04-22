
import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;



public class AuthenticationTest extends AbstractTest {



    @Test
    void validCredentialsLogIn(){
        step("Click on login button", ()->{
            getMainPage().clickOnLoginBtn();
        });
        step("logging in with valid credentials", ()->{
            getMainPage().loggingIn(getUsername(),getPassword());
        });

        step("ensure that user is dummy", ()->{
            $(getUserProfilePage().getUsername()).shouldHave(Condition.text("dummy1"));
        });
    }


}
