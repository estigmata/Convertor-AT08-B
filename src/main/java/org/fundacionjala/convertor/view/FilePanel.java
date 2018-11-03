package org.fundacionjala.convertor.view;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;

public class FilePanel extends JPanel {
  private JPanel filesContainer;

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
    /***/
    JPanel panel = new JPanel();
    panel.add(new JLabel("Hello"));
    panel.setBorder(new MatteBorder(0, 0, 1, 0, Color.GRAY));
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.gridwidth = GridBagConstraints.REMAINDER;
    gbc.weightx = 1;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    filesContainer.add(panel, gbc, 0);
    /***/
    JPanel panel1 = new JPanel();
    panel1.add(new JLabel("Hello"));
    panel1.setBorder(new MatteBorder(0, 0, 1, 0, Color.GRAY));
    filesContainer.add(panel1, gbc, 0);
    /***/
    JPanel panel2 = new JPanel();
    panel2.add(new JLabel("Hello"));
    panel2.setBorder(new MatteBorder(0, 0, 1, 0, Color.GRAY));
    filesContainer.add(panel2, gbc, 0);
    validate();
    repaint();
  }
}
