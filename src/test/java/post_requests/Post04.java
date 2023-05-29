package post_requests;

import base_urls.ReqresBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojo.ReqresPojo;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class Post04 extends ReqresBaseUrl {
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
                                                "id": "496",
                                                "createdAt": "2022-10-04T15:18:56.372Z"
                                              }
     */

    @Test
    public void name() {
        //set the url
        spec.pathParams("first", "api", "second", "users");

        // set the data
        ReqresPojo expectedData=new ReqresPojo("morpheus","leader");
        Response response= given(spec).body(expectedData).post("{first}/{second}");
        response.prettyPrint();

        //do assertion
        assertEquals(201, response.statusCode());

        ReqresPojo actualData=response.as(ReqresPojo.class);
        assertEquals(expectedData.getName(),actualData.getName());
        assertEquals(expectedData.getJob(),actualData.getJob());

        Map<?, ?> actualDatas = response.as(HashMap.class);
        System.out.println(actualDatas);

        assertTrue(actualDatas.containsKey("createdAt"));
        assertTrue(actualDatas.containsKey("id"));

    }

    @Test
    public void name1() {
        // set the url
        spec.pathParams("pp1","api","pp2","users");

        //set the expected data
        Map<String, Object> expectedData= new HashMap<>();
        expectedData.put("name","morpheus");
        expectedData.put("job","leader");

        //send the request get the response
        Response response= given(spec).body(expectedData).post("{pp1}/{pp2}");
        response.prettyPrint();

        //do assertion
        Map<String,Object> actualData = response.as(Map.class);

        assertEquals(expectedData.get("name"), actualData.get("name"));
        assertEquals(expectedData.get("job"), actualData.get("job"));
        assertTrue(actualData.containsKey("createdAt"));

    }
}
