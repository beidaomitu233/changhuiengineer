package File;

import java.io.File;
import java.util.Date;

public class File02 {
    public static void main(String[] args) {
//        获取文件的相关信息需要先读取文件对象
//
//       设置文件路径
        String FileName="E:\\newfile2.txt";

        File file = new File(FileName);

//      获取文件名
        System.out.println("文件名："+file.getName());

//        获取绝对路径
        System.out.println("绝对路径:" + file.getAbsoluteFile());

//        获取文件大小
        System.out.println("文件大小，以字节为单位：" + file.length());

        // 查看是否是文件
        System.out.println("是否是文件" + file.isFile());

        // 查看是否是目录
        System.out.println("是否目录" + file.isDirectory());

        // 查看是否可读。
        System.out.println("是否可读" + file.canRead());

        // 查看是否可写
        System.out.println("是否可写" + file.canWrite());

        // 最近一次修改时间戳（毫秒值）
        long lastModifiedTime = file.lastModified();
        Date date = new Date(lastModifiedTime);
        System.out.println("最近修改时间: " + date);




    }
}
