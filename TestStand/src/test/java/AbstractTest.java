import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.BeforeAll;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class AbstractTest {
    static Properties prop = new Properties();
    private static InputStream configfile;
    private static String baseURL;
    private static String filePath = "src/main/resources/login_test_data.yml";




    @BeforeAll
    static void initTest() throws IOException {
        configfile = new FileInputStream("src/main/resources/my.properties");
        prop.load(configfile);
        baseURL = prop.getProperty("baseURL");
    }


    public static String getBaseURL() {
        return baseURL;
    }

    public static String getFilePath() {
        return filePath;
    }

    public static Properties getProp(){
        return prop;
    }
}
