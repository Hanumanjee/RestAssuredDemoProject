package maadurga;

import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.get;
import static org.hamcrest.Matchers.hasItems;

public class JournaldevTest {
    final static String ROOT_URI="http://localhost:3000/employees";
    @Test
    public void getTest(){
        Response response = get(ROOT_URI + "/");
        System.out.println(response.asString());

        response.then().body("id", hasItems(1, 2));
        response.then().body("name", hasItems("Pankaj"));

    }

    @Test(dataProvider = "getData")
    public void getWithParam(int id, String name){
     get(ROOT_URI)
             .then().body("name", Matchers.is("Pankaj"));
        System.out.println(name);
    }
    @DataProvider
    public Object[][] getData(){
        Object[][] data ={
         { 1, "Pankaj" },
                { 2, "David" }
        };

        return data;
    }
//    @Test(dataProvider = "getData")
//    public void test( Integer id,String name){
//
//        System.out.println(id);
//        System.out.println(name);
//    }


}
