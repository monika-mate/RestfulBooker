package com.restfulbooker.endpoints;

import com.restfulbooker.utils.PropertyReaderUtil;

public class ApiConstant {
    public static  String BASE_URL;
    public static  String Create_Booking;
    public static  String Update_Booking;

    static {
        try {
            BASE_URL = PropertyReaderUtil.readKey("url");
            Create_Booking = PropertyReaderUtil.readKey("Create_Booking");
            Update_Booking = PropertyReaderUtil.readKey("Update_Booking");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }




}
