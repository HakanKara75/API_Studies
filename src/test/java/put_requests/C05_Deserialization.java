package put_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData2;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C05_Deserialization extends JsonPlaceHolderBaseUrl {
    /*
https://jsonplaceholder.typicode.com/posts/70 url'sine asagidaki body'e sahip bir PUT request yolladimizda donen
response'nin body'sinin asagida verilen ile ayni oldugunu test ediniz.

Request body:
    {
    "title": "Ahmet",
    "body": "Merhaba",
    "userId": 10,
    "id": 70
}

Expected data:
{
    "title": "Ahmet",
    "body": "Merhaba",
    "userId": 10,
    "id": 70
}
     */

    @Test
    public void name() {
        //set the url
        spec.pathParam("pp1", 70);



        //send request and get the response
        JsonPlaceHolderTestData2 jsonPlaceHolderTestData2=new JsonPlaceHolderTestData2();//expected data kalibini bu classta olusturdum
        Map<String, Object> reqBodyMap=jsonPlaceHolderTestData2.requestBodyMapOlustur(); //expected data'yi request icin bir map'a atadim
        // System.out.println("reqBodyMap = " + reqBodyMap);

        Response response= given(spec)
                .contentType(ContentType.JSON)
                .when()
                .body(reqBodyMap).put("{pp1}");
        //response.prettyPrint();

        //do assertion
        Map<String, Object> expectedDataMap= jsonPlaceHolderTestData2.requestBodyMapOlustur();
        Map<String, Object> responseBodyMap= response.as(HashMap.class); //gelen response'u bir map'e atadim

        assertEquals(jsonPlaceHolderTestData2.basariliStatusKodu, response.statusCode());



        assertEquals(expectedDataMap.get("title"), responseBodyMap.get("title"));
        assertEquals(expectedDataMap.get("body"), responseBodyMap.get("body"));
        assertEquals(expectedDataMap.get("userId"), responseBodyMap.get("userId"));
        assertEquals(expectedDataMap.get("id"), responseBodyMap.get("id"));




    }
}
