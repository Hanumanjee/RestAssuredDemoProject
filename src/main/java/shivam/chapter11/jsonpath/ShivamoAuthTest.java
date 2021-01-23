package shivam.chapter11.jsonpath;

import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;

public class ShivamoAuthTest {
    public static void main(String[] args) {


       String response = given()
                .when()
                .get("http://localhost:3000/shivaminfo")
                .then().assertThat().statusCode(200).extract().response().asString();
       // System.out.println(response);


        //persing using jsonpath
        System.out.println("----------Test Result------------");
        JsonPath js = new JsonPath(response);
        System.out.println("Instructor name is: " + js.getString("instructor"));
        System.out.println("linkedin is: " + js.getString("linkedIn"));
        System.out.println("Course name is: " + js.getString("courses[0].webAutomation[0].courseTitle"));
        System.out.println("Mobile course price is: " + js.getString("courses[2].mobile[0].price"));

        System.out.println("-------For Loop -------");

        int courseSize = js.getInt("courses.size()");
        System.out.println(courseSize);

        //find the price of crouseTile SoapUI Webservices testing

        for(int i=0; i<courseSize; i++)
        {
            System.out.println(js.get("courses["+i+"]"));

        }


    }
}
