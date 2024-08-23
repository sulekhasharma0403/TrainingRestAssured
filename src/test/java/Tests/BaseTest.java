package Tests;

import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {
    protected String baseUri;
    protected String apiKey;
    protected String apiToken;
    protected String createBoardFilePath;
    protected String createCardFilePath;
    protected String createLabelFilePath;
    protected String createListFilePath;
    protected String deleteBoardFilePath;
    protected String deleteCardFilePath;
    protected String deleteLabelFilePath;
    protected String getBoardFilePath;
    protected String getLabelFilePath;
    protected String updateBoardFilePath;
    protected String updateCardFilePath;
    protected String updateLabelFilePath;

    protected static String boardId;
    protected static String listId;
    protected static String cardId;
    protected static String labelId;

    @BeforeClass
    public void setup() {
        Properties prop = new Properties();
        Properties filePathProp = new Properties();
        try {
            FileInputStream input = new FileInputStream("src/test/resources/config.properties");
            prop.load(input);
            baseUri = prop.getProperty("baseUri");
            apiKey = prop.getProperty("apiKey");
            apiToken = prop.getProperty("apiToken");
            FileInputStream filePathInput = new FileInputStream("src/test/resources/testData/filePath.properties");
            filePathProp.load(filePathInput);
            createBoardFilePath = filePathProp.getProperty("createBoardFilePath");
            createCardFilePath = filePathProp.getProperty("createCardFilePath");
            createLabelFilePath = filePathProp.getProperty("createLabelFilePath");
            createListFilePath = filePathProp.getProperty("createListFilePath");
            deleteBoardFilePath = filePathProp.getProperty("deleteBoardFilePath");
            deleteCardFilePath = filePathProp.getProperty("deleteCardFilePath");
            deleteLabelFilePath = filePathProp.getProperty("deleteLabelFilePath");
            getBoardFilePath = filePathProp.getProperty("getBoardFilePath");
            getLabelFilePath = filePathProp.getProperty("getLabelFilePath");
            updateBoardFilePath = filePathProp.getProperty("updateBoardFilePath");
            updateCardFilePath = filePathProp.getProperty("updateCardFilePath");
            updateLabelFilePath = filePathProp.getProperty("updateLabelFilePath");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}