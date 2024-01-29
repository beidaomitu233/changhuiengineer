package File;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

public class File03 {

    public static void main(String[] args) throws IOException {

//       创建多级和单机目录
        File directory = new File("E:\\FileContr\\a\\b\\c\\d");
        if (!directory.exists()) {
            directory.mkdir(); // 创建单级目录
            // 或者使用mkdirs()创建多级目录
            directory.mkdirs();

        }

//      创建文件，如果目录不存在就先创建目录，存在则直接创建文件，文件如果已存在则先确认删除再创建。
        FileContr create1 = new FileContr("E:\\FileContr\\a\\b\\c\\d\\ff\\newfile.txt");
        try {
            if (create1.processFileCreation()) {
                System.out.println("接下来将进行文件信息查询");
                create1.CheckFileINfo();

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}
class FileContr {
    // 确保目录路径以文件分隔符结束
    private final String filePath;
    private final File file;
    public FileContr(String filePath) {
        if (filePath == null || filePath.isEmpty()) {
            throw new IllegalArgumentException("File path cannot be null or empty");
        }
        this.filePath = filePath;
        this.file = new File(filePath);
    }

    public boolean processFileCreation() throws IOException {
        CreatedirectoryExists(); // Ensure the directory exists before checking file existence
        CheackFileExists(); // Check if the file exists and handle user input
        CreateFile(); // Create the file if it doesn't exist
        return true;
    }

    public void  CreateFile() throws IOException {
        //       检测目录是否存在，存在就直接创建文件，不存在就创建目录再创建文件
            // 尝试创建文件
                if (file.createNewFile())      System.out.println(file.getName()+"文件创建成功");
        }


    public void CheackFileExists() throws IOException {
        if(file.exists()){
            //      如果文件已存在就提示用户是否删除软件并创建新的，是输入y否则输入/n
            System.out.println(file.getName()+"文件已存在于"+file.getParentFile()+"，是否要删除如果是，输入y否则输入/n");

            Scanner scanner = new Scanner(System.in);
            String DealFileConfimere = scanner.nextLine(); // 接收字符串输入

            if (DealFileConfimere.equals("y")){
                    if(file.delete()) {
                        System.out.println("文件已删除");
                        CreateFile();
                    }
            }else {
                System.out.println("操作已取消");
            }
        }

    }

    public void CreatedirectoryExists(){
        // 检查父目录是否存在
        File parentDir = file.getParentFile();
        System.out.println(parentDir);
        if (parentDir != null && !parentDir.exists()) {
                // 如果父目录不存在，则创建所有必需的父目录
                parentDir.mkdirs();
                System.out.println(file.getParentFile()+"文件目录不存在，已经创建完毕");
        }
    }


    public void CheckFileINfo(){

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




