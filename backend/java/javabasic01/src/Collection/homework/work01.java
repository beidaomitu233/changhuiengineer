package Collection.homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class work01 {


    public static void main(String[] args) {
        /**
         *
         * 按要求实现：
         * (1)封装一个新闻类，包含标题和内容属性，提供get、set方法，重写toString方法，打印对象时只打印标题；
         * (②)只提供一个带参数的构造器，实例化对像时，只初始化标题；并且实例化两个对象：
         * 新闻一：新冠确诊病例超干万，数百万印度教信徒赴恒河“圣浴”引民众担忧
         * 新闻二：男子突然想起2个月前钓的鱼还在网兜里，捞起一看赶紧放生
         * (3)将新闻对象添加到ArrayList集合中，并且进行倒序遍历；
         * (4)在遍历集合过程中，对新闻标题进行处理，超过15字的只保留前15个，然后在后边加”.…'
         * (⑤)在控制台打印遍历出经过处理的新闻标题；
         *
         *
         * **/

        List<News> list=new ArrayList();
        list.add(new News("新冠确诊病例超干万，数百万印度教信徒赴恒河“圣浴”引民众担忧"));
        list.add(new News("男子突然想起2个月前钓的鱼还在网兜里，捞起一看赶紧放生"));

//       先倒叙再遍历效果一样
        Collections.reverse(list);

        Iterator iterator=list.iterator();
        while (iterator.hasNext()) {
            News news = (News) iterator.next();
            if (news.getNewsTitle().length()>15){
                System.out.println(news.getNewsTitle().substring(0, 15)+".......");
            }else  System.out.println(news);

        }


    }




}

class News{
    public String NewsTitle;

    public  String NewsContent;

    @Override
    public String toString() {
        return "新闻：'" + NewsTitle ;
    }

    public News(String newsTitle) {
        NewsTitle = newsTitle;
    }

    public String getNewsTitle() {
        return NewsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        NewsTitle = newsTitle;
    }

    public String getNewsContent() {
        return NewsContent;
    }

    public void setNewsContent(String newsContent) {
        NewsContent = newsContent;
    }
}