package pri.rong.service;

import pri.rong.dao.UserDao;
import pri.rong.dao.UserDaoImpl;
import pri.rong.dao.UserDaoMysqlImpl;
import pri.rong.dao.UserDaoOracleImpl;

/**
 * @description：
 * 之前，程序是主动创建对象，控制权在程序员的手上
 * 使用了set注入之后，程序不在具有主动性，而是变成了被动的接受对象。
 * @auther lurongrong
 * @create 2021-06-04 0:08
 */
public class UserServiceImpl implements UserService{
//    private UserDao userDao = new UserDaoOracleImpl();
    private UserDao userDao;
    //利用set进行动态实现值的注入！
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void getUser() {
        userDao.getUser();
//        System.out.println("UserServiceImpl");
    }
}
