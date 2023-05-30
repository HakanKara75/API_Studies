package homework.get2;

import base_urls.ReqresBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class C02 extends ReqresBaseUrl {
/*    https://petstore.swagger.io/ dokumanını kullanarak statüsü "available" olan "pet"
    sayısını bulup 100'den fazla olduğunu assert eden bir otomasyon testi yazınız.

    https://petstore.swagger.io/v2/pet/findByStatus?status=available
    Example Value
    Model
[
    {
        "id": 0,
            "category": {
        "id": 0,
                "name": "string"
    },
        "name": "doggie",
            "photoUrls": [
        "string"
    ],
        "tags": [
        {
            "id": 0,
                "name": "string"
        }
    ],
        "status": "available"
    }
]
}
*/

    @Test
    public void name() {
        //set the url
        spec.pathParams("first","pet","second","findByStatus").
                queryParam("status","available");

        //set the expected data


        //Send the request and get the response
        Response response=given(spec).get("{first}/{second}");
        response.prettyPrint();

        //do assertion
//statüsü "available" olan "pet"
//    sayısını bulup 100'den fazla olduğunu assert eden
        assertEquals(404, response.statusCode());

        int availablePetSayisi = response.jsonPath().getList("id").size();
        assertTrue(availablePetSayisi>100);


    }
}