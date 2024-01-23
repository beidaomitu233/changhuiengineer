package TimeType;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;
import java.util.logging.SimpleFormatter;

public class Date0 {
    public static void main(String[] args) {

//       输入默认的时间格式 Tue Jan 23 18:23:36 CST 2024
        Date d1=new Date();
        System.out.println(d1);

//      指定输出格式
        SimpleDateFormat sdf = new SimpleDateFormat(" yyyy-hh:mm:ss E");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss E");
        SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd; HH:mm:ss E");

        String format1 = sdf.format(new Date()); // 假设 d1 是一个 Date 类型的对象
        String format2=sdf2.format(d1);
        String format3=sdf3.format(d1);

        System.out.println(format1);
        System.out.println(format3);



    }
}
