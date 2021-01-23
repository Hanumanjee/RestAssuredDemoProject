package shivam.practice;

import files.Payload;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RelationAPITest {
    @Test
    public void test() {
//        RestAssured.baseURI = "http://localhost:3000";
//        Response response = given().contentType(ContentType.JSON)
//                .when()
//                .get("/relation")
//                .then().log().all().assertThat().statusCode(200).extract().response();
//        String resStr = response.asString();
        JsonPath js = new JsonPath(Payload.relationPayload());


        //varify school friend chandana
        System.out.println(js.getString("relation.friends.test1[1].schoolfriend"));
        //verify is name sutapa is there or not
        int test1Size = js.get("relation.friends.test1.size()");
        System.out.println(test1Size);
        for(int i=0; i<test1Size; i++){
            String name = js.getString("relation.friends.test1["+i+"].schoolfriend");
            //System.out.println(name);
           if(name.equalsIgnoreCase("sutapa"))
           {
               Assert.assertTrue(name.equalsIgnoreCase("sutapa"));
           }
        }
    }
}
