package root;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.Pianist;

public class Start {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");

        Pianist pianist1 = (Pianist) context.getBean("pianist");
//        Pianist pianist2 = (Pianist) context.getBean("pianist");
        pianist1.playMusic();

////        System.out.println("---------------------");
////        pianist2.playMusic();

    }
}
