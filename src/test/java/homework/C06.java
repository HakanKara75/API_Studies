package homework;

import base_urls.ReqresBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.*;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class C06 extends ReqresBaseUrl {
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
        spec.pathParam("first", "unknown");

        //set  the expected data

       //send the request and get the response
        Response response=given(spec).get("/{first}");
        response.prettyPrint();

        //do assertion
        assertEquals(200, response.statusCode());
        assertEquals(200, response.statusCode());

        //Print all pantone_values
        JsonPath json = response.jsonPath();
        List<String> pantoneValues =json.getList("data.pantone_value");
        System.out.println(pantoneValues);

        //Print all ids greater than 3 on the console
        List<Integer> idList= json.getList("data.id");
        List<Integer> idGreaterThan3 = new ArrayList<Integer>();
        for (Integer id: idList) {
            if(id>3){
                System.out.println("all ids greater than 3: " + id);
                idGreaterThan3.add(id);
            }
        }

        // Assert that there are 3 ids greater than 3
        int sayac=0;
        for (Integer id: idGreaterThan3) {
                       if(id>3){
                sayac++;
            }
        }
        assertTrue(sayac==3);

        //Print all names whose ids are less than 3 on the console
        ArrayList<Object> list= (ArrayList<Object>) json.getList("data");
        List<String> isimler=new ArrayList<>();
        for (Object w:list){
            if(w.toString().contains("id=1")||w.toString().contains("id=2")){
                System.out.println("for ici: "+w.toString().substring(7,20));
               isimler.add(w.toString().substring(7,20));
            }
        }
        System.out.println(list);

//        Assert that the number of names whose ids are less than 3 is 2
//        (id'si 3'ten küçük 2 isim olduğunu doğrulayınız)
         sayac=0;
        for (String w: isimler){
            sayac++;
        }
        assertTrue(sayac==2);


    }
}
