package pri.rong.demo02;

/**
 * @description：
 * @auther lurongrong
 * @create 2021-06-07 17:56
 */
public class UserServiceImpl implements UserService{
    @Override
    public void add() {
//        System.out.println("使用了add方法");
        System.out.println("增加用户");
    }

    @Override
    public void delete() {
//        System.out.println("使用了delete方法");

        System.out.println("删除用户");

    }

    @Override
    public void update() {
//        System.out.println("使用了update方法");

        System.out.println("修改用户");

    }

    @Override
    public void query() {
//        System.out.println("使用了query方法");

        System.out.println("查询用户");

    }
}
