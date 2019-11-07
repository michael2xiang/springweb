package com.imooc.web1;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StrToDate {
    @Test
    public void toDate() throws ParseException {
        String dateStr = "2019-11-07";
        Date date1 = DateUtil.strToDate(dateStr, "yyyy-MM-dd");
        System.out.println(date1);

        String dateStr2 = "2019-11-07 15:02:43";
        Date date2 = DateUtil.strToDate(dateStr2, "yyyy-MM-dd HH:mm:ss");
        System.out.println(date2);


        if (date1.before(date2)) {
            System.out.println("1<2");
        } else {
            System.out.println("1>2");
        }
    }

    @Test
    public void calender() {
        Calendar c1 = Calendar.getInstance();
        c1.set(2019, Calendar.NOVEMBER, 7);

        Calendar c2 = Calendar.getInstance();
        c2.set(2019, Calendar.NOVEMBER, 8);

        if (c1.before(c2)) {
            System.out.println("1<2");
        } else {
            System.out.println("1>2");
        }
    }
}
