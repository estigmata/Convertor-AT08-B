package org.fundacionjala.convertor.model;

import java.util.ArrayList;
import java.util.List;

public class FileModel {
  private List<String> files;

  public FileModel() {
    files = new ArrayList<>();
  }

  public List<String> getFiles() {
    files.add("Test.pm4");
    files.add("Terminator.mp4");
    files.add("CleanCode.pm4");

    return files;
  }
}
