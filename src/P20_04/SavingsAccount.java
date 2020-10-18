package P20_04;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import java.lang.reflect.Array;
import java.util.*;

public class SavingsAccount extends JPanel implements ActionListener {

    static Graphics2D g2;
    private JLabel firstLabel, secondLabel, thirdLabel;
    private JTextField firstLabelInput, secondLabelInput, thirdLabelInput;
    private JTextArea calculateOutput;
    private JButton calculateButton;
    private String savingsAccountDescription = "";
    private JFrame f;
    private final int HEIGHT = 1000,WIDTH = 1000;
    private final int BAR_HEIGHT = 600, BAR_WIDTH = 600;
    private ArrayList<Double> allBalances = new ArrayList<>();
    private ArrayList<Double> scaledBalances = new ArrayList<>();
    private ArrayList<Rectangle> allBars = new ArrayList<>();
    private JPanel newPanel = new JPanel();

    SavingsAccount() {

        createGUI();

    }

    public void createGUI() {
        firstLabel = new JLabel("Initial Amount");
        firstLabel.setBounds(50, 50, 200, 20);

        firstLabelInput = new JTextField();
        firstLabelInput.setBounds(300, 50, 150, 20);

        secondLabel = new JLabel("Annual Percentage Yield (%)");
        secondLabel.setBounds(50, 100, 200, 20);
        secondLabelInput = new JTextField();
        secondLabelInput.setBounds(300, 100, 150, 20);

        thirdLabel = new JLabel("Years in savings account");
        thirdLabel.setBounds(50, 150, 200, 20);
        thirdLabelInput = new JTextField();
        thirdLabelInput.setBounds(300, 150, 150, 20);

        calculateOutput = new JTextArea();
        calculateOutput.setBounds(50, 250, 350, 600);

        calculateButton = new JButton("Calculate");
        calculateButton.setBounds(50, 200, 100, 50);
       calculateButton.addActionListener(this);

        add(firstLabel);
        add(firstLabelInput);

       add(secondLabel);
        add(secondLabelInput);

       add(thirdLabel);
        add(thirdLabelInput);

      add(calculateOutput);
      add(calculateButton);



    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String firstInput = firstLabelInput.getText();
        String secondInput = secondLabelInput.getText();
        String thirdInput = thirdLabelInput.getText();
        double initialAmount = Double.parseDouble(firstInput);
        double APY = Double.parseDouble(secondInput);
        APY /= 100;
        double years = Double.parseDouble(thirdInput);
        double balance = 0;

        if (e.getSource() == calculateButton && (years <= 25 && years > 0) && initialAmount > 0 && APY > 0) {
            savingsAccountDescription = "";
            savingsAccountDescription += ("     Balance after each Year:" + "\n");

            for (int i = 0; i <= years; i++) {
                if (i == 0) {
                    balance = initialAmount;
                    allBalances.add(balance);
                } else {
                    balance = balance * (1 + APY);
                    allBalances.add(balance);
                }
                savingsAccountDescription += ("     Year " + i + ": " + String.format("%,.2f", balance) + "\n");
            }
            calculateOutput.setText(savingsAccountDescription);
            //scaleAllBalances();
        } else {
            String errorMessage = "There is a problem with one or more of the inputs";
            calculateOutput.setText(errorMessage);
        }
    }

//    @Override
//    protected void paintComponent(Graphics g){
//        super.paintComponent(g);
//        Graphics2D g2 = (Graphics2D) g;
//        g2.setColor(Color.RED);
////        for (Rectangle aRectangle : allBars){
////            g2.draw(aRectangle);
////        }
//
//
//    }

//    public void generateBarGraph(){
//        JLabel newLabel = new JLabel("Bar Graph");
//
//
//    }
//
//    public void createRectangles(){
//
//        int widthPerRectangle = BAR_WIDTH / scaledBalances.size();
//        int heightPerRectangle = BAR_HEIGHT / scaledBalances.size();
//
//        int position = 1;
//        for (double balance : scaledBalances){
//            allBars.add(new Rectangle(widthPerRectangle * position,heightPerRectangle * position,(int)(BAR_WIDTH/balance), (int)(BAR_HEIGHT / balance)));
//            position++;
//        }
//
//    }

//    public void scaleAllBalances(){
//
//        double smallestNumber = 999999999;
//        for (double balance : allBalances){
//            if (balance < smallestNumber){
//                smallestNumber = balance;
//            }
//        }
//
//        for (double balance : allBalances){
//                scaledBalances.add((balance / smallestNumber));
//            }
//
//
//        for(double balance : allBalances){
//            System.out.println("Initial Balance : " + balance);
//        }
//
//        for(double balance : scaledBalances){
//            System.out.println("New Balance : " + (int) (balance * 100));
//        }
//    }


}

//    Write an application with three buttons labeled “Red”, “Green”, and “Blue” that
//        changes the background color of a panel in the center of the frame to red, green,
//        or blue.
