package api;

import Base.Base;
import emuns.CuriosityCameras;
import models.MarsRoverPhotoResponse;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;


/**
 * This class class handles all the requests made to the Nasa public API.
 */
public class NasaApi extends Base {

  public NasaApi(String apiUrl, String apiKey) {
    this.nasaApiUrl = apiUrl;
    this.apiKeyValue = apiKey;
  }

  private final String nasaApiUrl;

  private final String apiKeyValue;

  private static final String CURIOSITY_PHOTOS_PATH = "rovers/curiosity/photos";

  private static final String API_KEY = "api_key=";


  public static final String SOL_VALUE = "?sol=";

  public static final String AND = "&";

  /**
   * Gets curiosity photos by sol.
   * @param sol the sol
   */
  public MarsRoverPhotoResponse getCuriosityPhotosBySol(long sol) {
    String params = SOL_VALUE + sol + AND;
    RestTemplate restTemplate = new RestTemplate();
    logger.debug("Getting curiosity photos by sol: " + sol);
    return restTemplate.getForObject(nasaApiUrl + CURIOSITY_PHOTOS_PATH + params + API_KEY
                    + apiKeyValue, MarsRoverPhotoResponse.class);
  }

  /**
   * Gets curiosity photos by earth date.
   * @param earthDate the earth date
   */
  public MarsRoverPhotoResponse getCuriosityPhotosByEarthDate(LocalDate earthDate){
    String params = "?earth_date=";
    RestTemplate restTemplate = new RestTemplate();
    logger.debug("Getting curiosity photos by earth date: " + earthDate);
    return restTemplate.getForObject(nasaApiUrl + CURIOSITY_PHOTOS_PATH + params + earthDate + AND
            + API_KEY + apiKeyValue, MarsRoverPhotoResponse.class);
  }

  /**
   * Gets curiosity photos by sol and camera.
   * @param sol the sol
   * @param camera the camera
   */
  public MarsRoverPhotoResponse getCuriosityPhotosBySolAndCamera(long sol, CuriosityCameras camera) {
    String cameraValue = "&camera=";
    String params = SOL_VALUE + sol + cameraValue + camera.name().toLowerCase();
    logger.debug("Getting curiosity photos by sol and camera: " + sol + " " + camera);
    RestTemplate restTemplate = new RestTemplate();
    return restTemplate.getForObject(nasaApiUrl + CURIOSITY_PHOTOS_PATH + params + AND + API_KEY
                    + apiKeyValue, MarsRoverPhotoResponse.class);
  }

}
