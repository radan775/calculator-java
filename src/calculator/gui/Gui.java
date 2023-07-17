package calculator.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Gui {
    private JFrame frame;
    private JFrame warning;
    private JLabel label = new JLabel();
    private JLabel warnLabel1 = new JLabel();
    private JLabel warnLabel2 = new JLabel();
    private JLabel warnLabel3 = new JLabel();
    private JLabel warnLabel4 = new JLabel();
    private JLabel warnLabel5 = new JLabel();
    private JTextField textField = new JTextField();
    private JButton buttonZero = new JButton("0");
    private JButton buttonOne = new JButton("1");
    private JButton buttonTwo = new JButton("2");
    private JButton buttonThree = new JButton("3");
    private JButton buttonFour = new JButton("4");
    private JButton buttonFive = new JButton("5");
    private JButton buttonSix = new JButton("6");
    private JButton buttonSeven = new JButton("7");
    private JButton buttonEight = new JButton("8");
    private JButton buttonNine = new JButton("9");
    private JButton buttonDot = new JButton(".");
    private JButton buttonClear = new JButton("C");
    private JButton buttonDelete = new JButton("DEL");
    private JButton buttonEqual = new JButton("=");
    private JButton buttonMulti = new JButton("x");
    private JButton buttonDiv = new JButton("\u00F7");
    private JButton buttonPlus = new JButton("+");
    private JButton buttonMinus = new JButton("-");
    private JButton buttonSquare = new JButton("x\u00B2");
    private JButton buttonReciprocal = new JButton("1/x");
    private JButton buttonSqrt = new JButton("\u221A");
    private JButton buttonMod = new JButton("Mod");
    private JButton buttonFact = new JButton("n!");

    public Gui(){
        warningGui();
    }

    private void warningGui(){
        warning = new JFrame();
        warning.setTitle("CATATAN");
        warning.setSize(300, 150);
        warning.getContentPane().setLayout(null);
        warning.getContentPane().setBackground(Color.white);
        warning.setResizable(false);
        warning.setLocationRelativeTo(null);
        
        warning.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        warning.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                prepareGUI();
                addComponents();
            }
        });

        warning.setVisible(true);
        
        warnComponents();
    }

    private void warnComponents(){
        warnLabel1.setBounds(10, 10, 290, 16);
        warnLabel1.setText("Calculator ini menggunakan konsep");
        warnLabel1.setFont(new Font("Arial", Font.BOLD, 15));
        warnLabel1.setForeground(Color.BLACK);
        warning.add(warnLabel1);

        warnLabel2.setBounds(10, 25, 290, 16);
        warnLabel2.setText("perhitungan matematika. Hasil akhir");
        warnLabel2.setFont(new Font("Arial", Font.BOLD, 15));
        warnLabel2.setForeground(Color.BLACK);
        warning.add(warnLabel2);

        warnLabel3.setBounds(10, 40, 290, 16);
        warnLabel3.setText("ditentukan oleh operator mana yang");
        warnLabel3.setFont(new Font("Arial", Font.BOLD, 15));
        warnLabel3.setForeground(Color.BLACK);
        warning.add(warnLabel3);

        warnLabel4.setBounds(10, 55, 290, 16);
        warnLabel4.setText("dikerjakan terlebih dahulu, tidak");
        warnLabel4.setFont(new Font("Arial", Font.BOLD, 15));
        warnLabel4.setForeground(Color.BLACK);
        warning.add(warnLabel4);

        warnLabel5.setBounds(10, 70, 290, 16);
        warnLabel5.setText("ditentukan oleh operator paling kiri.");
        warnLabel5.setFont(new Font("Arial", Font.BOLD, 15));
        warnLabel5.setForeground(Color.BLACK);
        warning.add(warnLabel5);
    }

    private void prepareGUI() {
        frame = new JFrame();
        frame.setTitle("Calculator UAS_pbo");
        frame.setSize(305, 490);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().setBackground(Color.gray);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void addComponents() {
        label.setBounds(10, 0, 280, 50);
        label.setFont(new Font("Arial", Font.BOLD, 15));
        label.setForeground(Color.WHITE);
        frame.add(label);

        textField.setBounds(10, 40, 270, 40);
        textField.setFont(new Font("Arial", Font.BOLD, 20));
        textField.setEditable(false);
        textField.setHorizontalAlignment(SwingConstants.RIGHT);
        frame.add(textField);
        
        buttonSeven.setBounds(10, 230, 60, 40);
        buttonSeven.setFont(new Font("Arial", Font.BOLD, 20));
        buttonSeven.setFocusable(false);
        frame.add(buttonSeven);

        buttonEight.setBounds(80, 230, 60, 40);
        buttonEight.setFont(new Font("Arial", Font.BOLD, 20));
        buttonEight.setFocusable(false);
        frame.add(buttonEight);

        buttonNine.setBounds(150, 230, 60, 40);
        buttonNine.setFont(new Font("Arial", Font.BOLD, 20));
        buttonNine.setFocusable(false);
        frame.add(buttonNine);

        buttonFour.setBounds(10, 290, 60, 40);
        buttonFour.setFont(new Font("Arial", Font.BOLD, 20));
        buttonFour.setFocusable(false);
        frame.add(buttonFour);

        buttonFive.setBounds(80, 290, 60, 40);
        buttonFive.setFont(new Font("Arial", Font.BOLD, 20));
        buttonFive.setFocusable(false);
        frame.add(buttonFive);

        buttonSix.setBounds(150, 290, 60, 40);
        buttonSix.setFont(new Font("Arial", Font.BOLD, 20));
        buttonSix.setFocusable(false);
        frame.add(buttonSix);

        buttonOne.setBounds(10, 350, 60, 40);
        buttonOne.setFont(new Font("Arial", Font.BOLD, 20));
        buttonOne.setFocusable(false);
        frame.add(buttonOne);

        buttonTwo.setBounds(80, 350, 60, 40);
        buttonTwo.setFont(new Font("Arial", Font.BOLD, 20));
        buttonTwo.setFocusable(false);
        frame.add(buttonTwo);

        buttonThree.setBounds(150, 350, 60, 40);
        buttonThree.setFont(new Font("Arial", Font.BOLD, 20));
        buttonThree.setFocusable(false);
        frame.add(buttonThree);

        buttonMod.setBounds(10, 400, 60, 40);
        buttonMod.setFont(new Font("Arial", Font.BOLD, 12));
        buttonMod.setBackground(new Color(239, 188, 2));
        buttonMod.setFocusable(false);
        frame.add(buttonMod);

        buttonDot.setBounds(150, 400, 60, 40);
        buttonDot.setFont(new Font("Arial", Font.BOLD, 20));
        buttonDot.setFocusable(false);
        frame.add(buttonDot);

        buttonZero.setBounds(80, 400, 60, 40);
        buttonZero.setFont(new Font("Arial", Font.BOLD, 20));
        buttonZero.setFocusable(false);
        frame.add(buttonZero);

        buttonEqual.setBounds(220, 350, 60, 90);
        buttonEqual.setFont(new Font("Arial", Font.BOLD, 20));
        buttonEqual.setBackground(new Color(239, 188, 2));
        buttonEqual.setFocusable(false);
        frame.add(buttonEqual);

        buttonDiv.setBounds(220, 110, 60, 40);
        buttonDiv.setFont(new Font("Arial", Font.BOLD, 20));
        buttonDiv.setBackground(new Color(239, 188, 2));
        buttonDiv.setFocusable(false);
        frame.add(buttonDiv);

        buttonSqrt.setBounds(10, 170, 60, 40);
        buttonSqrt.setFont(new Font("Arial", Font.BOLD, 18));
        buttonSqrt.setBackground(new Color(70, 130, 180));
        buttonSqrt.setFocusable(false);
        frame.add(buttonSqrt);

        buttonMulti.setBounds(220, 230, 60, 40);
        buttonMulti.setFont(new Font("Arial", Font.BOLD, 20));
        buttonMulti.setBackground(new Color(239, 188, 2));
        buttonMulti.setFocusable(false);
        frame.add(buttonMulti);

        buttonMinus.setBounds(220, 170, 60, 40);
        buttonMinus.setFont(new Font("Arial", Font.BOLD, 20));
        buttonMinus.setBackground(new Color(239, 188, 2));
        buttonMinus.setFocusable(false);
        frame.add(buttonMinus);

        buttonPlus.setBounds(220, 290, 60, 40);
        buttonPlus.setFont(new Font("Arial", Font.BOLD, 20));
        buttonPlus.setBackground(new Color(239, 188, 2));
        buttonPlus.setFocusable(false);
        frame.add(buttonPlus);

        buttonSquare.setBounds(80, 170, 60, 40);
        buttonSquare.setFont(new Font("Arial", Font.BOLD, 20));
        buttonSquare.setBackground(new Color(70, 130, 180));
        buttonSquare.setFocusable(false);
        frame.add(buttonSquare);

        buttonReciprocal.setBounds(150, 170, 60, 40);
        buttonReciprocal.setFont(new Font("Arial", Font.BOLD, 15));
        buttonReciprocal.setBackground(new Color(70, 130, 180));
        buttonReciprocal.setFocusable(false);
        frame.add(buttonReciprocal);

        buttonDelete.setBounds(150, 110, 60, 40);
        buttonDelete.setFont(new Font("Arial", Font.BOLD, 12));
        buttonDelete.setBackground(Color.RED);
        buttonDelete.setForeground(Color.BLACK);
        buttonDelete.setFocusable(false);
        frame.add(buttonDelete);

        buttonClear.setBounds(80, 110, 60, 40);
        buttonClear.setFont(new Font("Arial", Font.BOLD, 12));
        buttonClear.setBackground(Color.RED);
        buttonClear.setForeground(Color.BLACK);
        buttonClear.setFocusable(false);
        frame.add(buttonClear);

        buttonFact.setBounds(10, 110, 60, 40);
        buttonFact.setFont(new Font("Arial", Font.BOLD, 15));
        buttonFact.setBackground(new Color(70, 130, 180));
        buttonFact.setFocusable(false);
        frame.add(buttonFact);
    }

    public JFrame getFrame(){
        return frame;
    }

    public JLabel getLabel() {
        return label;
    }
    
    public JTextField getTextField() {
        return textField;
    }
    
    public JButton getButtonZero() {
        return buttonZero;
    }
    
    public JButton getButtonOne() {
        return buttonOne;
    }
    
    public JButton getButtonTwo() {
        return buttonTwo;
    }
    
    public JButton getButtonThree() {
        return buttonThree;
    }
    
    public JButton getButtonFour() {
        return buttonFour;
    }
    
    public JButton getButtonFive() {
        return buttonFive;
    }
    
    public JButton getButtonSix() {
        return buttonSix;
    }
    
    public JButton getButtonSeven() {
        return buttonSeven;
    }
    
    public JButton getButtonEight() {
        return buttonEight;
    }
    
    public JButton getButtonNine() {
        return buttonNine;
    }
    
    public JButton getButtonDot() {
        return buttonDot;
    }
    
    public JButton getButtonClear() {
        return buttonClear;
    }
    
    public JButton getButtonDelete() {
        return buttonDelete;
    }
    
    public JButton getButtonEqual() {
        return buttonEqual;
    }
    
    public JButton getButtonMulti() {
        return buttonMulti;
    }
    
    public JButton getButtonDiv() {
        return buttonDiv;
    }
    
    public JButton getButtonPlus() {
        return buttonPlus;
    }
    
    public JButton getButtonMinus() {
        return buttonMinus;
    }
    
    public JButton getButtonSquare() {
        return buttonSquare;
    }
    
    public JButton getButtonReciprocal() {
        return buttonReciprocal;
    }
    
    public JButton getButtonSqrt() {
        return buttonSqrt;
    }

    public JButton getButtonMod(){
        return buttonMod;
    }
    
    public JButton getButtonFact(){
        return buttonFact;
    }
}