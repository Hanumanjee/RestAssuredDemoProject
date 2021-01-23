package maadurga;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataprovideTest {

    @DataProvider
    public Object[][] getData(){
        Object[][] data ={{"Shivam", 1}};

        return data;
    }
    @Test(dataProvider = "getData")
    public void test(String name, Integer id){
        System.out.println(name);
        System.out.println(id);
    }

}
