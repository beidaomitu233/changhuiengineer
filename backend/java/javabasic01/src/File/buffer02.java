package File;

import java.io.*;

public class buffer02 {
    public static void main(String[] args) {

        copyFule();
    }

    public static void copyFule(){

        String FilePath="E:\\星环AI课程大纲.pdf";
        String FilePath2="E:\\b\\星环AI课程大纲.pdf";

        //       复制二进制文件，使用bufferedInpt和Output
        BufferedInputStream bufferedInputStream=null;
        BufferedOutputStream bufferedOutputStream=null;

        try {

            bufferedInputStream=new BufferedInputStream(new FileInputStream(FilePath));
            bufferedOutputStream=new BufferedOutputStream(new FileOutputStream(FilePath2));

            int FileDateLenth;

            byte[] bytes = new byte[1024];

//          将读取到的内容写入到bytes中，内容长度赋值给FileDateLenth，InputStream.read方法的参数就是缓冲，写入内容的。
            while ((FileDateLenth=bufferedInputStream.read(bytes))!=-1){
                bufferedOutputStream.write(bytes,0,FileDateLenth);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedInputStream!=null&&bufferedOutputStream!=null){
                try {
                    bufferedInputStream.close();
                    bufferedOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

        }


    }
}


