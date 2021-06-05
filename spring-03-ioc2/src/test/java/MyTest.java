import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pri.rong.pojo.User;

/**
 * @description：
 * @auther lurongrong
 * @create 2021-06-05 15:38
 */
public class MyTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        User user = (User) context.getBean("user2");
        user.show();
        System.out.println();
    }
}
