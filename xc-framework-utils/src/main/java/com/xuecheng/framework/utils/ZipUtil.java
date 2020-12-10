package com.xuecheng.framework.utils;


import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;

public class ZipUtil {

    /**
     * 解压zip文件
     * @param zipFilePath 压缩文件路径
     * @param targetPath 目标文件路径
     * @throws ZipException 压缩异常
     */
    public static void unzip(String zipFilePath,String targetPath) throws Exception{
        ZipFile zipFile = new ZipFile(zipFilePath);
        zipFile.extractAll(targetPath);
    }

    /**
     * 解压zip文件（带密码）
     * @param zipFilePath 压缩文件路径
     * @param targetPath 目标路径
     * @param password 密码
     * @throws ZipException 压缩异常
     */
    public static void unzip(String zipFilePath,String password,String targetPath) throws Exception{
        ZipFile zipFile = new ZipFile(zipFilePath);
        if (zipFile.isEncrypted()) {
            zipFile.setPassword(password);
        }
        zipFile.extractAll(targetPath);
    }

    public static void main(String[] args) throws Exception {
        ZipUtil.unzip("F:\\develop\\upload\\upload.zip","F:\\develop\\upload\\zip\\");
    }
}
