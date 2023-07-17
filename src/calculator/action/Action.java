package calculator.action;

import calculator.gui.Gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Action implements ActionListener{
    private double number;
    private Gui gui;
    private boolean isFillLabel = false;
    private boolean isAddNumber = false;
    private String regex = ".*[+\\-x/]\\s$|.*Mod\\s$|.*\u00F7\\s$";

    public Action(){
        gui = new Gui();
        addActionEvent();
    }
    
    private void addActionEvent() {
        gui.getButtonClear().addActionListener(this);
        gui.getButtonDelete().addActionListener(this);
        gui.getButtonDiv().addActionListener(this);
        gui.getButtonSqrt().addActionListener(this);
        gui.getButtonSquare().addActionListener(this);
        gui.getButtonReciprocal().addActionListener(this);
        gui.getButtonMinus().addActionListener(this);
        gui.getButtonSeven().addActionListener(this);
        gui.getButtonEight().addActionListener(this);
        gui.getButtonNine().addActionListener(this);
        gui.getButtonMulti().addActionListener(this);
        gui.getButtonFour().addActionListener(this);
        gui.getButtonFive().addActionListener(this);
        gui.getButtonSix().addActionListener(this);
        gui.getButtonPlus().addActionListener(this);
        gui.getButtonOne().addActionListener(this);
        gui.getButtonTwo().addActionListener(this);
        gui.getButtonThree().addActionListener(this);
        gui.getButtonEqual().addActionListener(this);
        gui.getButtonZero().addActionListener(this);
        gui.getButtonDot().addActionListener(this);
        gui.getButtonMod().addActionListener(this);
        gui.getButtonFact().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == gui.getButtonClear()) {
            gui.getLabel().setText("");
            gui.getTextField().setText("");
        } else if (source == gui.getButtonDelete()) {
            int length = gui.getTextField().getText().length();
            int number = length - 1;
            if(gui.getTextField().getText().equals("Infinity")){
                gui.getLabel().setText("");
                gui.getTextField().setText("");
            } else if (length > 0) {
                StringBuilder back = new StringBuilder(gui.getTextField().getText());
                back.deleteCharAt(number);
                gui.getTextField().setText(back.toString());
            }else if (gui.getTextField().getText().endsWith("")) {
                gui.getLabel().setText("");
            }
        } else if (source == gui.getButtonZero()) {
            isAddNumber = true;
            if(isFillLabel){
                gui.getTextField().setText("");
                isFillLabel = false;
            }
            if (gui.getTextField().getText().equals("0")) {
                return;
            } else {
                gui.getTextField().setText(gui.getTextField().getText() + "0");
            }
        } else if (source == gui.getButtonOne()) {
            isAddNumber = true;
            if(isFillLabel){
                gui.getTextField().setText("");
                isFillLabel = false;
            }
            gui.getTextField().setText(gui.getTextField().getText() + "1");
        } else if (source == gui.getButtonTwo()) {
            isAddNumber = true;
            if(isFillLabel){
                gui.getTextField().setText("");
                isFillLabel = false;
            }
            gui.getTextField().setText(gui.getTextField().getText() + "2");
        } else if (source == gui.getButtonThree()) {
            isAddNumber = true;
            if(isFillLabel){
                gui.getTextField().setText("");
                isFillLabel = false;
            }
            gui.getTextField().setText(gui.getTextField().getText() + "3");
        } else if (source == gui.getButtonFour()) {
            isAddNumber = true;
            if(isFillLabel){
                gui.getTextField().setText("");
                isFillLabel = false;
            }
            gui.getTextField().setText(gui.getTextField().getText() + "4");
        } else if (source == gui.getButtonFive()) {
            isAddNumber = true;
            if(isFillLabel){
                gui.getTextField().setText("");
                isFillLabel = false;
            }
            gui.getTextField().setText(gui.getTextField().getText() + "5");
        } else if (source == gui.getButtonSix()) {
            isAddNumber = true;
            if(isFillLabel){
                gui.getTextField().setText("");
                isFillLabel = false;
            }
            gui.getTextField().setText(gui.getTextField().getText() + "6");
        } else if (source == gui.getButtonSeven()) {
            isAddNumber = true;
            if(isFillLabel){
                gui.getTextField().setText("");
                isFillLabel = false;
            }
            gui.getTextField().setText(gui.getTextField().getText() + "7");
        } else if (source == gui.getButtonEight()) {
            isAddNumber = true;
            if(isFillLabel){
                gui.getTextField().setText("");
                isFillLabel = false;
            }
            gui.getTextField().setText(gui.getTextField().getText() + "8");
        } else if (source == gui.getButtonNine()) {
            isAddNumber = true;
            if(isFillLabel){
                gui.getTextField().setText("");
                isFillLabel = false;
            }
            gui.getTextField().setText(gui.getTextField().getText() + "9");
        } else if (source == gui.getButtonDot()) {
            String str = gui.getTextField().getText();
            if (str.contains(".")) {
                return;
            } else if (!(str.equals(""))){
                gui.getTextField().setText(gui.getTextField().getText() + ".");
            }
        } else if (source == gui.getButtonPlus()) {
            actionButtonPlus();

        } else if (source == gui.getButtonMinus()) {
            actionButtonMinus();

        } else if (source == gui.getButtonMulti()) {
            actionButtonMulti();

        } else if (source == gui.getButtonDiv()) {
            actionButtonDiv();

        } else if (source == gui.getButtonEqual()) {
            actionButtonEqual();

        } else if (source == gui.getButtonMod()){
            actionButtonMod();

        } else if (source == gui.getButtonReciprocal()) {
            String str = gui.getTextField().getText();
            if(!(str.isEmpty())){
                number = Double.parseDouble(str);
                double reciprocal = 1 / number;
                String string = Double.toString(reciprocal);
                if (string.endsWith(".0")) {
                    gui.getTextField().setText(string.replace(".0", ""));
                } else {
                    gui.getTextField().setText(string);
                }
            }
        } else if (source == gui.getButtonFact()){
            actionButtonFact();

        } else if (source == gui.getButtonSquare()) {
            actionButtonSquare();

        } else if (source == gui.getButtonSqrt()) {
            actionButtonSqrt();
        }
    }

    private void actionButtonPlus(){
        String str = gui.getTextField().getText();
        String label = gui.getLabel().getText();
        boolean isLabelEqual = !(label.endsWith("="));

        if(!(str.isEmpty()) && isLabelEqual){
            boolean isLabelNotNull = !(label.isEmpty());
            boolean endWithOperator = label.matches(regex);
            int length = label.length();

            if(isLabelNotNull && endWithOperator && !(isAddNumber)){
                if(label.endsWith("Mod ")){
                    gui.getLabel().setText(label.substring(0, length-4) + "+ ");
                } else {
                    gui.getLabel().setText(label.substring(0, length-2) + "+ ");
                }
                
            } else if(str.equals("0")){
                gui.getLabel().setText(str + " + ");
            } else if (str.startsWith("0") && !(str.startsWith("0."))){
                str = str.substring(1);
                gui.getLabel().setText(str + " + ");

            } else if (isLabelNotNull && isAddNumber){
                if(str.endsWith(".0")){
                    gui.getLabel().setText(label + str.replace(".0", "") + " + ");
                } else if(label.endsWith("! ") || label.endsWith(")")){
                    gui.getLabel().setText(label + "+ ");
                } else {
                    gui.getLabel().setText(label + str + " + ");
                }
            } else if(label.endsWith("! ") || label.endsWith(")")){
                gui.getLabel().setText(label + "+ ");
            } else {
                gui.getLabel().setText(str + " + ");
            }

            label = gui.getLabel().getText();
            if(isLabelNotNull){
                String number;
                boolean isLabelMod = label.contains("Mod");
                if(isLabelMod){
                    number = Double.toString(ParseEval.eval(label.replaceAll("Mod", "%") + "0"));
                } else if(label.contains("!")){
                    if(label.endsWith("+ ")){
                        number = Double.toString(ParseEval.eval(label + "0"));
                    } else {
                        number = Double.toString(ParseEval.eval(label));
                    }
                } else {
                    number = Double.toString(ParseEval.eval(label + "0"));
                }

                if(number.endsWith(".0")){
                    gui.getTextField().setText(number.replace(".0", ""));
                } else {
                    gui.getTextField().setText(number);
                }
            }
            isAddNumber = false;
            isFillLabel = true;
        }
    }

    private void actionButtonMinus(){
        String str = gui.getTextField().getText();
        String label = gui.getLabel().getText();
        boolean isLabelEqual = !(label.endsWith("="));

        if(!(str.isEmpty()) && isLabelEqual){
            boolean isLabelNotNull = !(label.isEmpty());
            boolean endWithOperator = label.matches(regex);
            int length = label.length();

            if(isLabelNotNull && endWithOperator && !(isAddNumber)){
                if(label.endsWith("Mod ")){
                    gui.getLabel().setText(label.substring(0, length-4) + "- ");
                } else {
                    gui.getLabel().setText(label.substring(0, length-2) + "- ");
                }
                
            } else if(str.equals("0")){
                gui.getLabel().setText(str + " - ");
            } else if (str.startsWith("0") && !(str.startsWith("0."))){
                str = str.substring(1);
                gui.getLabel().setText(str + " - ");

            } else if (isLabelNotNull && isAddNumber){
                if(str.endsWith(".0")){
                    gui.getLabel().setText(label + str.replace(".0", "") + " - ");
                } else if(label.endsWith("! ") || label.endsWith(")")){
                    gui.getLabel().setText(label + "- ");
                } else {
                    gui.getLabel().setText(label + str + " - ");
                }
            } else if(label.endsWith("! ") || label.endsWith(")")){
                gui.getLabel().setText(label + "- ");
            } else {
                gui.getLabel().setText(str + " - ");
            }

            label = gui.getLabel().getText();
            if(isLabelNotNull){
                String number;
                boolean isLabelMod = label.contains("Mod");
                if(isLabelMod){
                    number = Double.toString(ParseEval.eval(label.replaceAll("Mod", "%") + "0"));
                } else if(label.contains("!")){
                    if(label.endsWith("- ")){
                        number = Double.toString(ParseEval.eval(label + "0"));
                    } else {
                        number = Double.toString(ParseEval.eval(label));
                    }
                } else {
                    number = Double.toString(ParseEval.eval(label + "0"));
                }

                if(number.endsWith(".0")){
                    gui.getTextField().setText(number.replace(".0", ""));
                } else {
                    gui.getTextField().setText(number);
                }
            }
            isAddNumber = false;
            isFillLabel = true;
        }
    }

    private void actionButtonMulti(){
        String str = gui.getTextField().getText();
        String label = gui.getLabel().getText();
        boolean isLabelEqual = !(label.endsWith("="));

        if(!(str.isEmpty()) && isLabelEqual){
            boolean isLabelNotNull = !(label.isEmpty());
            boolean endWithOperator = label.matches(regex);
            int length = label.length();

            if(isLabelNotNull && endWithOperator && !(isAddNumber)){
                if(label.endsWith("Mod ")){
                    gui.getLabel().setText(label.substring(0, length-4) + "x ");
                } else {
                    gui.getLabel().setText(label.substring(0, length-2) + "x ");
                }
                
            } else if(str.equals("0")){
                gui.getLabel().setText(str + " x ");
            } else if (str.startsWith("0") && !(str.startsWith("0."))){
                str = str.substring(1);
                gui.getLabel().setText(str + " x ");

            } else if (isLabelNotNull && isAddNumber){
                if(str.endsWith(".0")){
                    gui.getLabel().setText(label + str.replace(".0", "") + " x ");
                } else if(label.endsWith("! ") || label.endsWith(")")){
                    gui.getLabel().setText(label + "x ");
                } else {
                    gui.getLabel().setText(label + str + " x ");
                }
            } else if(label.endsWith("! ") || label.endsWith(")")){
                gui.getLabel().setText(label + "x ");
            } else {
                gui.getLabel().setText(str + " x ");
            }

            label = gui.getLabel().getText();
            if(isLabelNotNull){
                String number;
                boolean isLabelMod = label.contains("Mod");
                if(isLabelMod){
                    number = Double.toString(ParseEval.eval(label.replaceAll("Mod", "%") + "1"));
                } else if(label.contains("!")){
                    if(label.endsWith("x ")){
                        number = Double.toString(ParseEval.eval(label + "1"));
                    } else {
                        number = Double.toString(ParseEval.eval(label));
                    }
                } else {
                    number = Double.toString(ParseEval.eval(label + "1"));
                }

                if(number.endsWith(".0")){
                    gui.getTextField().setText(number.replace(".0", ""));
                } else {
                    gui.getTextField().setText(number);
                }
            }
            isAddNumber = false;
            isFillLabel = true;
        }
    }

    private void actionButtonDiv(){
        String str = gui.getTextField().getText();
        String label = gui.getLabel().getText();
        boolean isLabelEqual = !(label.endsWith("="));

        if(!(str.isEmpty()) && isLabelEqual){
            boolean isLabelNotNull = !(label.isEmpty());
            boolean endWithOperator = label.matches(regex);
            int length = label.length();

            if(isLabelNotNull && endWithOperator && !(isAddNumber)){
                if(label.endsWith("Mod ")){
                    gui.getLabel().setText(label.substring(0, length-4) + "\u00F7 ");
                } else {
                    gui.getLabel().setText(label.substring(0, length-2) + "\u00F7 ");
                }
                
            } else if(str.equals("0")){
                gui.getLabel().setText(str + " \u00F7 ");
            } else if (str.startsWith("0") && !(str.startsWith("0."))){
                str = str.substring(1);
                gui.getLabel().setText(str + " \u00F7 ");

            } else if (isLabelNotNull && isAddNumber){
                if(str.endsWith(".0")){
                    gui.getLabel().setText(label + str.replace(".0", "") + " \u00F7 ");
                } else if(label.endsWith("! ") || label.endsWith(")")){
                    gui.getLabel().setText(label + "\u00F7 ");
                } else {
                    gui.getLabel().setText(label + str + " \u00F7 ");
                }
            } else if(label.endsWith("! ") || label.endsWith(")")){
                gui.getLabel().setText(label + "\u00F7 ");
            } else {
                gui.getLabel().setText(str + " \u00F7 ");
            }

            label = gui.getLabel().getText();
            if(isLabelNotNull){
                String number;
                boolean isLabelMod = label.contains("Mod");
                if(isLabelMod){
                    number = Double.toString(ParseEval.eval(label.replaceAll("Mod", "%") + "1"));
                } else if(label.contains("!")){
                    if(label.endsWith("\u00F7 ")){
                        number = Double.toString(ParseEval.eval(label + "1"));
                    } else {
                        number = Double.toString(ParseEval.eval(label));
                    }
                } else {
                    number = Double.toString(ParseEval.eval(label + "1"));
                }

                if(number.endsWith(".0")){
                    gui.getTextField().setText(number.replace(".0", ""));
                } else {
                    gui.getTextField().setText(number);
                }
            }
            isAddNumber = false;
            isFillLabel = true;
        }
    }

    private void actionButtonMod(){
        String str = gui.getTextField().getText();
        String label = gui.getLabel().getText();
        boolean isLabelEqual = !(label.endsWith("="));

        if(!(str.isEmpty()) && isLabelEqual){
            boolean isLabelNotNull = !(label.isEmpty());
            boolean endWithOperator = label.matches(regex);
            int length = label.length();

            if(isLabelNotNull && endWithOperator && !(isAddNumber)){
                if(label.endsWith("Mod ")){
                    gui.getLabel().setText(label.substring(0, length-4) + "Mod ");
                } else {
                    gui.getLabel().setText(label.substring(0, length-2) + "Mod ");
                }
                
            } else if(str.equals("0")){
                gui.getLabel().setText(str + " Mod ");
            } else if (str.startsWith("0") && !(str.startsWith("0."))){
                str = str.substring(1);
                gui.getLabel().setText(str + " Mod ");

            } else if (isLabelNotNull && isAddNumber){
                if(str.endsWith(".0")){
                    gui.getLabel().setText(label + str.replace(".0", "") + " Mod ");
                } else if(label.endsWith("! ") || label.endsWith(")")){
                    gui.getLabel().setText(label + "Mod ");
                } else {
                    gui.getLabel().setText(label + str + " Mod ");
                }
            } else if(label.endsWith("! ") || label.endsWith(")")){
                gui.getLabel().setText(label + "Mod ");
            } else {
                gui.getLabel().setText(str + " Mod ");
            }

            label = gui.getLabel().getText();
            if(isLabelNotNull){
                String number;
                boolean isLabelMod = label.contains("Mod");
                int len = gui.getLabel().getText().length();
                if(isLabelMod){
                    number = Double.toString(ParseEval.eval(label.replaceAll("Mod", "%").substring(0, len - 4)));
                } else if(label.contains("!")){
                    if(label.endsWith("Mod ")){
                        number = Double.toString(ParseEval.eval(label.substring(0, len - 4)));
                    } else {
                        number = Double.toString(ParseEval.eval(label));
                    }
                } else {
                    number = Double.toString(ParseEval.eval(label + "1"));
                }

                if(number.endsWith(".0")){
                    gui.getTextField().setText(number.replace(".0", ""));
                } else {
                    gui.getTextField().setText(number);
                }
            }
            isAddNumber = false;
            isFillLabel = true;
        }
    }

    private void actionButtonFact(){
        String str = gui.getTextField().getText();
        boolean isLabelNotNull = !(gui.getLabel().getText().isEmpty());
        boolean isLabelEqual = !(gui.getLabel().getText().endsWith("="));

        if(!(str.isEmpty()) && isLabelEqual){
            if(isLabelNotNull && !(gui.getLabel().getText().endsWith("! ")) && !(gui.getLabel().getText().endsWith(")"))){
                gui.getLabel().setText(gui.getLabel().getText() + str + "! ");
            } else if(isLabelNotNull && isAddNumber){
                int len = gui.getLabel().getText().length();
                if(!(len == 2)){
                    gui.getLabel().setText(gui.getLabel().getText().substring(0, len-3) + str + "! ");
                }
            } else {
                gui.getLabel().setText(str + "! ");
            }

            String string = Double.toString(ParseEval.eval(str + "! "));
            if (string.endsWith(".0")) {
                gui.getTextField().setText(string.replace(".0", ""));
            } else {
                gui.getTextField().setText(string);
            }

        // untuk menangani label yang ada tanda "=", maka diakhir tidak lagi menambah negasi tetapi direplace
        } else if(!(str.isEmpty())){
            if(isLabelNotNull && !(gui.getLabel().getText().endsWith("! "))){
                gui.getLabel().setText(str + "! ");
            }
            String string = Double.toString(ParseEval.eval(gui.getLabel().getText()));
            if (string.endsWith(".0")) {
                gui.getTextField().setText(string.replace(".0", ""));
            } else {
                gui.getTextField().setText(string);
            }
        }
        isAddNumber = false;
        isFillLabel = true;
    }

    private void actionButtonSqrt(){
        String str = gui.getTextField().getText();
        boolean isLabelNotNull = !(gui.getLabel().getText().isEmpty());
        boolean isLabelEqual = !(gui.getLabel().getText().endsWith("="));
        
        if(!(str.isEmpty()) && isLabelEqual){
            if(isLabelNotNull && !(gui.getLabel().getText().endsWith("! ")) && gui.getLabel().getText().matches(regex)){
                gui.getLabel().setText(gui.getLabel().getText() + "sqrt("+str+")");

            } else if(isLabelNotNull && isAddNumber){
                if(!gui.getLabel().getText().endsWith(")")){
                    gui.getLabel().setText(gui.getLabel().getText() + "sqrt("+str+")");
                }
            } else {
                gui.getLabel().setText("sqrt("+str+")");
            }

            String string = Double.toString(ParseEval.eval("sqrt("+str+")"));
            if (string.endsWith(".0")) {
                gui.getTextField().setText(string.replace(".0", ""));
            } else {
                gui.getTextField().setText(string);
            }

        // untuk menangani label yang ada tanda "=", maka diakhir tidak lagi menambah negasi tetapi direplace
        } else if(!(str.isEmpty())){
            if(isLabelNotNull && !(gui.getLabel().getText().endsWith("! "))){
                gui.getLabel().setText("sqrt("+ str+")");
            }
            String string = Double.toString(ParseEval.eval(gui.getLabel().getText()));
            if (string.endsWith(".0")) {
                gui.getTextField().setText(string.replace(".0", ""));
            } else {
                gui.getTextField().setText(string);
            }
        }
        isAddNumber = false;
        isFillLabel = true;
    }

    private void actionButtonSquare(){
        String str = gui.getTextField().getText();
        boolean isLabelNotNull = !(gui.getLabel().getText().isEmpty());
        boolean isLabelEqual = !(gui.getLabel().getText().endsWith("="));
        
        if(!(str.isEmpty()) && isLabelEqual){
            if(isLabelNotNull && !(gui.getLabel().getText().endsWith("! ")) && gui.getLabel().getText().matches(regex)){
                gui.getLabel().setText(gui.getLabel().getText() + "square("+str+")");

            } else if(isLabelNotNull && isAddNumber){
                if(!gui.getLabel().getText().endsWith(")")){
                    gui.getLabel().setText(gui.getLabel().getText() + "square("+str+")");
                }
            } else {
                gui.getLabel().setText("square("+str+")");
            }

            String string = Double.toString(ParseEval.eval("square("+str+")"));
            if (string.endsWith(".0")) {
                gui.getTextField().setText(string.replace(".0", ""));
            } else {
                gui.getTextField().setText(string);
            }

        // untuk menangani label yang ada tanda "=", maka diakhir tidak lagi menambah negasi tetapi direplace
        } else if(!(str.isEmpty())){
            if(isLabelNotNull && !(gui.getLabel().getText().endsWith("! "))){
                gui.getLabel().setText("square("+ str+")");
            }
            String string = Double.toString(ParseEval.eval(gui.getLabel().getText()));
            if (string.endsWith(".0")) {
                gui.getTextField().setText(string.replace(".0", ""));
            } else {
                gui.getTextField().setText(string);
            }
        }
        isAddNumber = false;
        isFillLabel = true;
    }

    private void actionButtonEqual(){
        String str = gui.getTextField().getText();
        String label = gui.getLabel().getText();
        if(str.isEmpty()){
            return;
        }

        boolean isLabelEqual = !(label.endsWith("="));
        if(isLabelEqual){
            String answer;

            String tempLabel = label;
            while(tempLabel.contains("!")){
                int indexFact = tempLabel.indexOf("!");
                int indexDigit = indexFact - 1;
                String temp = Character.toString(tempLabel.charAt(indexDigit)) + Character.toString(tempLabel.charAt(indexFact));
                double tempValue = ParseEval.eval(temp);
                tempLabel = tempLabel.replace(temp, Double.toString(tempValue));
            };
            if(label.contains("Mod")){
                if(label.endsWith("! ") || label.endsWith(")")){
                    answer = Double.toString(ParseEval.eval(tempLabel.replaceAll("Mod", "%")));
                } else {
                    answer = Double.toString(ParseEval.eval(label.replaceAll("Mod", "%") + str));
                }
            }else if(label.contains("!")){
                if(label.matches(regex) && !(str.isEmpty())){
                    answer = Double.toString(ParseEval.eval(label + str));
                } else {
                    answer = Double.toString(ParseEval.eval(label));
                }
            } else if(label.endsWith(")")){
                answer = Double.toString(ParseEval.eval(label));
            } else {
                answer = Double.toString(ParseEval.eval(label + str));
            }
            
            if (answer.endsWith(".0")) {
                gui.getTextField().setText(answer.replace(".0", ""));
            } else {
                gui.getTextField().setText(answer);
            }
            
            if(label.endsWith("+ ")){
                gui.getLabel().setText(label +  str + " =");
            } else if(label.endsWith("- ")){
                gui.getLabel().setText(label +  str + " =");
            }else if(label.endsWith("x ")){
                gui.getLabel().setText(label +  str + " =");
            } else if(label.endsWith("\u00F7 ")){
                gui.getLabel().setText(label +  str + " =");
            } else if(label.endsWith("Mod ")){
                gui.getLabel().setText(label + str + " =");
            } else if(label.endsWith("! ")){
                gui.getLabel().setText(label + " =");
            } else if(label.endsWith(")")){
                gui.getLabel().setText(label + " =");
            }
            isAddNumber = false;
            isFillLabel = true;
        }
    }
}