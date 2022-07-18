package models;

import Base.Base;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Mars rover photo class
 */
public class MarsRoverPhoto extends Base {

  private Long id;
  private Long sol;
  private Camera camera;
  private String img_src;
  private LocalDate earth_date;
  private Rover rover;

  public MarsRoverPhoto() {
  }

  public Long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public int getSol() {
    return Math.toIntExact(sol);
  }

  public void setSol(long sol) {
    this.sol = sol;
  }

  public Camera getCamera() {
    return camera;
  }

  public void setCamera(Camera camera) {
    this.camera = camera;
  }

  public String getImg_src() {
    return img_src;
  }

  public void setImg_src(String img_src) {
    this.img_src = img_src;
  }

  public LocalDate getEarth_date() {
    return earth_date;
  }

  public void setEarth_date(LocalDate earth_date) {
    this.earth_date = earth_date;
  }

  public Rover getRover() {
    return rover;
  }

  public void setRover(Rover rover) {
    this.rover = rover;
  }

  /**
   * Checks if the object is not null
   * @param object object to check
   * @return true if the objects is not null, false otherwise
   */
  public Boolean hasObject(Object object) {
    logger.debug("Checks if the object is not null");
    return object != null;
  }

  /**
   * Checks if Mars rover has photo
   * @param photo  photo to check
   * @return true if the photo is not null, false otherwise
   */
  public Boolean hasPhoto(MarsRoverPhoto photo) {
    logger.debug("Checks if Mars rover has photo");
    return this.id.equals(photo.id);
  }

  /** Checks if Mars rover has photo
   * @param sol sol to check
   * @return true if the sol is not null, false otherwise
   */
  public Boolean hasSol(Long sol) {
    logger.debug("Checks if Mars rover has photo");
    return this.sol.equals(sol);
  }

  /**
   * Checks if Mars rover has camara
   * @param camera camera to check
   * @return true if the camera is not null, false otherwise
   */
  public Boolean hasCamera(Camera camera) {
    logger.debug("Checks if Mars rover has camara");
    return this.camera.equals(camera);
  }

  /**
   * Checks if Mars rover has imgSrc
   * @param imgSrc imgSrc to check
   * @return true if the img_src is not null, false otherwise
   */
  public Boolean hasImgSrc(String imgSrc) {
    logger.debug("Checks if Mars rover has imgSrc");
    return this.img_src.equalsIgnoreCase(imgSrc);
  }

  /**
   * Checks earth date
   * @param earthDate earth date to check
   * @return true if the earth_date is not null, false otherwise
   */
  public Boolean hasEarthDate(LocalDate earthDate) {
    logger.debug("Checks earth date");
    return this.earth_date.isEqual(earthDate);
  }

  /**
   * Checks if Rover is present
   * @param rover rover to check
   * @return true if the rover is not null, false otherwise
   */
  public Boolean isRover(Rover rover) {
    logger.debug("Checks if Rover is present");
    return this.rover.equals(rover);
  }

  /**
   * Checks if the picture length is equals to 10
   * @param response response to check
   * @return true if the Pics is 10, false otherwise
   */
  public Boolean isPicLengthEqualsToTen(MarsRoverPhotoResponse response) {
    logger.debug("Checks if the picture length is equals to 10");
    int picsLength = getPhotos(response).length;
    return picsLength == 10;
  }

  /**
   * Gets Mars Rover photos
   * @param response response to get photos
   * @return Array of photos
   */
  public MarsRoverPhoto[] getPhotos(MarsRoverPhotoResponse response) {
    logger.debug("Gets Mars Rover photos");
    MarsRoverPhoto[] photos = response.getPhotos();
    Arrays.sort(photos, Comparator.comparing(MarsRoverPhoto::getId));
    return Arrays.copyOfRange(photos, 0, 10);
  }

  @Override
  public boolean equals(Object object) {
    MarsRoverPhoto photo = (MarsRoverPhoto) object;
    try {
      hasObject(object);
      logger.debug("Has Object");
      hasPhoto((MarsRoverPhoto) object);
      logger.debug("Has photo");
      hasSol(photo.sol);
      logger.debug("Has sol");
      hasCamera(photo.camera);
      logger.debug("Has camera");
      hasImgSrc(photo.img_src);
      logger.debug("Has imgSrc");
      hasEarthDate(photo.earth_date);
      logger.debug("Has earth date");
      isRover(photo.rover);
      logger.debug("Is rover displayed");
    } catch (Exception e) {
      return false;
    }
    return true;
  }
}