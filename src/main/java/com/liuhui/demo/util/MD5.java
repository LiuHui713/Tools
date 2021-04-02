package com.liuhui.demo.util;

import org.junit.Test;
import org.springframework.util.StringUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;

public class MD5 {

    @Test
    public void test1(){
        String ts = "123456";
        String s = stringToMD5(ts);
        System.out.println(s);
    }

    public static String stringToMD5(String str) {

        try {
            byte[] strTemp = str.getBytes();
            MessageDigest mdTemp = MessageDigest.getInstance("MD5");
            mdTemp.update(strTemp);
            return toHexString(mdTemp.digest());
        } catch (Exception e) {
            return null;
        }
    }

    public static String fileNameToMD5(String fileName) {
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(fileName);
            return streamToMD5(inputStream);
        } catch (Exception e) {
            return null;
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static String streamToMD5(InputStream inputStream) {
        try {
            MessageDigest mdTemp = MessageDigest.getInstance("MD5");
            byte[] buffer = new byte[1024];
            int numRead = 0;
            while ((numRead = inputStream.read(buffer)) > 0) {
                mdTemp.update(buffer, 0, numRead);
            }
            return toHexString(mdTemp.digest());
        } catch (Exception e) {
            return null;
        }
    }

    private static String toHexString(byte[] md) {
        char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f' };
        int j = md.length;
        char str[] = new char[j * 2];
        for (int i = 0; i < j; i++) {
            byte byte0 = md[i];
            str[2 * i] = hexDigits[byte0 >>> 4 & 0xf];
            str[i * 2 + 1] = hexDigits[byte0 & 0xf];
        }
        return new String(str);
    }

    /**
     * 计算文件的MD5码
     *
     * @param inputStream
     * @return
     */
    public static String getMD5(InputStream inputStream,String userName) {
        try {
            //MessageDigest 类为应用程序提供信息摘要算法的功能，如 MD5 或 SHA 算法
            //MessageDigest 对象开始被初始化,如下是采用“MD5”的方式
            //其中getInstance（），有一参的构造方法，还有两参的构造方法
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] buffer = new byte[8192];
            int length = -1;
            while ((length = inputStream.read(buffer)) != -1) {
                //使用指定的 byte 数组更新摘要。
                md.update(buffer, 0, length);
            }
            //digest(),通过执行诸如填充之类的最终操作完成哈希计算。在调用此方法之后，摘要被重置。
            return convertToHexString(md.digest(),userName);
        } catch (Exception ex) {
            return null;
        }
    }

    static String convertToHexString(byte data[],String userName) {
        StringBuffer strBuffer = new StringBuffer();
        for (int i = 0; i < data.length; i++) {
            //转成16进制，0xff & data[i]，作用是将byte转成int时会在高24为补上0，保证二进制的转换一致性
            strBuffer.append(Integer.toHexString(0xff & data[i]));
        }
        if(StringUtils.isEmpty(userName)){
            strBuffer.append(userName);
        }
        return strBuffer.toString();
    }
}
