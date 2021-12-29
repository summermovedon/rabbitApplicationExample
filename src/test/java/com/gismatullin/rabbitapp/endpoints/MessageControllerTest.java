package com.gismatullin.rabbitapp.endpoints;

import static org.hamcrest.Matchers.equalTo;

import com.gismatullin.rabbitapp.dataproviders.TestStringsProvider;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.springframework.core.annotation.Order;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;

public class MessageControllerTest {

    @ParameterizedTest
    @ArgumentsSource(TestStringsProvider.class)
    @Order(1)
    void testSendingMessages(String testMessage) {
        RestAssured.given()
            .contentType(ContentType.JSON)
            .queryParam("message", testMessage)
            .when()
            .get("/send")
            .then()
            .assertThat().statusCode(equalTo(200));
    }

    @ParameterizedTest
    @ArgumentsSource(TestStringsProvider.class)
    @Order(2)
    void testReceivingMessages(String testMessage) {
        ResponseSpecification responseSpec = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .expectBody(equalTo(testMessage))
            .build();
        RestAssured.given()
            .contentType(ContentType.JSON)
            .when()
            .get("/read")
            .then()
            .spec(responseSpec);
    }

}
