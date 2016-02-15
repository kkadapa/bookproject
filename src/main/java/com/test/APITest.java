package com.test;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.imageview.App;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by karthik on 2/13/16.
 */
public class APITest {

    @Test
    public void testAPI() {

        App app = new App();
        String string = app.getTextData("Project");

        JsonParser jsonParser = new JsonParser();
        JsonObject jsonObject = (JsonObject) jsonParser.parse(string);

        assertEquals(1,jsonObject.get("sameValueCount").getAsInt());
        assertEquals(4609,jsonObject.get("wordOccurenceInFiles").getAsInt());
    }
}
