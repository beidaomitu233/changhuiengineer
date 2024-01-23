package StringBufferType;

public class Stringbuffer01 {
    public static void main(String[] args) {

//创建StringBuffer对象
        StringBuffer sb1=new StringBuffer("adsadsd");
        System.out.println(sb1);
//转化为String
        String sb2=sb1.toString();
//创建StringBuffer传入sb2字符串
        StringBuffer sb4=new StringBuffer(sb2);
//再转化为字符串
        String sb5=new String(sb4);
        System.out.println(sb5);


    }
}
