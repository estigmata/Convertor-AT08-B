package org.fundacionjala.convertor.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AbstractLogger {
  private static AbstractLogger instance;
  private Logger logger;

  private AbstractLogger() {}

  public static AbstractLogger getInstance() {
    if (instance == null) {
      instance = new AbstractLogger();
    }

    return instance;
  }

  public void setLogger(final String className) {
    logger = LogManager.getLogger(className);
  }

  public void test() {
    logger.trace("Entering application.");
    logger.debug("Debug Message Logged !!!");
    logger.info("Info Message Logged !!!");
    logger.error("Error Message Logged !!!", new NullPointerException("NullError"));
  }
}
