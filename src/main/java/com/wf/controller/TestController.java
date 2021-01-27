package com.wf.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

@RestController
public class TestController {

    @RequestMapping("/download")
    public String allUser(String urls, String path) {
        if (null == urls || null == path) {
            return "下载路径或者下载链接不能为空";
        }
        path = path + "\\download.pdf";
        try {
            URL url = new URL(urls);
            URLConnection urlConnection = url.openConnection();
            InputStream inputStream = urlConnection.getInputStream();
            byte[] buff = new byte[10240];
            int temp;
            FileOutputStream outputStream = new FileOutputStream(path);
            while ((temp = inputStream.read(buff)) != -1) {
                outputStream.write(buff, 0, temp);
            }
            outputStream.close();
            inputStream.close();
        } catch (Exception e) {
            return "程序出错，可能方法失效，或者操作有误！错误信息" + e.getMessage();
        }
        return "下载成功";
    }

}
