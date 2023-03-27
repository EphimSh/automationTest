import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GET_Posts extends PositiveTest {
    private static String ownerNotMe = "/?owner=notMe";
    private static String orderAll = "&order=ALL";
    private static String x_auth_token = "x-auth-token";
    private static int dataListSize = 0;
    private static int previousId = 0;

    @Test
    void getUserPosts(){
        ResponseTestStand response = given().spec(requestSpecification)
                .header(x_auth_token, getToken())
                .when()
                .get("posts")
                .then()
                .extract().response().body().prettyPeek().as(ResponseTestStand.class);
        assertThat(response, hasProperty("data"));
        assertThat(response, hasProperty("meta"));
        assertThat(response.getMeta().getCount(), greaterThan(0));
    }

    @Test
    void getUserPostsASC(){
        ResponseTestStand response = given().spec(requestSpecification)
                .header(x_auth_token, getToken())
                .when()
                .get("posts"+ "?sort=createdAt&order=ASC&page=1")
                .then()
                .extract().response().body().prettyPeek().as(ResponseTestStand.class);
        dataListSize = response.getData().size();
        for (int i = 0; i < dataListSize - 1; i++) {
            assertThat(response.getData().get(i).getAuthorId(), is(4708));
        }

    }

    @Test
    void getUserPostsASC_notExistedPage(){
        ResponseTestStand response = given().spec(requestSpecification)
                .header(x_auth_token, getToken())
                .when()
                .get("posts"+ "?sort=createdAt&order=ASC&page=10")
                .then()
                .extract().response().body().prettyPeek().as(ResponseTestStand.class);
        assertThat(response.getData(), empty());
    }
    @Test
    void getNumberUserPostsASC(){
        ResponseTestStand response = given().spec(requestSpecification)
                .header(x_auth_token, getToken())
                .when()
                .get("posts"+ "?sort=createdAt&order=ASC&page=2")
                .then()
                .extract().response().body().prettyPeek().as(ResponseTestStand.class);
        assertThat(response.getMeta().getCount(), greaterThan(0));
    }

    @Test
    void getImageUserPostsASC(){
        ResponseTestStand response = given().spec(requestSpecification)
                .header(x_auth_token, getToken())
                .when()
                .get("posts"+ "?sort=createdAt&order=ASC&page=2")
                .then()
                .extract().response().body().prettyPeek().as(ResponseTestStand.class);
        assertTrue(response.getData().get(0).getMainImage().getCdnUrl().endsWith(".jpg"), "It's not a .jpg file");



    }





    @Test
    void getOtherUsersPosts(){
        ResponseTestStand response = given().spec(requestSpecification)
                .header(x_auth_token, getToken())
                .when()
                .get("posts"+ ownerNotMe)
                .then()
                .extract().response().body().prettyPeek().as(ResponseTestStand.class);
        assertThat(response.getMeta().getCount(), greaterThan(1000));
    }



    @Test
    void getAllOtherUserPostsIsUnavailable(){
        ResponseTestStand response = given().spec(requestSpecification)
                .header(x_auth_token, getToken())
                .when()
                .get("posts" + ownerNotMe + orderAll)
                .then()
                .extract().response().body().prettyPeek().as(ResponseTestStand.class);
        assertThat(response.getErrorType(), is("critical"));

        Response httpResponse = given().spec(requestSpecification)
                .header("x-auth-token", getToken())
                .when()
                .get("posts" + ownerNotMe + orderAll);
        assertThat(httpResponse.getStatusCode(), is(500));
    }

    @Test
    void getAllOtherUserPostsIsAvailable(){

        Response httpResponse = given().spec(requestSpecification)
                .header("x-auth-token", getToken())
                .when()
                .get("posts" + ownerNotMe + orderAll);
        assertThat(httpResponse.getStatusCode(), is(200));
    }

    @Test
    void getOtherUserPostsASC(){
        ResponseTestStand response = given().spec(requestSpecification)
                .header(x_auth_token, getToken())
                .when()
                .get("posts" + ownerNotMe + "&sort=createdAt&order=ASC")
                .then()
                .extract().response().body().prettyPeek().as(ResponseTestStand.class);
        dataListSize = response.getData().size();

        for(int i = 0; i < dataListSize - 1; i++){
            previousId = response.getData().get(i).getId();
            assertThat(previousId, lessThan(response.getData().get(i + 1).getId()));
        }
    }

    @Test
    void getOtherUserPostsDESC(){
        ResponseTestStand response = given().spec(requestSpecification)
                .header(x_auth_token, getToken())
                .when()
                .get("posts" + ownerNotMe + "&sort=createdAt&order=DESC")
                .then()
                .extract().response().body().prettyPeek().as(ResponseTestStand.class);
        int dataListSize = response.getData().size();
        int previousId = 0;
        for(int i = 0; i < dataListSize - 1; i++){
            previousId = response.getData().get(i).getId();
            assertThat(previousId, greaterThan(response.getData().get(i + 1).getId()));
        }
    }

    @Test
    void getOtherUserPostsDESCAtPage_10(){
        ResponseTestStand response = given().spec(requestSpecification)
                .header(x_auth_token, getToken())
                .when()
                .get("posts" + ownerNotMe + "&sort=createdAt&order=DESC&page=10")
                .then()
                .extract().response().body().prettyPeek().as(ResponseTestStand.class);
        int dataListSize = response.getData().size();
        int previousId = 0;
        for(int i = 0; i < dataListSize - 1; i++){
            previousId = response.getData().get(i).getId();
            assertThat(previousId, greaterThan(response.getData().get(i + 1).getId()));
        }
    }

    @Test
    void getNotExistingPageSoFar(){
        ResponseTestStand response = given().spec(requestSpecification)
                .header(x_auth_token, getToken())
                .when()
                .get("posts" + ownerNotMe + "&page=1000000")
                .then()
                .extract().response().body().prettyPeek().as(ResponseTestStand.class);
        assertThat(response.getData(), empty());
    }

}
