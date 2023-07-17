package main.driver;

import calculator.action.Action;

public class Main {
    public static void main(String[] args) {
        try{
            new Action();
        } catch(Exception e){
            System.out.println(e.getMessage());
            return;
        }
    }
}
