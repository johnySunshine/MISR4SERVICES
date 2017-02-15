package com.soecode.osc.utils;

import org.junit.Test;


/**
 * Created by Fantasy on 2017/2/14.
 */
public class TestUtils {
    private final String FILE_PATH = "D:/XiGua Yingshi/uploadDemo";

    @Test
    public void TestMkDir() {
        boolean isFlag = GlobalUtils.mkDir(FILE_PATH);
        System.out.println(isFlag);
    }

    @Test
    public void TestGoPath() {
        String filePath = GlobalUtils.parsePath(FILE_PATH);
        System.out.println(filePath);
    }

    @Test
    public void TestGetFileTypeWithSuffix() {
        System.out.println(GlobalUtils.getFileTypeWithSuffix("a.jpg"));
    }

    @Test
    public void TestGetFileType() {
        System.out.println(GlobalUtils.getFileType("a.jpg"));
    }

    @Test
    public void TestGetNewFileName() {
        System.out.println(GlobalUtils.getNewFileName("a.jpg", "b", ""));
    }

    @Test
    public void TestGetRandomName() {
        System.out.println(GlobalUtils.getRandomName("a"));
    }

    @Test
    public void TestGetNumberName() {
        System.out.println(GlobalUtils.getNumberName("a"));
    }

    @Test
    public void TestGetBracketFileName() {
        //查找当前目录下面没有该文件；如果存在则重名名
        System.out.println(GlobalUtils.getBracketFileName("a.txt", GlobalUtils.parsePath(FILE_PATH)));
    }

    @Test
    public void TestValidTypeByName() {
        String[] allowArrow = {"jpg"};
        System.out.println(GlobalUtils.validTypeByName("a.a", allowArrow));
    }

    @Test
    public void TestValidTypeBySuffix() {
        String[] allowArrow = {"a"};
        System.out.println(GlobalUtils.validTypeBySuffix("a", allowArrow));
    }

    @Test
    public void TestValidTypeBySuffixForImages() {
        System.out.println(GlobalUtils.validTypeBySuffixForImages("jpg"));
    }

    @Test
    public void TestValidTypeBySuffixForOtherFiles() {
        System.out.println(GlobalUtils.validTypeBySuffixForOtherFiles("txt"));
    }

    @Test
    public void TestValidTypeByNameForImages() {
        System.out.println(GlobalUtils.validTypeByNameForImages("a.jpg"));
    }

    @Test
    public void TestValidTypeByNameForOtherFiles() {
        System.out.println(GlobalUtils.validTypeByNameForOtherFiles("a.txt"));
    }

    @Test
    public void TestRmdir() {
        //System.out.println(GlobalUtils.rmdir(FILE_PATH+"/a.txt"));
        System.out.println(GlobalUtils.rmdir("a.txt", FILE_PATH));
    }

    @Test
    public void TestRmFileDir() {
        System.out.println(GlobalUtils.rmFileDir(FILE_PATH + "/demo"));
    }

    @Test
    public void TestRmaFileDir() {
        System.out.println(GlobalUtils.rmaFileDir(FILE_PATH + "/demo"));
    }

    @Test
    public void TestIsFileExist() {
        System.out.println(GlobalUtils.isFileExist("a.txt", FILE_PATH));
    }
}
