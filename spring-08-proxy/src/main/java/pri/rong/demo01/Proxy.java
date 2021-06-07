package pri.rong.demo01;

/**
 * @description：
 * @auther lurongrong
 * @create 2021-06-06 20:48
 */
public class Proxy implements Rent{
    private Host host;

    public Proxy() {
    }

    public Proxy(Host host) {
        this.host = host;
    }

    @Override
    public void rent() {
        seeHouse();
        host.rent();
    }

    //看房
    public void seeHouse(){
        System.out.println("中介带着看房");
    }

    //收中介费
    public void fare(){
        System.out.println("收中介费");
    }
}
