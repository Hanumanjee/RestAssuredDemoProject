package shivam.chapter11.simplepojoexample;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

public class EmployeeSerializationDeserialization {
    @Test
    public void createEmployeeJSONFromEmployeePOJOClass() throws JsonProcessingException
    {
        // Just create an object of Pojo class
        Employee employee = new Employee();
        // Set value as you wish
        employee.setFirstName("Amod");
        employee.setLastName("Mahajan");
        employee.setAge(29);
        employee.setGender("Male");
        employee.setSalary(3434343);
        employee.setMarried(false);

        // Converting a Java class object to a JSON payload as string
        ObjectMapper objectMapper = new ObjectMapper();
        String employeeJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(employee);
        System.out.println(employeeJson);
    }
}
