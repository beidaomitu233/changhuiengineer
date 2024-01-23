public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        System.out.println("饿汉式");
//     饿汉式：先创建对象 直接调用,不需要实例化
        IdNumber  id=  IdNumber.getId();
        System.out.println(id);

        System.out.println("懒汉式");
//      懒汉式：调用在创建对象、
        System.out.println(CreateChat.MessageList);
//      调用才创建对象
        CreateChat.getInstance();

    }
}

//Single mode
//饿汉式
//外部不能创建对象，但是可以调用对象。
class IdNumber{
//    1.定义属性
    private int  PersonAlId;
//  在类的内部创建对象,为了能在静态方法中返回对象，需要修饰为static
    private static IdNumber id=new IdNumber(450122222);

//   2. 定义私有构造器
    private IdNumber(int personAlId) {
        PersonAlId = personAlId;
    }

    @Override
    public String toString() {
        return "IdNumber{" +
                "PersonAlId=" + PersonAlId +
                '}';
    }

    //    向外暴露创建好的对象,加static的目的是为了不创建对象创建方法
    public static IdNumber getId() {
        return id;
    }
}

//懒汉式

class CreateChat{
    public static String  MessageList="dasdas";

    //提前声明CreateChat类方便后续使用
    private static CreateChat ChatStrat;

    private CreateChat(String messageList) {
        MessageList = messageList;
        System.out.println("创建对象");
    }

    @Override
    public String toString() {
        return "CreateChat{" +
                "MessageList='" + MessageList + '\'' +
                '}';
    }

    //    只有在调用getInstance时才会创建对象并且返回
    public static CreateChat getInstance(){
        if (ChatStrat==null){
            ChatStrat= new CreateChat("mwqe");
        }
        return  ChatStrat;

    }

}

