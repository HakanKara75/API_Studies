package homework;

import base_urls.ReqresBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;

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
        response.prettyPrint();

        response.then().statusCode(200).body("bookingid", hasSize(greaterThan(0)));
    }
}
