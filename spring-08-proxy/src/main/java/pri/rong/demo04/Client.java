package pri.rong.demo04;

import pri.rong.demo02.UserService;
import pri.rong.demo02.UserServiceImpl;

/**
 * @description：
 * @auther lurongrong
 * @create 2021-06-07 20:28
 */
public class Client {
    public static void main(String[] args) {
        //真实角色（必有）
        UserServiceImpl userService = new UserServiceImpl();

        //代理角色，不存在
        ProxyInvocationHander hander = new ProxyInvocationHander();

        hander.setTarget(userService);//设置要代理的对象

        //动态生成代理对象
        UserService proxy = (UserService) hander.getProxy();

        proxy.add();
    }
}
