import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pri.rong.config.Config1;
import pri.rong.pojo.User;

/**
 * @description：
 * @auther lurongrong
 * @create 2021-06-06 15:37
 */
public class MyTest {
    public static void main(String[] args) {
        //如果完全使用了配置类的方式去做，我们就只能通过AnnotationConfig上下文来获取容器，通过配置类的class对象加载！

        ApplicationContext context = new AnnotationConfigApplicationContext(Config1.class);
        User getUser = (User) context.getBean("user");
        System.out.println(getUser.getName());
    }
}
