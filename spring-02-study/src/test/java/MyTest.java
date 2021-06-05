import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pri.rong.pojo.Hello;

/**
 * @description：
 * @auther lurongrong
 * @create 2021-06-05 10:16
 */
public class MyTest {
    public static void main(String[] args) {
        //获取spring的上下文对象
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
//        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        //我们的对象都在spring中管理了，我们使用直接去里面取出来即可
        //将object对象强转为我们创建的对象Hello
        Hello hello = (Hello) context.getBean("hello");
//        context.getBean("123");
        System.out.println(hello.toString());
    }
}
