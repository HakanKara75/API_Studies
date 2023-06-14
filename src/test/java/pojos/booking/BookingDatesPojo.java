package pojos.booking;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
org.projectlombok dependency pom.xml eklenince pojo class'a sadece variable'lar yazilir. Asagidaki 3 anotation
getter, setter, constructor ve toString method'larin yazilmasina ihtiyac birakmaz.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingDatesPojo {
    /*
     "bookingdates": {
        "checkin":"2022-09-09",
                "checkout":"2022-09-21"
    }

     */
    private String checkin;
    private String checkout;


}
