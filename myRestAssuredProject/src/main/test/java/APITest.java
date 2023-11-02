package main.test.java;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.*;


public class APITest {
    private String baseURI = "https://pay2.foodics.dev/cp_internal";
    private String token = "Lyz22cfYKMetFhKQybx5HAmVimF1i0xO";

    @BeforeClass
    public void setup() {
        // Set the base URI for all requests
        RestAssured.baseURI = baseURI;
    }

    @Test
    public void testValidLogin() {
        // Send a POST request with valid credentials, expecting a 200 status code
        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body("{\"email\":\"merchant@foodics.com\",\"password\":\"123456\"}")
                .post("/login");

        response.then()
                .statusCode(200);
    }

    @Test
    public void testInvalidLogin() {
        // Send a POST request with invalid credentials, expecting a 401 status code
        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body("{\"email\":\"invalid@example.com\",\"password\":\"invalidPassword\"}")
                .post("/login");

        response.then()
                .statusCode(401);
    }

    @Test
    public void testValidWhoAmI() {
        // Send a GET request to /whoami with a valid token, expecting a 200 status code
        Response response = RestAssured
                .given()
                .header("Authorization", "Bearer " + token)
                .get("/whoami");

        response.then()
                .statusCode(200);
    }

    @Test
    public void testUnauthorizedWhoAmI() {
        // Send a GET request to /whoami without proper authorization, expecting a 401 status code
        Response response = RestAssured
                .given()
                .get("/whoami");

        response.then()
                .statusCode(401);
    }

    @Test
    public void testInvalidTokenWhoAmI() {
        // Send a GET request to /whoami with an invalid token, expecting a 401 status code
        Response response = RestAssured
                .given()
                .header("Authorization", "Bearer InvalidToken")
                .get("/whoami");

        response.then()
                .statusCode(401);
    }

    @Test
    public void testValidTokenWithExpiredSessionWhoAmI() {
        // Send a GET request to /whoami with a valid token but simulate an expired session, expecting a 401 status code
        Response response = RestAssured
                .given()
                .header("Authorization", "Bearer " + token)
                .get("/whoami");

        response.then()
                .statusCode(401);
    }

    @Test
    public void testValidTokenWithInvalidEndpoint() {
        // Send a GET request to an invalid endpoint with a valid token, expecting a 404 status code
        Response response = RestAssured
                .given()
                .header("Authorization", "Bearer " + token)
                .get("/invalid-endpoint");

        response.then()
                .statusCode(404);
    }
}
