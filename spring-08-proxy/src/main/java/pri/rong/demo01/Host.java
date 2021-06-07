package pri.rong.demo01;

/**
 * @description：
 * @auther lurongrong
 * @create 2021-06-06 20:42
 */
//房东
public class Host implements Rent{
    @Override
    public void rent() {
        System.out.println("房东要出租房子！");
    }
}
