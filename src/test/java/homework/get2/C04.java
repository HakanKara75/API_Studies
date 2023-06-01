package homework.get2;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData2;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class C04 extends JsonPlaceHolderBaseUrl {
    /*
    https://jsonplaceholder.typicode.com/posts/22 url'ine bir GET request yolladigimizda
    donen response'in status code'unun 200 ve response body'sinin asagida verilen ile
    ayni oldugunu test ediniz

    Response body:
    {
  "userId": 3,
  "id": 22,
  "title": "dolor sint quo a velit explicabo quia nam",
  "body": "eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae
   aut atque rem suscipit\nnam impedit esse"
        }
     */

    @Test
    public void name() {
    //set the url
      spec.pathParam("pp1", 22);


      //set the expected data
        JsonPlaceHolderTestData2 expectedData = new JsonPlaceHolderTestData2();
        JSONObject expectedBody= expectedData.expectedDataOlustur();


        //send request and get the response
        Response response = given(spec).get("{pp1}");
        response.prettyPrint();

        //do assertion
        JsonPath responseJPath=response.jsonPath();

        int statusCode= expectedData.basariliStatusKodu;
        assertEquals(statusCode, response.statusCode());

        assertEquals(expectedBody.getInt("userId"), responseJPath.getInt("userId"));
        assertEquals(expectedBody.getInt("id"), responseJPath.getInt("id"));
        assertEquals(expectedBody.getString("title"), responseJPath.getString("title"));
        assertEquals(expectedBody.getString("body"), responseJPath.getString("body"));

    }
}
