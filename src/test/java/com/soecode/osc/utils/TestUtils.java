package com.soecode.osc.utils;

import org.junit.Test;

/**
 * Created by Fantasy on 2017/2/14.
 *
 */
public class TestUtils {

    @Test
    public void TestUploadFile(){
        boolean isFlag = GlobalUtils.mkDir("/upload/");
        System.out.println(isFlag);
    }
    @Test
    public void TestGoPath(){
        String  filePath = GlobalUtils.parsePath("E:/WorkspacesMyEclipseProfessional2014/exercise/WebRoot/new");
        System.out.println(filePath);
    }
}
