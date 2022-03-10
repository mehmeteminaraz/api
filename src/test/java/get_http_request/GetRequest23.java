package get_http_request;

import base_url.DummyBaseUrl;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import test_data.DummyTestData;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class GetRequest23 extends DummyBaseUrl {
    /*
http://dummy.restapiexample.com/api/v1/employees url ine bir istek gönderildiğinde
Status kodun 200 olduğunu,
14. Çalışan isminin "Haley Kennedy" olduğunu,
Çalışan sayısının 24 olduğunu,
Sondan 3. çalışanın maaşının 675000 olduğunu
40,21 ve 19 yaslarında çalışanlar olup olmadığını
10. Çalışan bilgilerinin bilgilerinin aşağıdaki gibi

{
        "id": 10,
        "employee_name": "Sonya Frost",
        "employee_salary": 103600,
        "employee_age": 23,
        "profile_image": ""
 }

  olduğunu test edin.
*/
    @Test
    public void test23(){

        //1) URL OLUSTUR
        spec02.pathParams("bir", "api", "iki", "v1", "uc", "employees");

        //2) EXPECTED DATA OLUSTUR
        DummyTestData expectedObje = new DummyTestData();
        HashMap<String, Object> expectedTestDataMap = expectedObje.setUpTestData();
        System.out.println("EXPECTED TEST DATA: " + expectedTestDataMap);
        //EXPECTED TEST DATA: {onuncucalisan=
        //                                  {profile_image=,
        //                                  employee_name=Sonya Frost,
        //                                  employee_salary=103600,
        //                                  id=10, employee_age=23},
        //                     ondurduncucalisan=Haley Kennedy,
        //                     arananyaslar=[40, 21, 19],
        //                     calisansayisi=24,
        //                     statusCode=200,
        //                     sondanucuncucalisaninmaasi=675000}

        //3) REQUEST VE RESPONSE OLUSTUR
        Response response = given().spec(spec02).when().get("/{bir}/{iki}/{uc}");
        response.prettyPrint();

        //4) DOGRULAMA
        //De-Serialization

        //Status kodun 200 olduğunu,
        Assert.assertEquals(expectedTestDataMap.get("statusCode"), response.statusCode());

        //14. Çalışan isminin "Haley Kennedy" olduğunu,

        //Çalışan sayısının 24 olduğunu,

        //Sondan 3. çalışanın maaşının 675000 olduğunu


        //40,21 ve 19 yaslarında çalışanlar olup olmadığını


    }
}