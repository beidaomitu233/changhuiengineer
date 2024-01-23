package StringType;

public class string01 {


    public static void main(String[] args) {
        String s1="sadasd";
        String s2=new String("sdasdsa");
        System.out.println(s1.equals(s2));

        String str1 = "one,two,three,four";
        String[] sp1= str1.split(",");
        System.out.println(sp1[1]);

    }
}
