package org.fundacionjala.convertor.view;

import org.fundacionjala.convertor.model.FileModel;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.io.Console;
import java.util.List;

public class FilePanel extends JPanel {
  private JPanel filesContainer;
  private GridBagConstraints gbConstraints;
  private List<String> files;
  private FileModel fileModel;

  public FilePanel() {
    setLayout(new BorderLayout());
    filesContainer = new JPanel(new GridBagLayout());
    GridBagConstraints gridBagConstraints = new GridBagConstraints();
    gridBagConstraints.gridwidth = GridBagConstraints.REMAINDER;
    gridBagConstraints.weightx = 1;
    gridBagConstraints.weighty = 1;
    filesContainer.add(new JPanel(), gridBagConstraints);
    setPreferredSize(new Dimension(720, 350));
    add(new JScrollPane(filesContainer));
    fileModel = new FileModel();
  }

  public void displayFiles() {
    GridBagConstraints gbConstraints = new GridBagConstraints();
    gbConstraints.gridwidth = GridBagConstraints.REMAINDER;
    gbConstraints.weightx = 1;
    gbConstraints.fill = GridBagConstraints.HORIZONTAL;
    for (String file : files = fileModel.getFiles()) {
      JPanel panel = new JPanel();
      panel.add(new JLabel(file));
      panel.setBorder(new MatteBorder(0, 0, 1, 0, Color.GRAY));
      filesContainer.add(panel, gbConstraints, 0);
    }
    validate();
    repaint();
  }
}
