import PrimeKraftPOM.MainPage;
import PrimeKraftPOM.UserProfilePage;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.commands.WaitUntil;
import io.qameta.allure.Description;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AbstractTest {
    private static Properties prop = new Properties();
    private static InputStream config;

    private static String username;
    private static String password;
    private static String baseURL;

    private MainPage mainPage = new MainPage();
    private UserProfilePage userProfilePage = new UserProfilePage();

    @BeforeAll
    @Description("this one runs to set configs for webDriver and get the credentials")
    public static void setWebDriverAndGetTheCredentials() throws IOException {
        //Set webDriver configs
        Configuration.browser = "chrome";
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");
        Configuration.browserCapabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        Configuration.holdBrowserOpen = true;
        //Load properties
        config = new FileInputStream("src/main/resources/my.properties");
        prop.load(config);
        //Set credentials and baseURL
        username = prop.getProperty("username");
        password = prop.getProperty("password");
        baseURL = prop.getProperty("baseURL");
    }

    @BeforeEach
    void goTo(){
        open(getBaseURL());
        getMainPage().closeAnnoyingWindow();
        assertTrue(true);
    }



    public static String getUsername() {
        return username;
    }

    public static String getPassword() {
        return password;
    }

    public static String getBaseURL() {
        return baseURL;
    }

    public MainPage getMainPage() {
        return mainPage;
    }

    public UserProfilePage getUserProfilePage() {
        return userProfilePage;
    }
}
