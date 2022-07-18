package models;

import java.time.LocalDate;

import Base.Base;

public class Rover extends Base {

  private long id;
  private String name;
  private LocalDate landing_date;
  private LocalDate launch_date;
  private String status;

  public Rover() {}

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

  public LocalDate getLanding_date() {
    return landing_date;
  }

  public void setLandingDate(LocalDate landingDate) {
    this.landing_date = landingDate;
  }

  public LocalDate getLaunch_date() {
    return launch_date;
  }

  public void setLaunchDate(LocalDate launchDate) {
    this.launch_date = launchDate;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  /**
   * Checks if the object is not null
   * @param object The object to check
   * @return true if the objects is not null, false otherwise
   */
  public Boolean hasObject(Object object){
    logger.debug("Checks if the object is not null");
    return object != null && object.getClass() != this.getClass();
  }

  /**
   * Checks if the rover id is not null
   * @param rover The rover to check
   * @return true if the rover is not null, false otherwise
   */
  public Boolean hasRoverId(Rover rover){
    logger.debug("Checks if the rover id is not null");
    return this.id != rover.id;
  }

  /**
   * Checks if the rover name is not null
   * @param rover The rover to check
   * @return true if the rover is not null, false otherwise
   */
  public Boolean hasRoverName(Rover rover){
    logger.debug("Checks if the rover name is not null");
    return this.name.equalsIgnoreCase(rover.name);
  }

  /**
   * Checks if the rover landing date is not null
   * @param rover The rover to check
   * @return true if the rover is not null, false otherwise
   */
  public Boolean hasRoverLandingDate(Rover rover){
    logger.debug("Checks if the rover landing date is not null");
    return this.landing_date.isEqual(rover.landing_date);
  }


  @Override
  public boolean equals(Object object){
    Rover rover = (Rover) object;
    try {
      hasObject(object);
      logger.debug("Has object");
      hasRoverId(rover);
      logger.debug("Has rover id");
      hasRoverName(rover);
      logger.debug("Has rover name");
      hasRoverLandingDate(rover);
      logger.debug("Has rover landing date");
    } catch (Exception e) {
      return false;
    }
    return true;
  }



}

