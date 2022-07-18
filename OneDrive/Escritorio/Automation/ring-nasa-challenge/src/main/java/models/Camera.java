package models;



import Base.Base;
import emuns.CuriosityCameras;

import java.util.List;

/**
 * Camera class.
 */
public class Camera extends Base {

  private long id;
  private String name;
  private long rover_id;
  private String full_name;

  public Camera() {}

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public long getRoverId() {
    return rover_id;
  }

  public void setRoverId(long roverId) {
    this.rover_id = roverId;
  }

  public String getFullName() {
    return full_name;
  }

  public void setFullName(String fullName) {
    this.full_name = fullName;
  }

  /**
   * Checks if the object is not null
   * @param object object to check
   * @return true if the objects is not null, false otherwise
   */
  public Boolean hasObject(Object object){
    logger.debug("Checks if the object is not null");
    return object != null && object.getClass() != this.getClass();
  }

  /**
   * Checks if the camara has id
   * @param camera camera to check
   * @return true if the camera is not null, false otherwise
   */
  public Boolean hasCameraId(Camera camera){
    logger.debug("Checks if the camara has id");
    return this.id != camera.id;
  }

  /**
   * Checks if the camara has name.
   * @param camera camera to check
   * @return true if the camera is not null, false otherwise
   */
  public Boolean hasCameraName(Camera camera) {
    logger.debug("Checks if the camara has name");
    return this.name.equalsIgnoreCase(camera.name);
  }

  /**
   * Checks if the camara Rover has id
   * @param camera camera to check
   * @return true if the camera is not null, false otherwise
   */
  public Boolean hasCameraRoverId(Camera camera) {
    logger.debug("Checks if the camara Rover has id");
    return this.rover_id == camera.rover_id;
  }

  /** Checks if the camara has full name
   * @param camera camera to check
   * @return true if the camera is not null, false otherwise
   */
  public Boolean hasCameraFullName(Camera camera) {
    logger.debug("Checks if the camara has full name");
    return this.full_name.equalsIgnoreCase(camera.full_name);
  }

  /**
   * Checks if the photo of each camera are equals
   * @param allPhotos, cameraNames
   * @return true if the camera is not null, false otherwise
   */
  public Boolean validatePhotosTakenByEachCamera(List allPhotos, List cameraNames) {
    int photo1 = 0;
    int photo2 = 0;
    logger.info("Checks if the photo of each camera are equals");
    for (int i = 0; i < allPhotos.size(); i++) {
      photo1 = (int) allPhotos.get(i);
      CuriosityCameras cam1 = (CuriosityCameras) cameraNames.get(i);
      if (photo1 == 0) {
        logger.debug("0 photos taken by = {} cam", cam1);
        continue;
      }
      for (int j = i + 1; j < allPhotos.size(); j++) {
        photo2 = (int) allPhotos.get(j);
        CuriosityCameras cam2 = (CuriosityCameras) cameraNames.get(j);
        if (photo2 == 0) {
          logger.debug("0 photos taken by = {} cam", cam2);
          continue;
        }
      }
    }
    return photo1 <= (photo2 * 10) && photo2 <= (photo1 * 10);
  }

  @Override
  public boolean equals(Object object){
    Camera camera = (Camera) object;
    try {
      hasObject(object);
      logger.debug("Has object");
      hasCameraId(camera);
      logger.debug("Has camara ID");
      hasCameraName(camera);
      logger.debug("Has camara ID");
      hasCameraRoverId(camera);
      logger.debug("Has Rover ID");
      hasCameraFullName(camera);
      logger.debug("Has camara full name");
    } catch (Exception e) {
      return false;
    }

    return true;
  }


}
