package homework.get1;

import base_urls.ReqresBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.*;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class C06_Groovy extends ReqresBaseUrl {
     /*
       Given
              https://reqres.in/api/unknown/
       When
            I send GET Request to the URL
       Then

            1)Status code is 200
            2)Print all pantone_values
              (Tüm pantone_value değerlerini yazdırınız)
            3)Print all ids greater than 3 on the console
              (3'ten büyük id'leri yazdırınız)
              Assert that there are 3 ids greater than 3
              (3'ten büyük 3 adet id olduğunu doğrulayınız)
            4)Print all names whose ids are less than 3 on the console
              (id'si 3'ten küçük isimleri yazdırınız)
              Assert that the number of names whose ids are less than 3 is 2
              (id'si 3'ten küçük 2 isim olduğunu doğrulayınız)
    */

    @Test
    public void name() {
        //set the url
        spec.pathParams("first", "api", "second", "unknown");

        //set  the expected data

        //send the request and get the response
        Response response = given(spec).get("{first}/{second}");
        response.prettyPrint();

        //do assertion
        assertEquals(200, response.statusCode());

        //Print all pantone_values
        JsonPath json = response.jsonPath();
        List<String> pantoneValue = json.getList("data.findAll{it.pantone_value}");
        System.out.println(pantoneValue);

        //Print all ids greater than 3 on the console
        List<Object> idGreaterThanThreeList = json.getList("data.findAll{it.id>3}.id");
        System.out.println("idGreaterThanThreeList = " + idGreaterThanThreeList);
        List<Integer> idGreaterThan3 = new ArrayList<Integer>();

        // Assert that there are 3 ids greater than 3
        int sayac = 0;
        for (Integer id : idGreaterThan3) {
            if (id > 3) {
                sayac++;
            }
        }
        System.out.println("sayac = " + sayac);
        assertTrue(sayac == 3);
        assertTrue(idGreaterThan3.size() == 3);


        //Print all names whose ids are less than 3 on the console
        List<Object> list = json.getList("data.findAll{it.id<3}.name");
        System.out.println(list);

//        Assert that the number of names whose ids are less than 3 is 2
//        (id'si 3'ten küçük 2 isim olduğunu doğrulayınız)
        assertEquals(2, list.size());

    }
}
