package maadurga;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.get;
public class RESTAssuredJSONTests {
    final static String ROOT_URI="http://localhost:3000";
   @Test
           public void testAPI(){
    Response response =get(ROOT_URI+"/instructor")
            .then().extract().response();

    String resStr=response.asString();
        System.out.println(resStr);
        JsonPath js = new JsonPath(resStr);
        int size = js.get("employees.size()");
        System.out.println(size);
        System.out.println(js.getString("employees[0].name"));
        System.out.println(js.getString("employees[1].name"));

        List<String> names = new ArrayList<>();
        for(int i=0; i<size; i++)
        {
            names.add(js.getString("employees["+i+"].name"));

        }


        System.out.println(names);
        for(int i=0; i<size; i++)
        {
            Assert.assertEquals(js.getString("employees["+i+"].name"),names.get(i));
        }

    }

    @Test(dataProvider = "getData")
    public void getWithParam(int id, String name){

        Response response =get(ROOT_URI+"/instructor")
                .then().extract().response();

        String resStr=response.asString();
        System.out.println(resStr);
        JsonPath js = new JsonPath(resStr);
        int size = js.get("employees.size()");
        for(int i=0; i<size; i++) {
            if(js.getString("employees[" +i+"].name").equalsIgnoreCase(name))
            {
                System.out.println("Pass");
            }
        }
    }
    @DataProvider
    public Object[][] getData(){
        Object[][] data ={
                { 1, "Pankaj" },
                { 2, "David" }
        };

        return data;
    }

}
