package org.fundacionjala.convertor.utils;

import java.io.IOException;
import java.util.StringJoiner;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AbstractLoggerX {
  private static AbstractLoggerX instance;
  private Logger log;
  private FileHandler file;
  protected String path;
  protected Formatter formatter;
  protected String className;

  private AbstractLoggerX() {}

  @Override
  public void finalize() {
    log.exiting(className, "Do it.");
  }

  public static AbstractLoggerX getInstance() {
    if (instance == null) {
      instance = new AbstractLoggerX();
    }

    return instance;
  }

  public void setClass(final String className) {
    this.className = className;
  }

  public void setLogger() {
    log = Logger.getLogger("");
    log.setUseParentHandlers(false);
    log.entering(className, "Do it.");
  }

  public void setLevel(final Level level) {
    log.setLevel(level);
  }

  public void setPath(final String path) {
    this.path = path;
  }

  public void setFormatter(final Formatter formatter) {
    this.formatter = formatter;
  }

  public void setFilename(final String filename) {
    if (file == null) {
      try {
        file = new FileHandler(new StringJoiner("/").add(path).add(filename).toString(), true);
        file.setFormatter(formatter);
      } catch (IOException e) {
        log.warning(new StringBuilder().append("File cannot be created.").append(e.getMessage()).toString());
      }
    }
  }

  //abstract method
  public void logMessage(final String message) {
    log.info(message);
  }
}
