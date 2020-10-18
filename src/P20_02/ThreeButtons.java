package P20_02;

import javax.swing.JFrame;
import java.awt.*;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.*;

public class ThreeButtons extends JFrame {
    private static final int FRAME_WIDTH = 400;
    private static final int FRAME_HEIGHT = 400;

    private JButton redButton;
    private JButton greenButton;
    private JButton blueButton;
    private JPanel colorPanel;

    public ThreeButtons() {
        colorPanel = new JPanel();
        add(colorPanel, BorderLayout.CENTER);
        createThreeButtonsPanel();
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
    }

    public void createThreeButtonsPanel() {
        colorPanel.setBackground(Color.WHITE);

        redButton = new JButton("Red");
        redButton.addActionListener(e -> colorPanel.setBackground(Color.RED));

        greenButton = new JButton("Green");
        greenButton.addActionListener(e -> colorPanel.setBackground(Color.GREEN));

        blueButton = new JButton("Blue");
        blueButton.addActionListener(e -> colorPanel.setBackground(Color.BLUE));

        JPanel threeButtonsPanel = new JPanel();
        threeButtonsPanel.setLayout(new GridLayout(1, 3));
        threeButtonsPanel.add(redButton);
        threeButtonsPanel.add(greenButton);
        threeButtonsPanel.add(blueButton);
        add(threeButtonsPanel, BorderLayout.SOUTH);
    }

}

//    Write an application with three buttons labeled “Red”, “Green”, and “Blue” that
//        changes the background color of a panel in the center of the frame to red, green,
//        or blue.