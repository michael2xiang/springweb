package com.imooc.web1;

import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Calendar;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class JodaTime {

    /**
     * 参考资料
     * https://www.ibm.com/developerworks/cn/java/j-jodatime.html
     */
    @Test
    public  void newObj()
    {
        //方式一
        DateTime dateTime = new DateTime(2000, 1, 1, 0, 0, 0, 0);

        //方式二  Date与 DateTime 互操作
        Date jdkDate = new Date();
        DateTime formJdkDate = new DateTime(jdkDate);

        Date jdkDateFromDatetime = formJdkDate.toDate();


        //方式三 Calendar与 DateTime 互操作
        Calendar calendar = Calendar.getInstance();
        calendar.set(2000, Calendar.JANUARY, 1, 0, 0, 0);
        DateTime datetimeFromCalendar= new DateTime(calendar);

        Calendar calendarFromDatetime = Calendar.getInstance();
        calendarFromDatetime.setTime(datetimeFromCalendar.toDate());

        //方式四
        String timeString = "2006-01-26T13:30:00-06:00";
        DateTime dateTimeFromStr = new DateTime(timeString);

        timeString = "2006-01-26";
        DateTime dateTimeFromStr2 = new DateTime(timeString);

        timeString = "2006-01-26T13:30:00";
        DateTime dateTimeFromStr3 = new DateTime(timeString);
        System.out.println("dateTimeFromStr3:"+dateTimeFromStr3);
    }

    @Test
    public void plusOrMinus()
    {
        DateTime dateTime = new DateTime(2000, 1, 1, 0, 0, 0, 0);
        DateTime after = dateTime.plusYears(1).plusMonths(2).plusDays(3).minusHours(4).minusMinutes(5).minusSeconds(6);
        log.info(after.toString("yyyy-MM-dd HH:mm:ss"));
    }


}
