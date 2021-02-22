package com.wf.test;


import com.wf.entry.Test1;
import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TimeTest {

    public static void main(String[] args) throws ParseException {

        List<String> sevenDate = getSevenDate();
        System.out.println(sevenDate);

    }

    public static List<String> getSevenDate() throws ParseException {
        List<String> dateList = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = sdf.parse("2021-01-07");
        for (int i = 0; i < 10; i++) {
            Date date = DateUtils.addDays(parse, -i);
            String formatDate = sdf.format(date);
            dateList.add(formatDate);
        }
        return dateList;
    }

}
