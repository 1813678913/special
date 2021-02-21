package com.wf.controller;


import com.wf.utils.ResultJson;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.net.URL;

@RestController
public class TestController {

    private static int count = 0;

    @GetMapping("/download")
    public void allUser(String url, String name, HttpServletResponse response) throws Exception {
        String index = url.substring(url.lastIndexOf("."));
        String fileName = "download" + count + index;
        if (null != name) {
            fileName = name+index;
        }
        response.setHeader("Content-Disposition", "attachment;filename="+java.net.URLEncoder.encode(fileName, "utf-8"));
        URL urls = new URL(url);
        InputStream inputStream = urls.openConnection().getInputStream();
        byte[] buffer = new byte[1024];
        int len;
        ServletOutputStream outputStream = response.getOutputStream();
        while ((len = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, len);
        }
        count++;
        outputStream.close();
        inputStream.close();
    }
}