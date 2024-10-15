package com.restfulbooker.utils;

import java.io.*;
import java.util.Properties;

public class PropertyReaderUtil {
    public PropertyReaderUtil() {

    }

    public static String readKey(String key) throws Exception {
        FileInputStream fileInputStream = new FileInputStream(new File(System.getProperty("user.dir") + "/src/main/java/com/restfulbooker/resources/TestDataProperties.properties"));
        Properties p=new Properties();
        p.load(fileInputStream);

        if(p.getProperty(key) == null){
            throw new Exception("key not found");
        }else {
            return p.getProperty(key);
        }


    }
}
