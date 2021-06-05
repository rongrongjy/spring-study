package pri.rong.pojo;

/**
 * @description：
 * @auther lurongrong
 * @create 2021-06-05 10:02
 */
public class Hello {
    private String str;

    public Hello() {
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    @Override
    public String toString() {
        return "Hello{" +
                "str='" + str + '\'' +
                '}';
    }
}
