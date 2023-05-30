package pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BookingResponsePojo {

    private HerOkuPojo booking;

    public BookingResponsePojo() {
    }

    public BookingResponsePojo(HerOkuPojo booking) {
        this.booking = booking;
    }

    public HerOkuPojo getBooking() {
        return booking;
    }

    public void setBooking(HerOkuPojo booking) {
        this.booking = booking;
    }

    @Override
    public String toString() {
        return "BookingResponsePojo{" +
                "booking=" + booking +
                '}';
    }
}
