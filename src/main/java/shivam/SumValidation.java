package shivam;

import files.Payload;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SumValidation {
    @Test
    public void sumOfCourses(){
        JsonPath js = new JsonPath(Payload.CoursePrice());
        int count =  js.getInt("courses.size()");


        int purchaseAmount = js.getInt("dashboard.purchaseAmount");
        int courseSum=0;

        for(int i=0; i<count; i++)
        {
            int price = js.getInt("courses["+i+"].price") * js.getInt("courses["+i+"].copies");
            courseSum +=price;

        }
       // System.out.println(courseSum);
        Assert.assertEquals(purchaseAmount, courseSum);
    }
}
