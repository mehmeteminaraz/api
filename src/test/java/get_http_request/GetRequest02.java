package get_http_request;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class GetRequest02 {
    @Test
    public void test02(){
        String url="https://reqres.in/api/users";
        Response response=given().when().get(url);

       response.prettyPrint();                  // respostaki body'i getirir
       // response.then().log().all();        //respostaki herseyi getirir
        response.prettyPeek();               //herseyi getirir

        //HeaderTest
         response.then().assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .statusLine("HTTP/1.1 200 OK");


        //Body Test
        response.then().body("data[1].first_name",equalTo("Janet")
                ,"data[1].last_name",equalTo("Weaver")
                ,"data[1].email",equalTo("janet.weaver@reqres.in"));

        //HeaderTest
        response.then().body("data[1].id",equalTo(2)
                            ,"data[1].email",equalTo("janet.weaver@reqres.in")
                            ,"data[1].first_name",equalTo("Janet")
                            ,"data[1].last_name",equalTo("Weaver")
                            ,"data[1].avatar",equalTo("https://reqres.in/img/faces/2-image.jpg"));


    }
}
