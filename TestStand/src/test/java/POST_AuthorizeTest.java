import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;


import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class POST_AuthorizeTest extends AbstractTest {

    private static ObjectMapper mapper = new ObjectMapper(new YAMLFactory());

    private static Stream<HashMap<String, Object>> credentials() throws IOException {
        List<Map<String, String>> credentialList = mapper
                .readValue(new File(getFilePath()), new TypeReference<>() {
                });
        return credentialList.stream().map(HashMap::new);
    }


    @ParameterizedTest
    @MethodSource("credentials")
    void getLoginTest(HashMap<String, Object> credential) {


        AccountDataResponse response = given().contentType("application/json")
                .body(credential)
                .when()
                .post(getBaseURL() + "login")
                .then()
                .extract().response().body().prettyPeek().as(AccountDataResponse.class);

        assertThat(response, hasProperty("token"));
        assertThat(credential.get("shouldSuccess"), is("true"));
    }
}
