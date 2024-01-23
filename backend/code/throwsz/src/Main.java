class CustomRuntimeException extends RuntimeException {
    public CustomRuntimeException(String message) {
        super(message); // 调用父类的构造函数，将message传递给异常对象
        System.out.println("自定义异常: " + message);
    }
}

// 使用自定义异常的示例
public class Main {
    public static void main(String[] args) {
        try {
            throw new CustomRuntimeException("This is a custom exception message.");
        } catch (CustomRuntimeException e) {
            // 在这里你可以选择处理这个异常，但在自定义异常中已经打印了消息
            e.printStackTrace(); // 打印异常栈跟踪
        }
    }
}
