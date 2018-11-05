/**
 *
 * @(#)FilesPanel.java Copyright (c) 2018 Fundacion Jala. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * Please contact Fundacion Jala, 2643 Av Melchor Perez de Olguin, Colquiri
 * Sud, Cochabamba, Bolivia. www.fundacion-jala.org if you need additional
 * information or have any questions.
 *
 */

package org.fundacionjala.convertor.view;

import org.fundacionjala.convertor.model.FileModel;
import org.fundacionjala.convertor.model.objectfile.Asset;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.util.ArrayList;

/**
 *
 * Class Files Panel in order to show files detail list.
 *
 * @author Nestor Otondo [nestor.otondo@fundacion-jala.org]
 * @version 1.0
 *
 */

public class FilesPanel extends JPanel {
  private JPanel filesContainer;
  private GridBagConstraints gbConstraints;
  private JPanel buttonsContainer;
  private FileModel files;

  /**
   * Constructor Files Panel class.
   */
  public FilesPanel() {
    setLayout(new BorderLayout());
    filesContainer = new JPanel(new GridBagLayout());
    GridBagConstraints gridBagConstraints = new GridBagConstraints();
    gridBagConstraints.gridwidth = GridBagConstraints.REMAINDER;
    gridBagConstraints.weightx = 1;
    gridBagConstraints.weighty = 1;
    filesContainer.add(new JPanel(), gridBagConstraints);
    setPreferredSize(new Dimension(620, 350));
    add(new JScrollPane(filesContainer));
    files = new FileModel();
  }

  /**
   * Display files method to build panels dynamically.
   */
  public void displayFiles() {
    GridBagConstraints gbConstraints = new GridBagConstraints();
    gbConstraints.gridwidth = GridBagConstraints.REMAINDER;
    gbConstraints.weightx = 1;
    gbConstraints.fill = GridBagConstraints.HORIZONTAL;
    for (String file : files.getFiles()) {
      JPanel panel = new JPanel();
      panel.setBorder(BorderFactory
          .createMatteBorder(1, 5, 1, 1, Color.red));
      panel.add(new JLabel(file));
      JPanel btnPanel = new JPanel();
      btnPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
      btnPanel.add(new JButton("[Play]"));
      btnPanel.add(new JButton("[Converter]"));
      panel.add(btnPanel);
      panel.setBorder(new MatteBorder(0, 0, 1, 0, Color.GRAY));
      filesContainer.add(panel, gbConstraints, 0);
    }
    validate();
    repaint();
  }
}
