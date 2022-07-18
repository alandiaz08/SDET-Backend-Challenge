package models;

import Base.Base;

/**
 * MarsRoverPhotoResponse class.
 */
public class MarsRoverPhotoResponse extends Base {

  private MarsRoverPhoto[] photos;

  public MarsRoverPhotoResponse() {

  }

  /**
   * gets the photos.
   */
  public MarsRoverPhoto[] getPhotos() {
    return photos;
  }

  /**
   * sets the photos.
   */
  public void setPhotos(MarsRoverPhoto[] photos) {
    logger.info("Set photos: " + photos);
    this.photos = photos;
  }
}