import POM.API.CatalogPage;
import POM.API.MainPage;
import POM.API.ShopcartPage;
import POM.API.UserProfilePage;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.v85.input.Input;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static com.codeborne.selenide.Selenide.open;

public class AbstractTest {

    private static Properties prop = new Properties();
    private static InputStream configFile;
    private static MainPage mainPage = new MainPage();
    private static ShopcartPage shopcartPage = new ShopcartPage();
    private static CatalogPage catalogPage = new CatalogPage();
    private static UserProfilePage userProfilePage = new UserProfilePage();

    private static String username;

    private static String password;

    private static String baseURL;

    @BeforeAll
    static void init() throws IOException {
        configFile = new FileInputStream("src/main/resources/my.properties");
        prop.load(configFile);

        username = prop.getProperty("username");
        password = prop.getProperty("password");
        baseURL = prop.getProperty("baseURL");

        Configuration.browser = "chrome";
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        Configuration.browserCapabilities.setCapability(ChromeOptions.CAPABILITY, options);


        Configuration.reportsFolder = "target/reports/screenshots";

        Configuration.timeout = 15000;
    }

    @BeforeEach
    void goTo(){
        open(getBaseURL());
        getMainPage().closePopUP();
    }


    public static MainPage getMainPage() {
        return mainPage;
    }

    public static UserProfilePage getUserProfilePage() {
        return userProfilePage;
    }

    public static ShopcartPage getShopcartPage() {
        return shopcartPage;
    }

    public static CatalogPage getCatalogPage() {
        return catalogPage;
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
}
