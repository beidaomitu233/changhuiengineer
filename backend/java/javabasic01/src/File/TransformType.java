package File;

import java.io.*;

public class TransformType {
    public static void main(String[] args) throws IOException {
//        read Gbk
        TransformFile01();
//        gbk->UTF-8
        TransformFile02();

    }

    public static void TransformFile01() throws IOException {
        //       以GBK格式读取txt文件，默认是UTF-8

        String path="E:\\FileContr\\a\\1.txt";
        BufferedReader bufferedReader=null;

//        连写写法， 先创建FileInputStream对象，传给InputStreamReader并设置读取字符，在转化为Buffer提高效率。
        try {
            bufferedReader = new BufferedReader( new InputStreamReader(new FileInputStream(path),"gbk"));
            String FileDate;

            while (   (FileDate=  bufferedReader.readLine())!=null){
                System.out.println(FileDate);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (bufferedReader!=null) bufferedReader.close();
        }

    }
    public static void TransformFile02() throws IOException {
        String path="E:\\FileContr\\a\\1.txt";
        String path2="E:\\FileContr\\a\\2.txt";

        BufferedReader bufferedReader=null;
        BufferedWriter bufferedWriter=null;
        String FileDate;

//        连写写法， 先创建FileInputStream对象，传给InputStreamReader并设置读取字符，在转化为Buffer提高效率。
        try {
            bufferedReader = new BufferedReader( new InputStreamReader(new FileInputStream(path),"gbk"));
            //        将该gbk格式的文件转换成utf-8
            bufferedWriter= new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path2),"UTF-8"));
            while (   (FileDate=  bufferedReader.readLine())!=null){
                System.out.println(FileDate);
//                写入一行
                bufferedWriter.write(FileDate,0,FileDate.length());
//                换行
                bufferedWriter.newLine();

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (bufferedReader!=null) {
                bufferedReader.close();
                bufferedWriter.close();
            }
        }
    }
}
