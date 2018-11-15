/**
 * @BasicConverterPanel.java Copyright (c) 2018 Fundacion Jala. All rights reserved.
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
 */
package org.fundacionjala.convertor.view.Converter;

import net.bramp.ffmpeg.FFmpeg;
import net.bramp.ffmpeg.FFmpegExecutor;
import net.bramp.ffmpeg.FFprobe;
import net.bramp.ffmpeg.builder.FFmpegBuilder;
import org.fundacionjala.convertor.view.BrowseChooser;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Class FinderPanel.
 *
 * @author Abel Mallcu Chiri.
 * @author Nestor Otondo.
 * @version 1.0
 */
public class BasicConverterPanel extends JPanel {

  private JButton btnConverter;
  private static JTextField outputPath;
  private JTextField outputFileName;
  private static JTextField currentPath;
  private static String fileToConvert;
  private BrowseChooser browseChooser;
  protected JComboBox<String> multimediaBox;
  private JLabel labelOutPath;
  private JLabel labelOutputName;
  private JLabel labelCurrentPath;
  private JLabel labelMultimediaBox;

  /**
   * Constructor.
   */
  public BasicConverterPanel() {

    outputPath = new JTextField("");
    btnConverter = new JButton("Converter");
    outputFileName = new JTextField();
    currentPath = new JTextField();
    this.setVisible(true);
    browseChooser = new BrowseChooser();
    browseChooser.setPath(outputPath);
    multimediaBox = new JComboBox<>(new String[]{"Video", "Audio"});
    labelOutPath = new JLabel("Destination Path :");
    labelOutputName = new JLabel("Output File Name :");
    labelCurrentPath = new JLabel("Current Path :");
    labelMultimediaBox = new JLabel("Multimedia :");

    initComponents();
  }

  /**
   * Initialization of Components.
   */
  public void initComponents() {
    final int four = 4;
    final int tree = 3;
    final int one = 1;
    final int two = 2;
    final int six = 6;
    TitledBorder title = BorderFactory.createTitledBorder("Output Setting");
    this.setBorder(title);
    this.setLayout(new GridBagLayout());
    GridBagConstraints bagConstraints = new GridBagConstraints();
    bagConstraints.fill = GridBagConstraints.HORIZONTAL;

    bagConstraints.gridx = 0;
    bagConstraints.gridy = 0;
    labelOutputName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    this.add(labelOutputName, bagConstraints);
    bagConstraints.gridx = one;
    bagConstraints.gridy = 0;
    this.add(outputFileName, bagConstraints);

    bagConstraints.gridx = 0;
    bagConstraints.gridy = one;
    labelCurrentPath.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    this.add(labelCurrentPath, bagConstraints);
    bagConstraints.gridx = one;
    bagConstraints.gridy = one;
    this.add(currentPath, bagConstraints);


    bagConstraints.gridx = 0;
    bagConstraints.gridy = tree;
    labelOutPath.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    this.add(labelOutPath, bagConstraints);
    bagConstraints.gridx = one;
    bagConstraints.gridy = tree;
    this.add(outputPath, bagConstraints);
    bagConstraints.gridx = two;
    bagConstraints.gridy = tree;
    this.add(browseChooser, bagConstraints);


    bagConstraints.gridx = 0;
    bagConstraints.gridy = four;
    labelMultimediaBox.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    this.add(labelMultimediaBox, bagConstraints);
    bagConstraints.gridx = one;
    bagConstraints.gridy = four;
    this.add(multimediaBox, bagConstraints);

    bagConstraints.gridx = one;

    bagConstraints.gridy = six;

    btnConverter.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent e) {
        //converterFile();
      }
    });
    this.add(btnConverter, bagConstraints);
  }

  /**
   * @return .
   */
  public JButton getConverterButton() {
    return btnConverter;
  }

  /**
   * @return .
   */
  public JTextField getOutputPath() {
    return outputPath;
  }

  /**
   * @return .
   */
  public JTextField getOutputName() {
    return outputFileName;
  }

  /**
   * @return .
   */
  public JTextField getCurrentPath() {
    return currentPath;
  }

  /**
   * @return .
   */
  public BrowseChooser getBrowseChooser() {
    return browseChooser;
  }

  /**
   * @return .
   */
  public JComboBox<String> getMultimediaBox() {
    return multimediaBox;
  }

  public static void setFileToConvert(final String fileName) {
    fileToConvert = fileName;
  }

  public static void setPathSource(final String pathSource) {
    currentPath.setText(pathSource);
  }

  public static void setPathDestination(final String pathDestination) {
    outputPath.setText(pathDestination);
  }

  public static String getFileToConvert() {
    return fileToConvert;
  }

  private void converterFile() {
    //TODO
  }
}
