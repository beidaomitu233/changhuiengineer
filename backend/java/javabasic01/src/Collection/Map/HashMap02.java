package Collection.Map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMap02 {
    public static void main(String[] args) {

        /**
         *
         * 实现案例：
         * 使用HashMap添加3个员工对象，要求
         * 键：员工id
         * 值：员工对象
         * 并遍历显示工资>4500的员工（遍历方式最少两种）
         * 员工类：姓名、工资、员工d
         *
         *
         *
         * **/

        Map hashmap02=new HashMap();

        hashmap02.put("niuma001",new Emp("牛马打工人1","niuma001",4000));
        hashmap02.put("tianxuan001",new Emp("天选打工人1","tianxuan001",14000));
        hashmap02.put("niuma002",new Emp("牛马打工人2","niuma002",4500));
        hashmap02.put("niuma003",new Emp("牛马打工人3","niuma003",4700));
        hashmap02.put("niuma004",new Emp("牛马打工人4","niuma004",4070));

        Set keyset=hashmap02.keySet();
        Iterator iterator=keyset.iterator();
        while (iterator.hasNext()) {
            Object key =  iterator.next();
//           将获取到的的value转化为emp对象方便获取对象数据。
            Emp emp =(Emp)hashmap02.get(key);
            if(emp.getEmpSalary()>=4500){
                System.out.println(emp);
            }

        }


    }
}

class Emp{
    public String EmpName;

    public String EmpID;

    public String getEmpName() {
        return EmpName;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "EmpName='" + EmpName + '\'' +
                ", EmpID='" + EmpID + '\'' +
                ", EmpSalary=" + EmpSalary +
                '}';
    }

    public void setEmpName(String empName) {
        EmpName = empName;
    }

    public String getEmpID() {
        return EmpID;
    }

    public void setEmpID(String empID) {
        EmpID = empID;
    }

    public int getEmpSalary() {
        return EmpSalary;
    }

    public void setEmpSalary(int empSalary) {
        EmpSalary = empSalary;
    }

    public Emp(String empName, String empID, int empSalary) {
        EmpName = empName;
        EmpID = empID;
        EmpSalary = empSalary;
    }

    public int EmpSalary;

}