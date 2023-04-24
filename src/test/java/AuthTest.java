import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;

public class AuthTest extends AbstractTest{

    private static final String SCREENSHOT_NAME = "user_profile_page";

    @Test
    public void validAuth(){
        getMainPage().auth(getUsername(),getPassword());
        $(getUserProfilePage().getUserName()).shouldBe(Condition.text("dummy"));
        Selenide.screenshot(SCREENSHOT_NAME);
    }
}
