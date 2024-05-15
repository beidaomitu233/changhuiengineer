package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BatchProcessingExample {
    static int[] result;
    public static void main(String[] args) {

         int count=0;
        String url = "jdbc:mysql://localhost:3306/zz1?rewriteBatchedStatements=TRUE&&serverTimezone=Asia/Shanghai";
        String user = "beidao21";
        String password = "beidaomitu233";
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            // 禁用自动提交
            connection.setAutoCommit(false);
            String sql = "INSERT INTO batchpro (s1, s2) VALUES (?, ?)";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            // 添加批量操作
            for (int i=0;i<5000000;i++) {
                pstmt.setString(1, "数据");
                pstmt.setString(2, "数据2");
                pstmt.addBatch();
                count++;
                if (count == 1000) {
                    // 执行批量操作
                    result = pstmt.executeBatch();
                    pstmt.clearBatch();
                    // 提交事务
                    connection.commit();
                    count=0;
                }
            }
            // 处理结果
            for (int i : result) {
                if (i != PreparedStatement.SUCCESS_NO_INFO && i != PreparedStatement.EXECUTE_FAILED) {
                    // 处理成功或失败的语句
                    System.out.println(result);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
