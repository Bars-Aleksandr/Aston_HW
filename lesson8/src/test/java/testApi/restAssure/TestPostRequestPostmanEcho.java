package testApi.restAssure;

import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TestPostRequestPostmanEcho {
    @Test
    @DisplayName("Тестирование POST запроса-зеркала на Postman echo")
    void checkResponseBodyPostRequestMirrorText(){
        given().log().body()
                .baseUri("https://postman-echo.com")
                .body("Hello world")
                .when().post("/post")
                .then().log().body()
                .body("data", equalTo("Hello world"));
    }
    @Test
    @DisplayName("Тестирование POST запроса на Postman echo через Form Data")
    void checkResponseBodyPostRequestFormParam(){
        given().log().body().contentType("application/json")
                .baseUri("https://postman-echo.com")
                .contentType("application/x-www-form-urlencoded; charset=utf-8")
                .formParams("foo1", "bar1", "foo2", "bar2")
                .when().post("/post")
                .then().log().body()
                .body("json.foo1", equalTo("bar1"))
                .body("json.foo2", equalTo("bar2"));
    }



}
