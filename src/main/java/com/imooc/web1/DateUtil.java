package com.imooc.web1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    public static Date strToDate(String strDate, String pattern) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        Date strtodate = formatter.parse(strDate);
        return strtodate;
    }
}
