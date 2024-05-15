package miniQQProject.Client;

import java.io.Serializable;

public class Message implements Serializable {
    private static final long serialVersionUID = 1L; // 用于保持序列化兼容性

    private String Sender;  //发送者

    private String Getter;  //接收者

    private String Content; //内容

    private String SentTime; //发送事件

    private String MesType; //消息类型（可能会发送文件）




}
