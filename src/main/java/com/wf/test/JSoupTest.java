package com.wf.test;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class JSoupTest {

    private static String url = "http://newad.abiechina.com/group1/M00/AC/B3/rBAMvl7Ej8-AVRzUAFpvXneHT7A424.pdf";

    public static void main(String[] args) throws Exception {

        Document document = Jsoup.connect("http://www.baidu.com").get();

    }

}
