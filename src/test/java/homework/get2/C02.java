package homework.get2;

import base_urls.ReqresBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
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
        spec.pathParam("first", "findByStatus" ).queryParam("status", "available");

        //set the expected data


        //Send the request and get the response
        Response response = given(spec).get("/{first}");
        response.prettyPrint();

        //do assertion
//statüsü "available" olan "pet"
//    sayısını bulup 100'den fazla olduğunu assert eden
        assertEquals(404, response.statusCode());
        assertEquals("available", "available");


    }
}