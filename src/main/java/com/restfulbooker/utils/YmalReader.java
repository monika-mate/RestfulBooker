package com.restfulbooker.utils;

import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.Map;

public class YmalReader {

    public Map<String, Object> readkey(){

        Yaml yaml = new Yaml();
        InputStream inputStream = this.getClass()
                .getClassLoader()
                .getResourceAsStream("src/main/java/com/restfulbooker/resources/TestDataYmal.ymal");
        Map<String, Object> obj = yaml.load(inputStream);
        return obj;
    }

}
