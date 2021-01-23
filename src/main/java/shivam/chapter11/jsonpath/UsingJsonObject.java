package shivam.chapter11.jsonpath;

import io.restassured.RestAssured;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Iterator;

import static io.restassured.RestAssured.given;

public class UsingJsonObject {
    public static void parseObject(JSONObject json, String key){
        System.out.println(json.get(key));
    }

    public static void getKey(JSONObject json, String key){
        boolean exists = json.has(key);

        Iterator<?> it;
        String nextKeys;

        if(!exists)
        {
            it=json.keys();
            while(it.hasNext())
            {
                nextKeys =(String) it.next();
                try{
                    if(json.get(nextKeys) instanceof JSONObject)
                    {

                            if(exists==false)
                            {
                                getKey(json.getJSONObject(nextKeys),key);
                            }

                    }
                    else if(json.get(nextKeys) instanceof JSONArray)
                    {
                        JSONArray jsonArray = json.getJSONArray(nextKeys);
                        for(int i=0; i<jsonArray.length(); i++)
                        {
                       String jsonArrayString=     jsonArray.get(i).toString();
                        }
                    }

                }catch (Exception e)
                {

                }
            }
        }else{

        }

    }
    public static void main(String[] args) {

        RestAssured.baseURI="http://localhost:3000";

        String response =   given()
                .when().get("/shivaminfo")
                .then().log().all().assertThat().statusCode(200).extract().response().asString();
        System.out.println(response);

        //using JsonObject
        JSONObject object = new JSONObject(response);


    }

}
