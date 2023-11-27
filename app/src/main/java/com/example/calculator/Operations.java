package com.example.calculator;


import android.widget.TextView;

import java.util.ArrayList;

public class Operations {
    String text;
    public Operations(String text){
        this.text = text;
    }

    String[] infixToPostfix(String infix){

        String[] splits = infix.split("(?<=[+ * / -])|(?=[+ * / -])");
        ArrayList<String> stack = new ArrayList<>();
        ArrayList<String> temp = new ArrayList<>();

        for(int i = 0; i<splits.length; i++){

            if(!splits[i].equals("+") && !splits[i].equals("-") && !splits[i].equals("*") & !splits[i].equals("/")){
                temp.add(splits[i]);
                if(!stack.isEmpty()){
                    temp.add(stack.remove(stack.size()-1));
                }
            } else if (stack.isEmpty()) {
                stack.add(splits[i]);
            } else{
                temp.add(splits[i+1]);
                temp.add(splits[i]);
                i+=1;
                while(!stack.isEmpty()){
                    temp.add(stack.remove(stack.size()-1));
                }
            }

        }
        String[] postfix = new String[temp.size()];
        for(int i = 0; i< temp.size();i++){
            postfix[i] = temp.get(i);
        }
        return postfix;
    }

    String postfix(){
       String[] postfix = infixToPostfix(this.text);
        ArrayList<String> stack = new ArrayList<>();
        for(int i = 0; i<postfix.length; i++){
            if(postfix[i].equals("+")){
                Float fl1 = Float.parseFloat(stack.remove(stack.size()-1));
                Float fl2 = Float.parseFloat(stack.remove(stack.size()-1));
                stack.add(String.valueOf(fl2+fl1));
            }
            else if(postfix[i].equals("-")){
                Float fl1 = Float.parseFloat(stack.remove(stack.size()-1));
                Float fl2 = Float.parseFloat(stack.remove(stack.size()-1));
                stack.add(String.valueOf(fl2-fl1));
            }
            else if(postfix[i].equals("*")){
                Float fl1 = Float.parseFloat(stack.remove(stack.size()-1));
                Float fl2 = Float.parseFloat(stack.remove(stack.size()-1));
                stack.add(String.valueOf(fl2*fl1));
            }
            else if(postfix[i].equals("/")){
                Float fl1 = Float.parseFloat(stack.remove(stack.size()-1));
                Float fl2 = Float.parseFloat(stack.remove(stack.size()-1));
                stack.add(String.valueOf(fl2/fl1));
            }
            else{
                stack.add(postfix[i]);
            }
        }
        return stack.remove(stack.size()-1);
    }

    String percentage(){
        Float d = Float.parseFloat(this.text);
        String r = String.valueOf(d/100);
        return r;
    }

}
