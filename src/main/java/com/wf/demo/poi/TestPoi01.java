package com.wf.demo.poi;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.jupiter.api.Test;

import java.io.FileOutputStream;
//03版Excel
public class TestPoi01 {
    private static String path = "D:\\study";

    @Test
    public void test01() throws Exception{
        Workbook workbook = new HSSFWorkbook();
        //创建sheet页名称
        Sheet sheet = workbook.createSheet("学习poi");
        //创建行 0代表第一行
        Row row = sheet.createRow(0);
        //创建1-1列
        Cell cell = row.createCell(0);
        //创建1-2列
        Cell cell1 = row.createCell(1);
        //创建1-3列
        Cell cell2 = row.createCell(2);
        //创建列的内容
        cell.setCellValue("姓名");
        cell1.setCellValue("年龄");
        cell2.setCellValue("爱好");
        //创建行 第二行
        Row row2 = sheet.createRow(1);
        //创建2-1行
        Cell cell3 = row2.createCell(0);
        //创建2-2列
        Cell row1 = row2.createCell(1);
        //创建2-3列
        Cell row21 = row2.createCell(2);
        cell3.setCellValue("张三");
        row1.setCellValue("24");
        row21.setCellValue("向某某");
        FileOutputStream outputStream = new FileOutputStream(path + "03版xls学习.xls");
        //开始写出
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }




}
