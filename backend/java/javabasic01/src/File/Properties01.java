package File;

import java.io.*;
import java.util.Properties;

public class Properties01 {
    public static void main(String[] args) throws IOException {

//        创建proper文件并设置属性.
        Properties properties = new Properties();

//       先设置属性和值
        properties.setProperty("UserName","beidao23");
        properties.setProperty("PassWorld","lzc");
        properties.setProperty("Device","PC");

//       存储
        properties.store(new FileWriter("E:\\FileContr\\a\\UserInfo.properties"),"用户信息");

//        加载这个proper文件,并遍历打印在控制台

        properties.load(new FileReader("E:\\FileContr\\a\\UserInfo.properties"));
        properties.list(System.out);

//        获取单个属性,返回的是字符串
        String Uinfo=  properties.getProperty("UserName");
        System.out.println(Uinfo);

//       修改属性值
        properties.setProperty("UserName","beidao232");
        String Uinfo2=  properties.getProperty("UserName");
        System.out.println(Uinfo2);




    }
}
