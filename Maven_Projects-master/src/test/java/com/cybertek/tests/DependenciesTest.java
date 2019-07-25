package com.cybertek.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependenciesTest {
    @Test
    public void login(){
        System.out.println("login");
        Assert.assertTrue(false);
    }
    @Test(dependsOnMethods = "login")
    public void zbuysth(){
        System.out.println("buy buy baby");
    }
    @Test(priority = 5)
    public void homepage(){
        System.out.println("Home page");
    }
}
