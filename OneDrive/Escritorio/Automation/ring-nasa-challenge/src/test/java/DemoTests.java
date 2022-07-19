import models.Camera;
import emuns.CuriosityCameras;
import models.MarsRoverPhoto;
import models.MarsRoverPhotoResponse;
import org.junit.Assert;
import org.testng.annotations.Test;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class DemoTests extends TestBase{
  private final Long sol = 1000L;
  private final LocalDate earthDateFor1000Sol = LocalDate.of(2015, 5,30);

  @Test(groups = "DemoTests",
        enabled = true
        )
  public void firstTenPhotosOnSol1000(){
    MarsRoverPhoto picsLength = new MarsRoverPhoto();
    MarsRoverPhotoResponse response = nasaAPIClient.getCuriosityPhotosBySol(sol);
    logger.info("Size of first Ten Pics array of sol");
    Assert.assertTrue(picsLength.isPicLengthEqualsToTen(response));
  }

  @Test(groups = "DemoTests",
        enabled = true
        )
  public void firstTenPhotosOnSol1000ByEarthDate(){
    MarsRoverPhoto picsLength = new MarsRoverPhoto();
    MarsRoverPhotoResponse response = nasaAPIClient.getCuriosityPhotosByEarthDate(earthDateFor1000Sol);
    logger.info("Size of first Ten Pics array of earth date for 1000 sol");
    Assert.assertTrue(picsLength.isPicLengthEqualsToTen(response));
  }

  @Test(groups = "DemoTests",
        enabled = true
  )
  public void photosTakenOnSol1000BySolAndByEarthDate(){
    MarsRoverPhoto marsRoverPhoto = new MarsRoverPhoto();
    MarsRoverPhotoResponse solResp = nasaAPIClient.getCuriosityPhotosBySol(sol);
    MarsRoverPhoto[] firstTenSolPics = marsRoverPhoto.getPhotos(solResp);

    MarsRoverPhotoResponse earthDateResp = nasaAPIClient.getCuriosityPhotosByEarthDate(earthDateFor1000Sol);
    MarsRoverPhoto[] earthDatePhotos = earthDateResp.getPhotos();
    Arrays.sort(earthDatePhotos, Comparator.comparing(MarsRoverPhoto::getId));
    MarsRoverPhoto[] firstTenEarthDatePics = marsRoverPhoto.getPhotos(solResp);

    for(int i = 0; i < firstTenSolPics.length; i++){
      logger.info("Photo Id queried by sol = {} , Photo Id queried by Earth date = {} ",
              firstTenSolPics[i].getId(), firstTenEarthDatePics[i].getId());
      Assert.assertTrue(firstTenSolPics[i].equals(firstTenEarthDatePics[i]));
    }
  }

  @Test(groups = "DemoTests",
        enabled = true
  )
  public void numberOfPhotosTakenByEachCameraOfTheCuriosity(){
    Camera camera = new Camera();
    List<Integer> allPhotos = new ArrayList<>();
    List<CuriosityCameras> cameraNames = new ArrayList<>();
    CuriosityCameras[] cameras = CuriosityCameras.values();

    for(CuriosityCameras cam : cameras){
      allPhotos.add(nasaAPIClient.getCuriosityPhotosBySolAndCamera(sol, cam).getPhotos().length);
      cameraNames.add(cam);
    }

    //logger.info("{} photos taken by = {} cam, {} photos taken by = {} cam", photo1, cam1,  photo2, cam2);
    Assert.assertTrue(camera.validatePhotosTakenByEachCamera(allPhotos, cameraNames));

  }
}
