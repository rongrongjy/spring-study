package pri.rong.demo02;

/**
 * @description：
 * @auther lurongrong
 * @create 2021-06-07 17:56
 */
public class UserServiceProxy implements UserService{

    private UserServiceImpl userService;
    //注入对象，使用set方法
    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }

    @Override
    public void add() {
        log("add");
        userService.add();
    }

    @Override
    public void delete() {
        log("delete");
        userService.delete();
    }

    @Override
    public void update() {
        log("update");
        userService.update();
    }

    @Override
    public void query() {
        log("query");
        userService.query();

    }
    //日志方法
    public void log(String str){
        System.out.println("使用了" + str + "方法");
    }
}
