package com.wf.test;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class DownLoadTest {

    private static String url ="http://newad.abiechina.com/group1/M00/AC/B3/rBAMvl7Ej8-AVRzUAFpvXneHT7A424.pdf";
    private static String url1="http://newad.abiechina.com/group1/M00/AC/B3/rBAMvl7Ej8-AVRzUAFpvXneHT7A424.pdf";
    public static void main(String[] args) throws Exception {
        URL urls = new URL(url1);
        URLConnection urlConnection = urls.openConnection();
        InputStream inputStream = urlConnection.getInputStream();
        byte[] buff = new byte[1000024];
        int temp;
        FileOutputStream outputStream = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\test1.pdf");
        while ((temp = inputStream.read(buff)) != -1) {
            outputStream.write(buff, 0, temp);
        }

    }

}
