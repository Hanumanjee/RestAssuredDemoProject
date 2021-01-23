package maadurga;
/*
1. Print No of courses returned by API
2.Print Purchase Amount
3. Print Title of the first course
4. Print All course titles and their respective Prices
5. Print no of copies sold by RPA Course
6. Verify if Sum of all Course prices matches with Purchase Amount
Fullscreen
Expand
25. Understanding Structure of Complex Nested Json…
27. Retrieving the Json Array Size and its element…

* */

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Video25ComplexNestedJson {
int sum=0;
    @Test
    public void getCoursePayload() {
        RestAssured.baseURI = "http://localhost:3000";
        Response response = given().contentType(ContentType.JSON)
                .when()
                .get("/courses")
                .then().assertThat().statusCode(200).extract().response();

        String resStr = response.asString();
        //  System.out.println(resStr);
        JsonPath js = new JsonPath(resStr);

        //  System.out.println(js.getString("courses[0].title"));
        //1. Print No of courses returned by API
        int numCourse = js.getInt("courses.size()");
        System.out.println("1. Print No of courses returned by API: " + numCourse);

        //3. Print Title of the first course
        System.out.println("3. Print Title of the first course: " + js.getString("[0].title"));

        //4. Print All course titles and their respective Prices
        for (int i = 0; i < numCourse; i++) {
            System.out.println("Course Title: " + js.getString("[" + i + "].title") +
                    " and Price is: " + js.getString("[" + i + "].price"));

            //5. Print no of copies sold by RPA Course
            if (js.getString("[" + i + "].title").equalsIgnoreCase("RPA")) {
                System.out.println("RPA copies sold: " + js.getString("[" + i + "].copies"));
            }
        }
        //6. Verify if Sum of all Course prices matches with Purchase Amount

        for(int i =0; i<numCourse; i++)
        {
            sum +=js.getInt("["+i+"].price") * js.getInt("["+i+"].copies");
        }
        System.out.println("Total sum: " + sum);


    }

    @Test
    public void getDashboardPayload() {
        RestAssured.baseURI = "http://localhost:3000";
        Response response = given().contentType(ContentType.JSON)
                .when()
                .get("/dashboard")
                .then().assertThat().statusCode(200).extract().response();

        String resStr = response.asString();
        //    System.out.println(resStr);
        JsonPath js = new JsonPath(resStr);


        System.out.println("2.Print Purchase Amount: " + js.get("purchaseAmount"));
       // 6. Verify if Sum of all Course prices matches with Purchase Amount
        Assert.assertEquals(sum, js.get("purchaseAmount"));
    }
}
