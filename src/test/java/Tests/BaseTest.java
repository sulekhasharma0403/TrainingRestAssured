package Tests;

import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {
    protected String apiKey;
    protected String apiToken;
    protected static String boardId;

    @BeforeClass
    public void setup() {
        Properties prop = new Properties();
        try {
            FileInputStream input = new FileInputStream("src/test/resources/config.properties");
            prop.load(input);
            apiKey = prop.getProperty("apiKey");
            apiToken = prop.getProperty("apiToken");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}