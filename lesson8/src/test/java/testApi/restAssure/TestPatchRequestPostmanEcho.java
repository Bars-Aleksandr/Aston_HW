package testApi.restAssure;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TestPatchRequestPostmanEcho {
    @Test
    @DisplayName("Тестирование PATCH запроса-зеркала на Postman echo")
    void checkResponseBodyPATCHRequestMirrorText(){
        given()
                .log().body()
                .baseUri("https://postman-echo.com")
                .contentType("application/json; charset=utf-8")
                .body("Hello world")
                .when().patch("/patch")
                .then().log().body()
                .body("data", equalTo("Hello world"));
    }
}
