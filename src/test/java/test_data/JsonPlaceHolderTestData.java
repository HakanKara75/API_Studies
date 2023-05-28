package test_data;

import java.util.HashMap;
import java.util.Map;

public class JsonPlaceHolderTestData {

    public Map<String, Object> expectedDataMap(int userId, String title, boolean completed) {

      Map<String, Object> expectedData = new HashMap<>(); //serialization java to json
        expectedData.put("userId", userId );
        expectedData.put("title", title);
        expectedData.put("completed", completed);
        System.out.println("expectedData"+ expectedData);
        return expectedData;
}
    public Map<String, Object> reqresexpectedDataMap(int id, String name, int year, String color,String pantone_value) {

        Map<String, Object> expectedData = new HashMap<>(); //serialization java to json
        expectedData.put("id", id );
        expectedData.put("name", name);
        expectedData.put("year", year);
        expectedData.put("color", color);
        expectedData.put("pantone_value", pantone_value);
        System.out.println("expectedData"+ expectedData);
        return expectedData;
    }

    public Map<String, String> supportMapMethod(String url, String text) {
        Map<String, String> bookingdatesMap= new HashMap<>();
        bookingdatesMap.put("url", url);
        bookingdatesMap.put("text", text);
        return bookingdatesMap;
    }

    public Map<String, Object> usersexpectedDataMap(int id, String email, String firstname, String lastname, String avatar) {

        Map<String, Object> expectedData = new HashMap<>(); //serialization java to json
        expectedData.put("id", id );
        expectedData.put("email", email);
        expectedData.put("firstname", firstname);
        expectedData.put("lastname", lastname);
        expectedData.put("avatar", avatar);
        System.out.println("expectedData"+ expectedData);
        return expectedData;
    }
 }