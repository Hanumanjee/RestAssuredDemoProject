package shivam.cookiesbased;

import io.restassured.path.json.JsonPath;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreateSessionCookies {
    @Test

    public void createJessionID(){
        JSONObject json = new JSONObject();
        json.put("username", "BASUDEVA");
        json.put("password","ShivamHanumanjee");

        String response=  given()
                .header("content-type", "application/json")
                .body("{ \"username\": \"BASUDEVA\", \"password\": \"ShivamHanumanjee\" }")
                .when().post("http://localhost:8086/rest/auth/1/session ")
                .then().log().all()
                .extract().asString();

        System.out.println(response);


        // parse json boby using JsonPath
        JsonPath js = new JsonPath(response); // for parsing json
//        String placeId = js.getString("place_id");
//        System.out.println("Place Id is: " + placeId);


        //JsonPath js=new JsonPath(response);
       // System.out.println(js.getString());

//        System.out.println(resp.getStatusCode());
//        System.out.println(resp.getBody().jsonPath().prettify());
//        System.out.println(resp.getCookies());


    }
}
