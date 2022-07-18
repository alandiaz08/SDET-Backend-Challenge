package emuns;

public enum CuriosityCameras {
  CHEMCAM("CHEMCAM"),
  FHAZ("FHAZ"),
  MARDI("MARDI"),
  RHAZ("RHAZ"),
  MAST("MAST"),
  MAHLI("MAHLI"),
  NAVCAM("NAVCAM");

  private final String value;

  @SuppressWarnings("unused")
  CuriosityCameras(String value){
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return super.toString();
  }

}

