package homework.get2;

import base_urls.ReqresBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import netscape.javascript.JSObject;
import org.json.JSONObject;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class C01 extends ReqresBaseUrl {
/*
https://jsonplaceholder.typicode.com/posts/44 url'ien bir
GET request yolladigimizda donen response'nin

status code'unun 200,
ve content type'inin JSON
ve response body'sinde bulunan userId'nin 5,
ve response body'sinde bulunan user title'nin "optio dolor molestias sit",
oldugunu test edin

 */

    @Test
    public void name() {
        //set the url
      spec.pathParams("first","posts", "second", 44);

       //set the expected data
        Map<String, Object> expectedBody = new HashMap<>();
        expectedBody.put("userId", 5);
        expectedBody.put("title", "optio dolor molestias sit");

        //get response and the result
        Response response = given(spec).body(expectedBody).put("{first}/{second}");

        //do assertion
        response.then().statusCode(200).
              contentType(ContentType.JSON);
        response.prettyPrint();

        Map<String ,Object> actualData =response.as(HashMap.class);
        assertEquals(expectedBody.get("userId"),actualData.get("userId"));
        assertEquals(expectedBody.get("title"),actualData.get("title"));



    }
}
