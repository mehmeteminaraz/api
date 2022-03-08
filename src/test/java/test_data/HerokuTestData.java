package test_data;
import java.util.HashMap;
public class HerokuTestData {

    public HashMap<String, Object> setUpTestData() {
        HashMap<String, Object> bookingdates = new HashMap<>();
        bookingdates.put("checkin", "2022-02-01");
        bookingdates.put("checkout", "2022-02-11");
        setUpTestData().put("firstname", "Ali");
        setUpTestData().put("lastname", "Can");
        setUpTestData().put("totalprice", 500);
        setUpTestData().put("depositpaid", true);
        setUpTestData().put("bookingdates", bookingdates);
        return setUpTestData();
    }
}