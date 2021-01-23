package shivam.chapter11.elements;

import io.restassured.parsing.Parser;


import static io.restassured.RestAssured.given;

public class PojoTest {
    public static void main(String[] args) {
     GetShivamInfo gi=   given().header("Content-Type","application/json").expect().defaultParser(Parser.JSON)
                .when()
                .get("http://localhost:3000/shivaminfo").as(GetShivamInfo.class);
    }
}
