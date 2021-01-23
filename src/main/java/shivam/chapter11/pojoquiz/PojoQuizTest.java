package shivam.chapter11.pojoquiz;

import io.restassured.parsing.Parser;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;

public class PojoQuizTest {

    @Test
    public void test() {
        Integer[] mathQ1OptArr = {10, 11, 12, 13};
        GetQuiz gq = given().expect().defaultParser(Parser.JSON)
                .when()
                .get("http://localhost:3000/shivamacademy").as(GetQuiz.class);

        // get Math Q1 question and answer
        System.out.println(gq.getQuiz().getMaths().getQ1().getQuestion());
        System.out.println(gq.getQuiz().getMaths().getQ1().getAnswer());

        //verify Math Q1 options values
        List<Integer> mathQ1OptList = new ArrayList<>();
        int mathQ1OptSize = gq.getQuiz().getMaths().getQ1().getOptions().size();
        System.out.println(mathQ1OptSize);
        for (int i = 0; i < mathQ1OptSize; i++) {
            mathQ1OptList.add(gq.getQuiz().getMaths().getQ1().getOptions().get(i));
        }
        System.out.println("---------Math Q1 Options List Value---------------");
        System.out.println(mathQ1OptList);
        List<Integer> expectedMathsQ1Opt = Arrays.asList(mathQ1OptArr);
        Assert.assertEquals(mathQ1OptList, expectedMathsQ1Opt);
    }

}
