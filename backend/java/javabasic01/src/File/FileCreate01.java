package File;

import java.io.File;
import java.io.IOException;

public class FileCreate01 {
    public static void main(String[] args) {
//        在E盘中创建一个文件

//       设置文件路径
        String FileName="E:\\newfile2.txt";
//      创建文件对象
        File file = new File(FileName);
        if(!file.exists()){
            try {
//               创建文件
                file.createNewFile();
                System.out.println("文件创建成功");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else {
            System.out.println("文件名重复，该已经存在");
        }


    }
}
