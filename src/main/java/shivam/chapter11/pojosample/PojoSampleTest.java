package shivam.chapter11.pojosample;

import io.restassured.parsing.Parser;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

public class PojoSampleTest {
    public static void main(String[] args) {

        GetSample gs = given().expect().defaultParser(Parser.JSON)
                .when()
                .get("http://localhost:3000/shivamacademy").as(GetSample.class);



        //1) Get all values from coolcolors
        int colorsSize = gs.getSample().getCoolcolors().size();
        System.out.println(colorsSize);
        for(int i=0; i<colorsSize; i++)
        {
            System.out.println("Color is: " + gs.getSample().getCoolcolors().get(i).getColor());
            System.out.println("Hex is: " + gs.getSample().getCoolcolors().get(i).getHex());

        }
        //2) get hex where color is blue
        System.out.println("---get hex where color is blue---");
        String hex="";
        for(int i=0; i<colorsSize; i++)
        {
            if(gs.getSample().getCoolcolors().get(i).getColor().equalsIgnoreCase("blue"))
            {
                hex =gs.getSample().getCoolcolors().get(i).getHex();
                break;
            }

        }
        Assert.assertEquals(hex,"0000ff");
    }
}