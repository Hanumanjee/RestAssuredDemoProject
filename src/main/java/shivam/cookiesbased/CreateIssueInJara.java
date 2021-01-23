package shivam.cookiesbased;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class CreateIssueInJara {

    @Test

    public void createJessionID(){
//        JSONObject json = new JSONObject();
//        json.put("username", "BASUDEVA");
//        json.put("password","ShivamHanumanjee");

      String resp=  RestAssured.given().log().all()
                .header("content-type", "application/json")
                .body("{ \"username\": \"BASUDEVA\", \"password\": \"ShivamHanumanjee\" }")
                .when().post("http://localhost:8086/rest/auth/1/session ")
              .then().log().all().extract().asString();

//        System.out.println(resp.getStatusCode());
//        System.out.println(resp.getBody().jsonPath().prettify());
//        System.out.println(resp.getCookies());


    }
    @Test
    public void test()
    {
        System.out.println("Testing TestNG");
    }
}
