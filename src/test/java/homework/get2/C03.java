package homework.get2;

import base_urls.ReqresBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class C03 extends ReqresBaseUrl {
    /*
    Given
        https://automationexercise.com/api/productsList
    When
        User sends Get request
    Then
        Assert that number of "Women" usertype is 12
        (Kadın usertype sayısının 12 olduğunu doğrulayın)

    Not: Yazdırmayı jsonPath kullanarak yapınız: response.jsonPath().prettyPrint();

*/

    @Test
    public void name() {
        //set the url
        spec.queryParam("first", "productsList");

        //set the data

        //send request and get the response
        Response response = given(spec).get("{/first}");
        response.jsonPath().prettyPrint();

        //do assertion
        JsonPath jsonPath=response.jsonPath();
        int kadinUserSayisi= jsonPath.getList("products.findAll{it.category.usertype.usertype=='Women'}").size();
        assertEquals(12, kadinUserSayisi);

    }
}
