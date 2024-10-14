package com.restfulbooker.utils;

import com.github.javafaker.Faker;

public class FakerUtil {
    static Faker faker = new Faker();

    public static String getusername() {
        String name = faker.name().firstName();
        return name;
    }


}