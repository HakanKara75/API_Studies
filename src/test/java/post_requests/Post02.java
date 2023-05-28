package post_requests;

import base_urls.ReqresBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class Post02 extends ReqresBaseUrl {
     /*
        Given
            1) https://reqres.in/api/users
            2) {
                "name": "morpheus",
                "job": "leader"
                }
        When
            I send POST Request to the Url
        Then
            Status code is 201
            And response body should be like {
                                                "name": "morpheus",
                                                "job": "leader",
                                                "id": "335",
                                                "createdAt": "2022-10-04T15:18:56.372Z"
                                              }
     */

    @Test
    public void name() {
        //set th url
      spec.pathParam("first","users");

      //set the expected data
        String room ="{\n" +
                "                \"name\": \"morpheus\",\n" +
                "                \"job\": \"leader\"\n" +
                "                }";

        //send the request and get the response
        Response response=given(spec).body(room).post("{first}");
        response.prettyPrint();

        //do assertion
        assertEquals(201, response.statusCode());
        JsonPath jsonPath=response.jsonPath();
        assertEquals("morpheus", jsonPath.getString("name"));
        assertEquals("leader", jsonPath.getString("job"));



    }
}
