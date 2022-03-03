package get_http_request;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetRequest03 {

    /*
    https://restful-booker.herokuapp.com/booking/7 url'ine
GET request'i yolladigimda
gelen response'un
status kodunun 200
ve content type'inin "application/json"
ve firstname'in "Sally"
ve lastname'in "Ericsson"
ve checkin date'in 2018-10-07"
ve checkout date'in 2020-09-30 oldugunu test edin


1) API testlerinde Web Driver kullanıyor musunuz? Hangi dependencies'leri kullanıyorsunuz?
   API testlerinde, UI testleri için gerekli Web Driver dependencies'lere ihtiyaç yoktur.
   Başlangıç için Rest-Assured veye JUnit ve TEstNG gibi dependencies'ler yeterli olur.

2) Doğrulama için kullanılan, Hard Assert ve Verification farkları nelerdir?
   Hard Assert kullandığımızda ilk hata olan yerde test durur.
   Verification'da; testler hata olsa dahi çalışır. Hatalı olan test için hata mesajı alınır.
   ÖNEMLİ: Soft Assert = Verification

3) API testlerinde request nasıl tanımlanır?
   given().when().get() içerisinde tanımlanır.

4) Request'ten gelen cevap (response) nerede saklanır?
   Response response'un içerisinde.

5) assertThat() Hard mı yoksa Soft Assert müdür?
   assertThat() Hard assertion'dır.

6) API Testlerinde response doğrulma nasıl yapılır?
   a) TestNG ve JUnit Assert'leri kullanılarak
   b) assertThat()
   c) Json Path
   d) Matchers Class
   e)
   f)
   g)
   h)


https://restful-booker.herokuapp.com/booking

https://reqres.in/api/users













     */

    @Test
    public void test03(){

        String url = "https://restful-booker.herokuapp.com/booking/7";

        Response response = given().when().get(url);

        response.prettyPrint();

        response.then().contentType(ContentType.JSON).statusCode(200);

        response.then().body("firstname", equalTo("Mary")
                , "lastname", equalTo("Jones")
                , "bookingdates.checkin", equalTo("2015-06-02")
                , "bookingdates.checkout", equalTo("2018-09-29"));
    }
}