package com.example.calculator;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);



    }



    Operations op = new Operations("5.2+2.2");



    @Test
    public void CheckinfixToPostfix(){
        String[] list1 = {"5","2","2","*","+","3","6","*","-"};
        String postfix = op.text;
        String[] list2 = op.infixToPostfix(postfix);
        assertEquals(list1,list2);
    }

    @Test
    public void Checkpostfix() {
        assertEquals("7.4",op.postfix());
    }


}