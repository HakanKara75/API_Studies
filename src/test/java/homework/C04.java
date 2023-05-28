package homework;

import base_urls.ReqresBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class C04 extends ReqresBaseUrl {


    /*
        Given
            https://restful-booker.herokuapp.com/booking
        When
            User sends get request to the URL
        Then
            Status code is 200
	  	And
	  		Among the data there should be someone whose firstname is "Jane" and lastname is "Doe"
			(Data içinde firstname "Jane" ve lastname "Doe" olan bir booking olduğunu doğrulayın)

     */

    @Test
    public void name() {
        //Set the url
        spec.pathParam("first", "booking")
                .queryParams("firstname", "Jane", "lastname", "Doe");

        //Set the expected Data

        //Send the request and get the response
        Response response = given(spec).get("{first}");
        //Response response = given().spec(spec).when().get("/{first}" );
        response.prettyPrint();

        //do assertion
        assertEquals(200,response.statusCode());
        assertTrue(response.asString().contains("bookingid"));
    }
}
