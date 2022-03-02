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
       /* response.prettyPrint();    body'i getirir
        response.then().log().all(); herseyi getirir*/
        response.prettyPeek();       //herseyi getirir
        response.then().assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .statusLine("HTTP/1.1 200 OK");
        response.then().body("data[1].first_name", Matchers.equalTo("Janet")
                ,"data[1].last_name",Matchers.equalTo("Weaver")
                ,"data[1].email",Matchers.equalTo("janet.weaver@reqres.in"));





    }
}
