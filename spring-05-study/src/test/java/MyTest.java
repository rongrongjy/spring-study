import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pri.rong.pojo.People;

/**
 * @description：
 * @auther lurongrong
 * @create 2021-06-06 10:12
 */
public class MyTest {
    public static void main(String[] args) {

    }
    @Test
    public void test()  {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        People people = (People) context.getBean("People", People.class);
        people.getCat().shout();
        people.getDog().shout();




























    }
}
