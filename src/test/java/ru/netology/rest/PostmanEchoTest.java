package ru.netology.rest;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

class PostmanEchoTest {

    @Test
    void shouldPost() {
        // Given - When - Then
        given()
                .baseUri("https://postman-echo.com")
                .contentType("text/plain; charset=UTF-8")
                .body("Looking for awesome QA? Их есть у нас!") // отправляемые данные (заголовки и query можно выставлять аналогично)
// Выполняемые действия
                .when()
                .post("/post")
// Проверки
                .then()
                .statusCode(200)
                .header("content-type", equalTo("application/json; charset=utf-8"))
                .body("data", equalTo("Looking for awesome QA? Их есть у нас!"))
        ;
    }
}
