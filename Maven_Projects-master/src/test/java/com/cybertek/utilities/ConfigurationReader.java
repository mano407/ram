package com.cybertek.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    private static Properties properties;

    static {
        String path = "configuration.properties";

        try {
            //Java cannot read files directly, it needs inputstream to read
            //inputstream takes the location of the file as a constructor

            FileInputStream fileInputStream = new FileInputStream(path);

            //Properties is used to read specifically properties files, files with any value pairs
            properties = new Properties();

            //File contents are load to properties from the inputstream
            properties.load(fileInputStream);

            //all input streams must be closed
            fileInputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    //returns the value
    public static String getProperty(String property){
        return properties.getProperty(property);
    }
}
