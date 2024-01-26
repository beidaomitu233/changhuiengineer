package Draw;

import javax.swing.*;
import java.awt.*;

public class draw01 extends JFrame {  // JFrame是画框，框上有板，板上才能画

//   定义面板
  private MyPanel mp=null;
    public static void main(String[] args) {

        new draw01();
    }

    public draw01(){
        mp=new MyPanel();
//      将画板放入画框
        this.add(mp);
//        设置窗口大小
        this.setSize(400,300);
//        设置可见
        this.setVisible(true);

    }

}

// 先创建一个画板
class  MyPanel extends JPanel{

    /**
     * JPanel  是画板
     * Graphics 相当于画笔，提供了很多绘画方法
     *
     * **/

    //绘图方法
    @Override
    public void paint(Graphics g) {
        //调用父类的方法完成初始化
        super.paint(g);
        g.drawOval(10,10,100,100);
    }


}
