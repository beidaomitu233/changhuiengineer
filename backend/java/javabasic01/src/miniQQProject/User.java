package miniQQProject;

import java.io.Serializable;

//实现序列化接口，保存数据时保存值和对象
public class User  implements Serializable {
    private static final long serialVersionUID = 1L; // 用于保持序列化兼容性

    private String UserId;
    private String PassWd;

    public User(String userId, String passWd) {
        UserId = userId;
        PassWd = passWd;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getPassWd() {
        return PassWd;
    }

    public void setPassWd(String passWd) {
        PassWd = passWd;
    }
}
