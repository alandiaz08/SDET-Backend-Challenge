package Base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Base class.
 */
public class Base {

  public static Logger logger;

  /**
   * Constructor.
   */
  public Base() {
    logger = LoggerFactory.getLogger(getClass());
  }
}
