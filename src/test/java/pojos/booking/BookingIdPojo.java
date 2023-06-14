package pojos.booking;

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
public class BookingIdPojo {
    private int bookingid;
    private BookingPojo booking;


}
