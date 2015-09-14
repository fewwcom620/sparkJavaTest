package controller.user;

import com.google.gson.Gson;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import spark.Spark;
import spark.utils.IOUtils;
import sun.applet.Main;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by steve on 2015/9/14.
 */
public class UserControllerTest {

//    @BeforeClass
//    public static void beforeClass() {
//        CRUD.main(null);
//    }
//
//    @AfterClass
//    public static void afterClass() {
//        Spark.stop();
//    }

    @Test
    public void testANewUserShouldBeCreated() throws Exception {
        Thread.sleep(3000);
        TestResponse response =  request("POST", "/users?name=regina&email=regina@test.com");
        assertNotNull(response);
        Map<String, String> json = response.json();
        assertEquals("regina", json.get("name"));
        assertEquals("regina@test.com", json.get("email"));
        assertNotNull(json.get("id"));

    }

    private TestResponse request(String method, String path) {
        try {
            URL url = new URL("http://127.0.0.1:4567" + path);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod(method);
            connection.setDoOutput(true);
            connection.connect();
            String body = IOUtils.toString(connection.getInputStream());
            return new TestResponse(connection.getResponseCode(), body);
        } catch (IOException e) {
            e.printStackTrace();
            fail("Sending request failed: " + e.getMessage());
            return null;
        }
    }

    private static class TestResponse {

        public final String body;
        public final int status;

        public TestResponse(int status, String body) {
            this.status = status;
            this.body = body;
        }

        public Map<String,String> json() {
            return new Gson().fromJson(body, HashMap.class);
        }
    }
}