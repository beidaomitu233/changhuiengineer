package TimeType;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class LocalTime {
    public static void main(String[] args) {
//
//       获取时间日期
        LocalDateTime ldt=LocalDateTime.now();
        System.out.println(ldt);

        System.out.println(ldt.getHour());
        System.out.println(ldt.getMinute());
        System.out.println(ldt.getSecond());

//        格式化日期
        System.out.println("格式化后的日期");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        String t1=formatter.format(ldt);
        System.out.println(t1);

        System.out.println("获取时间戳");
//        获取时间戳
        long currentTimeMillis = Instant.now().toEpochMilli();
        System.out.println(currentTimeMillis);

//        对当前时间进行加减，例如计算 会员到期时间
        LocalDateTime AfterOneMonth = ldt.plusDays(31);
        LocalDateTime BeforeOneMonth = ldt.minusDays(31);
        System.out.println("当前时间是"+ldt);
        System.out.println("一个月后和一个月前");
//        格式化后在输出
        String s1=formatter.format(AfterOneMonth);
        System.out.println(t1);
        String s2=formatter.format(BeforeOneMonth);
        System.out.println(s2);

    }
}
