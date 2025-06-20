import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostmanEchoTest {

    @Test
    public void testPostRequest() {
        String requestBody = "some data";

        given()
                .baseUri("https://postman-echo.com")
                .body(requestBody)
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("data", equalTo(requestBody));
    }

    @Test
    public void testPostRequestFail() {
        // Этот тест специально упадёт для демонстрации CI
        String requestBody = "some data";

        given()
                .baseUri("https://postman-echo.com")
                .body(requestBody)
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("data", equalTo("wrong data"))); // Неправильное ожидание
    }
}