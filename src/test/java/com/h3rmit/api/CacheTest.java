package com.h3rmit.api;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import org.junit.jupiter.api.Test;

import com.h3rmit.dto.CacheData;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import jakarta.ws.rs.core.MediaType;

@QuarkusTest
public class CacheTest {
    
    @Test
    public void putDataIntoCache() {
        given()
            .contentType(ContentType.JSON)
            .body(new CacheData("123", "test"))
        .when()
            .post("/cache")
        .then()
            .statusCode(200);
    }

    
    @Test
    public void getDataFromCache() {
        when()
        .get("/cache")
        .then()
        .statusCode(200);
    }
    
    @Test
    public void removeDataFromCache() {
        when().delete("/cache/{key}", "value").then().statusCode(200);
    }

    @Test
    public void clearCacheTest() {
        given()
        .contentType(ContentType.JSON)
        .when()
        .post("/cache/clear")
        .then().statusCode(200);
    }
}
