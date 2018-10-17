package org.fundacionjala.convertor;

import org.fundacionjala.convertor.utils.AbstractLogger;

import java.util.logging.SimpleFormatter;

import static java.util.logging.Level.FINER;

public class Main {
  public static void main(String[] args) {
    AbstractLogger myLogger = AbstractLogger.getInstance();
    myLogger.setFormatter(new SimpleFormatter());
    myLogger.setPath("C:/Temp");
    myLogger.setFilename("converter.log");
    myLogger.setClass(Main.class.getName());
    myLogger.setLogger();
    myLogger.setLevel(FINER);
    System.out.print("Hello comrades!");
    myLogger.logMessage("The app show 'Hello comrades!'");
  }
}
