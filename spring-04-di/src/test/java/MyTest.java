import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pri.rong.pojo.Student;

/**
 * @description：
 * @auther lurongrong
 * @create 2021-06-05 17:14
 */
public class MyTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Student student = (Student) context.getBean("student","address");
        System.out.println(student.toString());
    }
    @Test
    public void test(){

    }
}
