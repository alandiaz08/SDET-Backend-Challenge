import api.NasaApi;
import org.junit.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.Properties;

public class TestBase {
  protected static final Logger logger = LoggerFactory.getLogger(TestBase.class);
  protected static final NasaApi nasaAPIClient = new NasaApi(Properties
          .readProperty( "nasa_api_url"), Properties.readProperty("api_key"));

  @Before
  public void setup(){
    logger.info("Setup");
  }

}
