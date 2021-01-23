package shivam.chapter11.simplepojoexample;

import io.restassured.parsing.Parser;

import static io.restassured.RestAssured.given;

public class SimpleTest {
    public static void main(String[] args) {
        Employee emp = given().expect().defaultParser(Parser.JSON)
                .when()
                .get("http://localhost:3000/shivam").as(Employee.class);
//        System.out.println(emp.getFirstName());
//        System.out.println(emp.getAge());
//        System.out.println(emp.getSalary());
//        System.out.println(emp.getGender());
//        System.out.println(emp.getAge());
//        System.out.println(emp.isMarried());

        //print courses
        System.out.println(emp.getCourses().getApi());
        System.out.println(emp.getCourses().getWebAutomation());

    }
}
