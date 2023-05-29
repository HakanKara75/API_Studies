package post_requests;

import base_urls.ReqresBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class Post05 extends ReqresBaseUrl {
/*
https://jsonplaceholder.typicode.com/posts url'ine
asagidaki body ile bir post request gonderdigimizde
{
"title":"API",
"body":"API ogrenmek ne guzel",
"userId":10
}
donen respons'un
status code'unun 201,
content type'nin application/json
Response body'sinin id haric,
{
"title":"API",
"body":"API ogrenmek ne guzel",
"userId":10
}
oldugunu test edin.
 */

    @Test
    public void name() {
        //set the url
        String url="https://jsonplaceholder.typicode.com/posts";

        JSONObject requestData = new JSONObject();
        requestData.put("title", "API");
        requestData.put("body", "API ogrenmek ne guzel");
        requestData.put("userId", 10);
        //set the expected data
        JSONObject expectedData = new JSONObject();
        expectedData.put("title", "API");
        expectedData.put("body", "API ogrenmek ne guzel");
        expectedData.put("userId", 10);

        //send the request get the response
        Response response =given().contentType(ContentType.JSON).when().body(requestData.toString()).post(url);

        //do assertion
        JsonPath actualData=response.jsonPath();
        response.then()
                .assertThat()
                .contentType(ContentType.JSON)
                .statusCode(201);

        assertEquals(expectedData.get("title"), actualData.get("title"));
        assertEquals(expectedData.get("body"), actualData.get("body"));
        assertEquals(expectedData.get("userId"), actualData.get("userId"));
    }
}
