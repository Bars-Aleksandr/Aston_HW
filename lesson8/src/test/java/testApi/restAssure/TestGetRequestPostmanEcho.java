package testApi.restAssure;

import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.equalTo;

import static io.restassured.RestAssured.given;

public class TestGetRequestPostmanEcho {
    @Test
    @DisplayName("Тестирование StatusCode и Body")
    void checkStatusOKAndResponseBodyGetRequest(){
        given()
                .baseUri("https://postman-echo.com")
                .param("foo1", "bar1")
                .param("foo2", "bar2")
                .when().get("/get")
                .then().log().body()
                .statusCode(HttpStatus.SC_OK)
                .and()
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"))
                .contentType("application/json");
    }


}
