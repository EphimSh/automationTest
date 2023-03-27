
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import static io.restassured.RestAssured.given;


public class PositiveTest extends AbstractTest {

    private static String token;
    private static String username;
    private static String password;
    private static InputStream configFile;
    private static String baseURL;
    protected static RequestSpecification requestSpecification;
    protected static ResponseSpecification responseSpecification;


    @BeforeAll
    static void initPosTest() throws IOException {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        configFile = new FileInputStream("src/main/resources/my.properties");
        getProp().load(configFile);

        baseURL = getProp().getProperty("baseURL");

        username = getProp().getProperty("username");
        password = getProp().getProperty("password");

        String requestBody = "{\n" +
                "    \"username\" : \"" + username + "\",\n" +
                "    \"password\" : \"" + password + "\"\n" +
                "}";

        requestSpecification = new RequestSpecBuilder()
                .setBaseUri(getBaseURL())
                .setContentType("application/json")
                .setBody(requestBody)
                .build();

        responseSpecification = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectStatusLine("HTTP/1.1 200 OK")
                .expectContentType(ContentType.JSON)
                .expectResponseTime(Matchers.lessThan(5000L))
                .build();

        AccountDataResponse response = given().spec(requestSpecification)
                .when()
                .post("login")
                .then()
                .extract().response().body().prettyPeek().as(AccountDataResponse.class);

        token = response.getToken();

        ResponseTestStand responseTestStand = given().spec(requestSpecification)
                .header("x-auth-token", getToken())
                .when()
                .get("posts")
                .then()
                .extract().response().body().prettyPeek().as(ResponseTestStand.class);



    }



    public static String getToken(){
        return token;
    }

    public static String getUsername() {
        return username;
    }

    public static String getPassword() {
        return password;
    }
}
