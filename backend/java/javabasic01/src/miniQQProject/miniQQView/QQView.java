package miniQQProject.miniQQView;
import miniQQProject.Utils.Utility;
import org.junit.Test;


public class QQView {


    private  boolean loop=true;
    private  String key="1";

    @Test
    public void SelectFuncMenu(){

        while (loop){
            System.out.println("========欢迎登入miniQQ===========");
            System.out.println("登入系统  输入：1");
            System.out.println("退出系统  输入：2");
            key= Utility.readString(1);
            switch (key){
                case "1" :
                    System.out.println("请输入密码");
                    String UserId=Utility.readString(50);
                    System.out.println("请输入密码");
                    String pwd=Utility.readString(50);

//                  验证用户信息，正确即进入
                    if (true){
                        System.out.println("========欢迎用户"+UserId+"===========");
//                       进入二级菜单后也是可以循环操作
                        while (loop){
                            System.out.println("二级菜单（用户"+UserId+"）");
                            System.out.println("1·显示在线用户列表");
                            System.out.println("2·群发消息");
                            System.out.println("3·私聊消息");
                            System.out.println("4·发送文件");
                            System.out.println("9·退出系统");
                            System.out.println("输入选择");
                            key=Utility.readString(1);
                            switch (key){
                                case "1":
                                    System.out.println("当前用户：");
                                case "2":
                                    System.out.println("群发消息：");

                                case "3":
                                    System.out.println("私聊消息：");

                                case "4":
                                    System.out.println("发送文件：");

                                case "9":
                                    System.out.println("退出系统：");

                            }
                        }
                    }
//                   当账号密码不正确时
                    else {
                        System.out.println("当账号密码不正确时");

                    }





                    break;
                case "9":
                    System.out.println("退出");
                    loop=false;
                    break;
            }

        }
    }


}
