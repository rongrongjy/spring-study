package pri.rong.demo01;

/**
 * @description：
 * @auther lurongrong
 * @create 2021-06-06 20:45
 */
public class Client {
    public static void main(String[] args) {
//        //租房的人直接找房东租房
//
//        Host host = new Host();
//        host.rent();
        //房东要租房子
        Host host = new Host();
        //代理，中介带房东看房子，但是代理一般会有一些附属操作！
        Proxy proxy = new Proxy(host);
        //租客不用面对房东即可直接找中介租房
        proxy.rent();

    }
}
