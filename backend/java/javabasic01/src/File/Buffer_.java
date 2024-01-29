package File;

import java.io.*;

public class Buffer_ {
    static BufferedReader bufferedReader=null;
    static BufferedWriter bufferedWriter=null;
    static String  path;
    static String FileDate;
    public static void main(String[] args) throws IOException {

        BufferRead();
        BufferWrite();
        CopyFileMet();
    }

    public static void BufferRead() throws IOException {
//        使用Buffer更高效的方式进行读文件

         path="E:\\newfile.txt";


        try {
//          想要读取什么样类型的文件就传输对应的对象方法给Buffer即可
            bufferedReader = new BufferedReader(new FileReader(path));
//           直接读一行，效率更高。
            while ((FileDate=bufferedReader.readLine())!=null){
                System.out.println(FileDate);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            // 关闭流，这里注意，只需要关闭BufferedReader,因为底层会自动的去关闭节点流
            bufferedReader.close();
        }
    }

    public static  void BufferWrite() throws IOException {
         path="E:\\newfile2.txt";
//      追加模式
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(path,true));
            bufferedWriter.write("buffer写入");
//          需要手动写入换行
            bufferedWriter.write("\n");
            bufferedWriter.write("buffer写入");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            bufferedWriter.close();
        }
    }

    public  static void CopyFileMet () throws IOException {
//        实现非二进制文件的复制
        String SourcePath="E:\\newfile2.txt";
        path="E:\\b\\newfile2.txt";

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(SourcePath));
             BufferedWriter  bufferedWriter     =new BufferedWriter(new FileWriter(path))) {
//            将读取的文件内容存储到变量中，等于null时读完
            while ((FileDate=bufferedReader.readLine())!=null) {
//                写入
                bufferedWriter.write(FileDate,0,FileDate.length());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (bufferedWriter!=null&&bufferedReader!=null){

                try {
                    bufferedReader.close();
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }


    }


}

