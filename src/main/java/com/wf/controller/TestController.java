package com.wf.controller;


import com.wf.utils.ResultJson;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

@RestController
public class TestController {

    private static int count=0;

    @RequestMapping("/download")
    public ResultJson<String> allUser(String urls, String paths) {
        if (null == urls || null == paths) {
            return new ResultJson<>("下载路径或者下载链接不能为空");
        }
        paths = paths + "\\download"+count+".pdf";
        try {
            URL url = new URL(urls);
            URLConnection urlConnection = url.openConnection();
            InputStream inputStream = urlConnection.getInputStream();
            byte[] buff = new byte[10240];
            int temp;
            FileOutputStream outputStream = new FileOutputStream(paths);
            while ((temp = inputStream.read(buff)) != -1) {
                outputStream.write(buff, 0, temp);
            }
            count++;
            outputStream.close();
            inputStream.close();
        } catch (Exception e) {
            return new ResultJson<>("程序出错，可能方法失效，或者操作有误！错误信息" + e.getMessage());
        }
        return new ResultJson<>("下载成功");
    }

}
