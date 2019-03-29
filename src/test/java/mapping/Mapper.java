package mapping;

import base.BaseTest;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Set;

public class Mapper {

    private static final String BASE_PATH="mapJSON/";
    private static final String BASE_EXTENSION=".json";
    protected static final Logger log= Logger.getLogger(Mapper.class);

    private static JsonObject readJSON(MapMethodType eventActivity, String elementFound) {
        Gson gson= new Gson();
        JsonElement jsonObject = null;
        FileReader reader = null;
        JsonObject jsonElement = null;
        JsonArray jsonArray=null;
        JsonObject jp = null;
        JsonObject foundElement = null;
        try{
            reader = new FileReader(BASE_PATH + eventActivity.getValue() + BASE_EXTENSION);
            jsonObject = gson.fromJson(reader, JsonElement.class);
            jsonElement= jsonObject.getAsJsonObject();
            jp = jsonElement.getAsJsonObject(clearTurkishCharsAndUpperCase(elementFound));
            jp = jp.getAsJsonObject(BaseTest.capabilities.getCapability("platformName").toString().toUpperCase());
            foundElement = jp;

        }catch(FileNotFoundException e){
            log.error(e.getMessage(), e);
            Assert.fail(e.getMessage());
        }  finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    log.error(e.getMessage(), e);
                }
            }
        }
        return foundElement;
    }

        public static By foundActivity(MapMethodType eventActivity, String elementFound) {
            Set<Entry<String, JsonElement>> entries = null;
            try {
                entries = readJSON(eventActivity, elementFound).entrySet();
            } catch (NullPointerException e) {
                e.printStackTrace();
                log.error(elementFound + " is not found in "+eventActivity.getValue() +" file for "+BaseTest.capabilities.getCapability("platformName").toString().toUpperCase());
                Assert.fail(elementFound + " is not found in "+eventActivity.getValue() +" file for "+BaseTest.capabilities.getCapability("platformName").toString().toUpperCase());
            }
            By by = null;
            for (Entry<String, JsonElement> entry : entries) {
                if(!(entry.getKey().equals("X")) & !(entry.getKey().equals("Y"))) {
                    by = generateByElement(entry.getKey(), entry.getValue().getAsString());
                }
            }
            return by;
        }

        static By generateByElement(String byType, String byValue) {
            By byElement = null;
            if (byType.contains(MapValue.ID.getText())) {
                byElement = By.id(byValue);
            } else if (byType.contains(MapValue.CLASSNAME.getText())) {
                byElement = By.className(byValue);
            } else if (byType.contains(MapValue.CSSSELECTOR.getText())) {
                byElement = By.cssSelector(byValue);
            } else if (byType.contains(MapValue.XPATH.getText())) {
                byElement = By.xpath(byValue);
            } else if (byType.contains(MapValue.CONTAINS.getText())) {
                byElement = By.xpath("//*[contains(@id, '" + byValue + "')]");
            } else {
                Assert.fail("No such selector.");
            }
            return byElement;
        }

        private static String clearTurkishCharsAndUpperCase(String str){

                String returnStr = str;
                char[] turkishChars = new char[]{0x131, 0x130, 0xFC, 0xDC, 0xF6, 0xD6, 0x15F, 0x15E, 0xE7, 0xC7, 0x11F,
                    0x11E};
                char[] englishChars = new char[]{'i', 'I', 'u', 'U', 'o', 'O', 's', 'S', 'c', 'C', 'g', 'G'};
                for (int i = 0; i < turkishChars.length; i++) {
                returnStr = returnStr.replaceAll(new String(new char[]{turkishChars[i]}),
                        new String(new char[]{englishChars[i]}));
                }
            return returnStr.toUpperCase(Locale.ENGLISH);
        }
}