package com.restfulbooker.DDT;

import com.restfulbooker.utils.ExcelUtil;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginWithDDT {

    @Test(dataProvider = "getData", dataProviderClass = ExcelUtil.class)
    public void testLoginData(String username, String password ){
        System.out.println("username = " + username);
        System.out.println("password = " + password);
    }
}
