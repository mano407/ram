package com.cybertek.tests;

import org.testng.annotations.Test;

public class TestNGDemo {
    /*
    In TestNG/Junit, we use annotations to indicate
     */
    @Test
    public void testOne(){
        System.out.println("Hello World!");

        String expected = "a";
        String actual = "B";
        if(expected.equals(actual)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }
        //This not how you test in TestNG
    }
}
