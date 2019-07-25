package com.cybertek.tests;

import com.cybertek.pages.Homepage;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.TestBase;
import org.testng.annotations.Test;

public class LoginTestWithProperty extends TestBase {

    @Test
    public void readPropertyTest(){
        driver.get(ConfigurationReader.getProperty("url"));

        Homepage homepage = new Homepage();

        String username = ConfigurationReader.getProperty("username");
        String password = ConfigurationReader.getProperty("password");

        homepage.login(username,password);
    }
}
