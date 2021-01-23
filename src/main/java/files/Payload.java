package files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Payload {
    public static String AddPlace() {
        return "{\n" +
                "  \"location\": {\n" +
                "    \"lat\": -38.383494,\n" +
                "    \"lng\": 33.427362\n" +
                "  },\n" +
                "  \"accuracy\": 50,\n" +
                "  \"name\": \"Frontline house\",\n" +
                "  \"phone_number\": \"(+91) 983 893 3937\",\n" +
                "  \"address\": \"29, side layout, cohen 09\",\n" +
                "  \"types\": [\n" +
                "    \"shoe park\",\n" +
                "    \"shop\"\n" +
                "  ],\n" +
                "  \"website\": \"https://rahulshettyacademy.com\",\n" +
                "  \"language\": \"French-IN\"\n" +
                "}";
    }

    public static String CoursePrice() {
        return "{\n" +
                "\"dashboard\": {\n" +
                "\"purchaseAmount\": 12429,\n" +
                "\"website\": \"rahulshettyacademy.com\"\n" +
                "},\n" +
                "\"courses\": [\n" +
                "{\n" +
                "\"title\": \"Selenium Python\",\n" +
                "\"price\": 50,\n" +
                "\"copies\": 6\n" +
                "},\n" +
                "{\n" +
                "\"title\": \"Cypress\",\n" +
                "\"price\": 40,\n" +
                "\"copies\": 4\n" +
                "},\n" +
                "{\n" +
                "\"title\": \"RPA\",\n" +
                "\"price\": 45,\n" +
                "\"copies\": 10\n" +
                "},\n" +
                "{\n" +
                "\"title\": \"Appium\",\n" +
                "\"price\": 36,\n" +
                "\"copies\": 7\n" +
                "},\n" +
                "{\n" +
                "\"title\": \"English\",\n" +
                "\"price\": 23,\n" +
                "\"copies\": 5\n" +
                "},\n" +
                "{\n" +
                "\"title\": \"Maths\",\n" +
                "\"price\": 136,\n" +
                "\"copies\": 82\n" +
                "}\n" +
                "]\n" +
                "}";
    }

    public static String Addbook(String isbn, String aisle) {
        String payload="{\n" +
                "\n" +
                "\"name\":\"Learn Appium Automation with Java\",\n" +
                "\"isbn\":\""+isbn+"\",\n" +
                "\"aisle\":\""+aisle+"\",\n" +
                "\"author\":\"Shiva13821\"\n" +
                "}\n" +
                " ";
        return payload;
    }
    public static String DeleteBook(String id)
    {
        String payload="{\n" +
                " \n" +
                "\"ID\" : \""+id+"\"\n" +
                " \n" +
                "} ";
        return  payload;
    }
    public static String GenerateStringFromResource(String path) throws IOException {


        return new String(Files.readAllBytes(Paths.get(path)));


    }
    public static String ShivamInstructor(String id)
    {
        String payload="{\n" +
                "  \"shivaminfo\" :\n" +
                "  {\n" +
                "    \"instructor\": \"RahulShetty\",\n" +
                "    \"url\": \"rahulshettycademy.com\",\n" +
                "    \"services\": \"projectSupport\",\n" +
                "    \"expertise\": \"Automation\",\n" +
                "    \"courses\": [\n" +
                "      {\n" +
                "        \"webAutomation\" : [\n" +
                "          {\"courseTitle\": \"Selenium Webdriver Java\",\n" +
                "            \"price\": \"50\"},\n" +
                "          {\"courseTitle\": \"Cypress\",\n" +
                "            \"price\": \"40\"}\n" +
                "        ]\n" +
                "      },\n" +
                "      {\n" +
                "        \"api\" : [\n" +
                "          {\"courseTitle\": \"Rest Assured Automation using Java\",\n" +
                "            \"price\": \"50\"\n" +
                "          },\n" +
                "          {\"courseTitle\": \"SoapUI Webservices testing\",\n" +
                "            \"price\": \"40\"\n" +
                "          }\n" +
                "        ]\n" +
                "      },\n" +
                "      {\n" +
                "        \"mobile\" : [\n" +
                "          {\n" +
                "            \"courseTitle\": \"Appium-Mobile Automation using Java\",\n" +
                "            \"price\": \"50\"\n" +
                "          }\n" +
                "        ]\n" +
                "      }\n" +
                "\n" +
                "    ],\n" +
                "    \"linkedIn\": \"https://www.linkedin.com/in/rahul-shetty-trainer/\"\n" +
                "  }\n" +
                "\n" +
                "\n" +
                "}";

        return  payload;
    }
    public static String relationPayload(){
        String relation ="{\n" +
                "  \"posts\": [\n" +
                "    {\n" +
                "      \"id\": 1,\n" +
                "      \"title\": \"json-server\",\n" +
                "      \"author\": \"typicode\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 2,\n" +
                "      \"title\": \"json-server1\",\n" +
                "      \"author\": \"typicode1\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 3,\n" +
                "      \"title\": \"json-server\",\n" +
                "      \"author\": \"Shivam\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"comments\": [\n" +
                "    {\n" +
                "      \"id\": 1,\n" +
                "      \"body\": \"some comment\",\n" +
                "      \"postId\": 1\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 2,\n" +
                "      \"body\": \"I addec this comment\",\n" +
                "      \"postId\": 2\n" +
                "    }\n" +
                "  ],\n" +
                "  \"weather\": [\n" +
                "    {\n" +
                "      \"City\": \"Hyderabad\",\n" +
                "      \"Temperature\": \"31.49 Degree celsius\",\n" +
                "      \"Humidity\": \"62 Percent\",\n" +
                "      \"Weather Description\": \"scattered clouds\",\n" +
                "      \"Wind Speed\": \"3.6 Km per hour\",\n" +
                "      \"Wind Direction degree\": \"270 Degree\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"City\": \"Kolkata\",\n" +
                "      \"Temperature\": \"50.49 Degree celsius\",\n" +
                "      \"Humidity\": \"78 Percent\",\n" +
                "      \"Weather Description\": \"scattered clouds\",\n" +
                "      \"Wind Speed\": \"9.6 Km per hour\",\n" +
                "      \"Wind Direction degree\": \"870 Degree\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"profile\": {\n" +
                "    \"name\": \"typicode11\"\n" +
                "  },\n" +
                "  \"relation\": {\n" +
                "    \"family\": {\n" +
                "      \"test\": [\n" +
                "        {\n" +
                "          \"father\": \"baapi\",\n" +
                "          \"maa\": \"neelima\",\n" +
                "          \"sister\": \"bordi\",\n" +
                "          \"brother\": \"tapu\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"father\": \"baapiAA\",\n" +
                "          \"maa\": \"neelimaAA\",\n" +
                "          \"sister\": \"bordiAA\",\n" +
                "          \"brother\": \"tapuAA\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"father\": \"baapiBB\",\n" +
                "          \"maa\": \"neelimaBB\",\n" +
                "          \"sister\": \"bordiBB\",\n" +
                "          \"brother\": \"tapuBB\"\n" +
                "        }\n" +
                "      ]\n" +
                "    },\n" +
                "    \"friends\": {\n" +
                "      \"test1\": [\n" +
                "        {\n" +
                "          \"schoolfriend\": \"sutapa\",\n" +
                "          \"collagefriend\": \"neelima\",\n" +
                "          \"hostelfriend\": \"tanusree\",\n" +
                "          \"phdfriend\": \"manju\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"schoolfriend\": \"chandana\",\n" +
                "          \"collagefriend\": \"sujatha\",\n" +
                "          \"hostelfriend\": \"kuntala\",\n" +
                "          \"phdfriend\": \"sharmistha\"\n" +
                "        }\n" +
                "      ]\n" +
                "    }\n" +
                "  }\n" +
                "}";
        return relation;
    }

}
