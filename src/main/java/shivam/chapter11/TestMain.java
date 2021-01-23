package shivam.chapter11;
import shivam.chapter11.demo.GetCourses;

import static io.restassured.RestAssured.given;

public class TestMain {


    public static void main(String[] args) {
        GetCourses gc

      =   given()
                .when()
                 .get("http://localhost:3000/shivamacademy").as(GetCourses.class);

    }
}
