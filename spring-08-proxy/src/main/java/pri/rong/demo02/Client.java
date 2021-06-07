package pri.rong.demo02;

/**
 * @description：
 * @auther lurongrong
 * @create 2021-06-07 17:55
 */
public class Client {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();

        UserServiceProxy proxy = new UserServiceProxy();
        proxy.setUserService(userService);

        proxy.add();
    }
}
