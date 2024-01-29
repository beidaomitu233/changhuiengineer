package File;

import java.io.*;

public class IO {
    static String  source=null;
    static String destination=null;
    public static void main(String[] args) {

//       实现输入输出案例，完成一个图片的赋值和粘贴
        source="E:\\FileContr\\a\\imgfile.jpg";
        destination="E:\\FileContr\\b\\zfile.jpg";
        CopyFile(source,destination);
    }

    public static void CopyFile(String source, String destination) {
//      缓冲区，
        byte[] buffer = new byte[1024];
        int lenth;
    //      使用try-with-resources语句，读取和写入完成后自动关闭io
            try(            FileInputStream fileIn = new FileInputStream(source);
                            FileOutputStream fileOut = new FileOutputStream(destination);) {
    //       一边读取一边写入。
    //       当read方法返回值  实际读取的字节数量，  当等于-1时表示文件读完了,
                while ((lenth=fileIn.read(buffer))!=-1){
     //      写入buffer中的内容，从buffer的第0个字节，到第lenth即读取的字节数作为结尾。
                    fileOut.write(buffer,0,lenth);
                }
                System.out.println("文件复制完成！");
            } catch (IOException e) {
    //      使用printStackTrace更适合开发调试，并且不会终止程序
                e.printStackTrace();
                System.out.println("文件复制失败");
            }


    }


}

 class CopyImageFile {

     // 使用示例
     public static void main(String[] args) {
         try {
             copyImage("path/to/source/image.png", "path/to/destination/image_copy.png");
         } catch (IOException e) {
             e.printStackTrace();
         }
     }
    public static void copyImage(String sourceFilePath, String destinationFilePath) throws IOException {
        try (FileInputStream fis = new FileInputStream(sourceFilePath);
             FileOutputStream fos = new FileOutputStream(destinationFilePath)) {

            byte[] buffer = new byte[1024];
            int length;

            while ((length = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, length);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("图片复制成功！");
    }


}