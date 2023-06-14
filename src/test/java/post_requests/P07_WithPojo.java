package post_requests;

import base_urls.HerokuappBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.BookingDatesPojo;
import pojos.booking.BookingIdPojo;
import pojos.booking.BookingPojo;
import static org.testng.AssertJUnit.*;
import static io.restassured.RestAssured.given;

public class P07_WithPojo extends HerokuappBaseUrl {
    /*
    https://restful-booker.herokuapp.com/booking
    request body
        {
        "firstname" : "Hakan",
        "lastname" : "Kara",
        "totalprice" : 1500,
        "depositpaid" : true,
        "bookingdates": {
        "checkin":"2022-09-09",
        "checkout":"2022-09-21"
        }
    }
    status code is 200
    response body
            {
            "bookingid" : 11,
            "booking":{
            "firstname" : "Hakan",
            "lastname" : "Kara",
            "totalprice" : 1500,
            "depositpaid" : true,
            "bookingdates": {
            "checkin":"2022-09-09",
            "checkout":"2022-09-21"
            }
    }
    }
     */

    @Test
    public void name() {

        //set the url
        specHerokuapp.pathParam("pp1", "booking");

        //set the expected data
        BookingDatesPojo bookingDatesPojo = new BookingDatesPojo("2022-09-09","2022-09-21");
        BookingPojo bookingPojo=new BookingPojo("Hakan", "Kara", 1500, true, bookingDatesPojo);

        //send the request and get the response
        Response response= given()
                .contentType(ContentType.JSON)
                .spec(specHerokuapp)
                .when().body(bookingPojo)
                .post("{pp1}");
        response.prettyPrint();

        BookingIdPojo actualData= response.as(BookingIdPojo.class);

        //assert the request
        assertEquals(200, response.getStatusCode());
        assertEquals(bookingPojo.getFirstname(), actualData.getBooking().getFirstname());
        assertEquals(bookingPojo.getLastname(), actualData.getBooking().getLastname());
        assertEquals(bookingPojo.getTotalprice(), actualData.getBooking().getTotalprice());
        assertEquals(bookingPojo.isDepositpaid(), actualData.getBooking().isDepositpaid());
        assertEquals(bookingPojo.getBookingdates().getCheckin(), actualData.getBooking().getBookingdates().getCheckin());
        assertEquals(bookingPojo.getBookingdates().getCheckout(), actualData.getBooking().getBookingdates().getCheckout());











    }
}
