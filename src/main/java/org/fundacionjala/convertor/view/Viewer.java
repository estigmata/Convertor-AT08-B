package org.fundacionjala.convertor.view;

import javax.swing.*;
import java.awt.*;

public class Viewer extends JFrame {
    private JLabel title;
    private JPanel leftPanel;
    private JPanel rightPanel;

    private Viewer() {
        super();
        configWindow();

    }

    private void configWindow() {
        this.setTitle("View Window");
        this.setSize(500, 500);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initComponents() {
        leftPanel.setBounds(1, 1, 100, 100);
        rightPanel.setBounds(101, 1, 100, 100);
        leftPanel.setToolTipText("LEFT");
        rightPanel.setToolTipText("RIGHT");
    }

    public static void main(String[] args) {
        Viewer viewer = new Viewer();
        viewer.setVisible(true);
    }
}
