package homework;

import base_urls.ReqresBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class C05 extends ReqresBaseUrl {


    @Test
    public void name() {
         /*
        Given
          https://reqres.in/api/unknown/3
        When
            User send a GET request to the URL
        Then
            HTTP Status Code should be 200
        And
            Response content type is “application/json; charset=utf-8”
        And
            Response body should be like;(Soft Assertion)
        {
        "data": {
            "id": 3,
            "name": "true red",
            "year": 2002,
            "color": "#BF1932",
            "pantone_value": "19-1664"
        },
        "support": {
            "url": "https://reqres.in/#support-heading",
            "text": "To keep ReqRes free, contrib"utions towards server costs are appreciated!"
        }
}
      */

        //set the url
        spec.pathParams("first", "api", "second", "unknown", "third", 3);

        // set the expected data
        Map<String, Object> expectedData = new JsonPlaceHolderTestData().reqresexpectedDataMap(3, "true red", 2002, "#BF1932", "19-1664");

        //send the request and get the response
        Response response =given(spec).get("{first}/{second}/{third}");
        response.prettyPrint();

        //do assertion
        Map<String, Object> actualData = response.as(HashMap.class); //de serialization json to java
        assertEquals(200, response.statusCode());
        assertEquals("application/json; charset=utf-8", response.contentType());
        assertEquals(expectedData.get("id"), actualData.get("id"));
        assertEquals(expectedData.get("name"), actualData.get("name"));
        assertEquals(expectedData.get("year"), actualData.get("year"));
        assertEquals(expectedData.get("color"), actualData.get("color"));
        assertEquals(expectedData.get("pantone_value"), actualData.get("pantone_value"));



    }
}
