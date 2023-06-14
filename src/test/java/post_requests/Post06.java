package post_requests;

import base_urls.ReqresBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.BookingDatesPojo;
import pojos.BookingResponsePojo;
import pojos.HerOkuPojo;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.*;

public class Post06 extends ReqresBaseUrl {
    /*
   "https://restful-booker.herokuapp.com/apidoc/index.html" dökümanını kullanarak;

    Bir booking oluşturan,
    o booking'i güncelleyen
    ve sonra silen ve bu adımları doğrulayan
    positif ve negatif testler içeren bir otomasyon testi yazınız.
    {
        "firstname" : "Hakan",
        "lastname" : "Kara",
        "totalprice" : 111,
        "depositpaid" : true,
        "bookingdates" : {
            "checkin" : "2018-01-01",
            "checkout" : "2019-01-01"
        },
        "additionalneeds" : "tereyag bal"}

*/


    @Test
    public void name() {
        //set the url
        spec.queryParam("first", "booking");

        //set the data
        BookingDatesPojo bookingDatesPojo=new BookingDatesPojo("2018-01-01","2019-01-01");
        HerOkuPojo herOkuPojo =new HerOkuPojo("Hakan", "Kara", 111, true,bookingDatesPojo,"tereyag bal");
        System.out.println("herOkuPojo.toString() = " + herOkuPojo.toString());

        //send request and get the response
        Response response = given(spec).body(herOkuPojo).post("/{first}");
        response.jsonPath().prettyPrint();

        //do assertion
        BookingResponsePojo bookingResponsePojo=response.as(BookingResponsePojo.class);

        assertEquals(201, response.statusCode());

        assertEquals(herOkuPojo.getFirstname(), bookingResponsePojo.getBooking().getFirstname());
        assertEquals(herOkuPojo.getLastname(), bookingResponsePojo.getBooking().getLastname());
        assertEquals(herOkuPojo.getTotalprice(), bookingResponsePojo.getBooking().getTotalprice());
        assertEquals(herOkuPojo.getDepositpaid(), bookingResponsePojo.getBooking().getDepositpaid());
        assertEquals(herOkuPojo.getAdditionalneeds(), bookingResponsePojo.getBooking().getAdditionalneeds());
        assertEquals(bookingDatesPojo.getCheckin(), bookingResponsePojo.getBooking().getBookingDatesPojo().getCheckin());
        assertEquals(bookingDatesPojo.getCheckout(), bookingResponsePojo.getBooking().getBookingDatesPojo().getCheckout());


    }

    @Test
    public void test2() {
        //set the url
        spec.pathParam("first", "booking");

        // set the data
        BookingDatesPojo bookingDatesPojo=new BookingDatesPojo("2024-01-01","2024-01-11");
        HerOkuPojo herOkuPojo=new HerOkuPojo("Hakan", "Kara", 200, true, bookingDatesPojo,"Ankara simidi");

        //send request and get the response
        Response response=given(spec).post("{/first}");
        response.jsonPath().prettyPrint();

        //do assert
        BookingResponsePojo bookingDatesPojo1= response.as(BookingResponsePojo.class);

        assertEquals(201, response.getStatusCode());

        assertEquals(herOkuPojo.getFirstname(), bookingDatesPojo1.getBooking().getFirstname());
        assertEquals(herOkuPojo.getLastname(), bookingDatesPojo1.getBooking().getLastname());
        assertEquals(herOkuPojo.getDepositpaid(), bookingDatesPojo1.getBooking().getDepositpaid());
        assertEquals(herOkuPojo.getTotalprice(), bookingDatesPojo1.getBooking().getTotalprice());
        assertEquals(herOkuPojo.getAdditionalneeds(), bookingDatesPojo1.getBooking().getAdditionalneeds());
        assertEquals(herOkuPojo.getBookingDatesPojo().getCheckin(), bookingDatesPojo1.getBooking().getBookingDatesPojo().getCheckin());
        assertEquals(herOkuPojo.getBookingDatesPojo().getCheckin(), bookingDatesPojo1.getBooking().getBookingDatesPojo().getCheckin());
    }

    @Test
    public void test3() {
        //set the url
        spec.pathParam("first", "booking");

        // set the data
        BookingDatesPojo bookingDatesPojo=new BookingDatesPojo("2024-01-01","2024-01-11");
        HerOkuPojo herOkuPojo=new HerOkuPojo("Hakan", "Kara", 200, true, bookingDatesPojo,"Ankara simidi");

        //send request and get the response
        Response response=given(spec).delete("{/first}");
        response.jsonPath().prettyPrint();

        //do assert
        BookingResponsePojo bookingDatesPojo2= response.as(BookingResponsePojo.class);
        assertEquals(201, response.getStatusCode());

        assertNull(herOkuPojo.getFirstname(),bookingDatesPojo2.getBooking().getFirstname());


    }
}
