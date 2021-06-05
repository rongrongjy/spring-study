import pri.rong.dao.UserDaoMysqlImpl;
import pri.rong.dao.UserDaoOracleImpl;
import pri.rong.service.UserService;
import pri.rong.service.UserServiceImpl;

/**
 * @description：控制反转：IOC(Inversion of Control)是一种设计思想，DI(依赖注入)是实现IoC的一种方法
 *
 * @auther lurongrong
 * @create 2021-06-04 0:12
 */
public class MyTest {
    public static void main(String[] args) {
        //用户实际调用的是业务层，dao层不需要接触
        UserService userService = new UserServiceImpl();
        ((UserServiceImpl) userService).setUserDao(new UserDaoOracleImpl());
        userService.getUser();
    }
}
