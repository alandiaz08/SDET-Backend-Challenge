package utils;

import java.io.FileInputStream;
import java.io.IOException;

public class Properties {

  public static final String TEST_PROPERTIES_FILE = "src/resources/test.properties";

  public Properties() {
  }

  /**
   * Loads properties file.
   * @param property
   */
  public static String readProperty(String property){
    java.util.Properties properties = new java.util.Properties();
    try(FileInputStream fileInputStream = new FileInputStream(TEST_PROPERTIES_FILE)){
      properties.load(fileInputStream);
      return properties.getProperty(property);
    }catch (IOException ioException){
      System.err.println("Error loading properties file: " + TEST_PROPERTIES_FILE);
    }
    return null;
  }

}
