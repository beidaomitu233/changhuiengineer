package TimeType;

import java.util.Calendar;

public class Calendat {
    public static void main(String[] args) {
        Calendar calendar1 = Calendar.getInstance();
        System.out.println(calendar1);

//        两种获取方式
        System.out.println(calendar1.getWeekYear());
        System.out.println(calendar1.get(Calendar.YEAR));
//        月份从0开始计算,所以要+1
        System.out.println(calendar1.get(Calendar.MONTH)+1);
    }
}
