package com.wf.demo.poi;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;

import java.io.FileOutputStream;

//07版Excel
public class TestPoi02 {
    private static String path = "C:\\Users\\404\\Desktop\\";
    @Test
    public void test01() throws Exception {
        Workbook workbook=new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("我学07版poi");
        //创建行
        Row row = sheet.createRow(0);
        Row row1 = sheet.createRow(1);
        //创建列
        Cell cell = row.createCell(0);
        Cell cell1 = row.createCell(1);
        Cell cell2 = row.createCell(2);
        cell.setCellValue("姓名");
        cell1.setCellValue("年纪");
        cell2.setCellValue("爱好");
        Cell cell3 = row1.createCell(0);
        Cell cell4 = row1.createCell(1);
        Cell cell5 = row1.createCell(2);
        cell3.setCellValue("张万福");
        cell4.setCellValue("24");
        cell5.setCellValue("汪雅茹");
        FileOutputStream outputStream = new FileOutputStream(path+"学习07版.xlsx");
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
        System.out.println("生成完成！");
    }


}
