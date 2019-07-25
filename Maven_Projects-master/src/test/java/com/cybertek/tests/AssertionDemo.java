package com.cybertek.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionDemo {
    @Test
    public void test1(){
        String a = "A";
        String b = "A";

        Assert.assertEquals(a,b);
    }
    @Test
    public void test2(){
        String a = "AD";
        String b = "AAA";
        Assert.assertTrue(b.contains(a),b+" should contained "+a);
    }
    @Test
    public void test3(){
        boolean b = 1 == 1;
        Assert.assertTrue(b);
    }
}
