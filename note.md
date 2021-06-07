##注解说明
在开发中简单的配置使用注解，太过复杂的还是使用xml配置文件
- @Autwired：自动装配通过类型，名字
- @Nullable 字段标记了这个注解，说明这个字段可以为null；
- @Resource：自动装配通过名字，类型
  

- @Component：组件，放在类上，说明这个类被Spring管理了，就是bean！！！
（使用了@Component，getBean()的时候取的是类的小写的名字）

## 使用注解开发
在Spring4之后，要使用注解开发，必须要保证aop包导入
使用注解需要导入context（上下文）约束，增加注解的支持

使用@Component系列是为了创建对象，方便管理对象，@Autwired是为了赋值

bean可以管理别人写的类，component只能管理自己写的类
1. bean
   
2. 属性如何注入
   在实行上使用注解@Value("属性值")
3. 衍生的注解
   @Repository、@Service、@Controller加上这三个说明这个文件就被spring给托管了
   实现自动装配的功能
   @Component有几个衍生的注解，我们在web开发中，会按照MVC三层架构分层
   * dao【@Repository】@Repository和@Component的功能是一样的，但一般在dao层用@Repository来
     代替@Component
   * service【@Service】
   * controller【@Controller】
     
4. 自动装配置
   在开发中简单的配置使用注解，太过复杂的还是使用xml配置文件
- @Autwired：自动装配通过类型，名字
- @Nullable 字段标记了这个注解，说明这个字段可以为null；
- @Resource：自动装配通过名字，类型
5. 作用域
   @Scope  放在类上，默认是单例模式
   @Scope(prototype)是原型模式，每次创建的都是一个新的对象
6. 小结

xml与注解：
* xml更加万能，适用于任何场合，维护简单方便
* 注解不是自己类使用不了，维护相对复杂
xml与注解最佳实践：
  * xml用来管理bean
  * 注解只负责完成属性的注入
  * 我们在使用的过程中，只需要注意一个问题：必须让注解生效，就需要开启注解的支持
   ```
  <!--指定要扫描的包，这个包下的注解就会生效-->
   <context:component-scan base-pakage="需要指定的包的名称"/>
  <context:annotation-config/>
  ```
  ## 使用Java的方式配置spring

我们现在要完全不适用spring的xml配置了，全权交给java来做！

JavaConfig是Spring的一个子项目，在spring4之后，它成为了一个核心的功能！

实体类：
```package pri.rong.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @description：
 * @auther lurongrong
 * @create 2021-06-06 15:30
 *
 */
//这里这个注解的意思，就是说明这个类被spring接管了，注册到了容器中
@Component
public class User {
    private String name;

    public String getName() {
        return name;
    }
    @Value("赵丽颖")//属性注入值
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}

```
配置文件：

```package pri.rong.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import pri.rong.pojo.User;

/**
 * @description：
 * @auther lurongrong
 * @create 2021-06-06 15:33
 */
//这个也会被spring容器托管，注册到容器中，因为他本来就是一个@Component
//@Configuration代表这是一个配置类，就和我们之前看到的beans.xml
@Configuration
@ComponentScan("pri.rong.pojo")
@Import(Config2.class)
public class Config1 {

    //注册一个bean，就相当于我们之前写的一个bean标签
    //这个方法的名字，就相当于bean标签中的id属性
    //这个方法的返回值，就相当于bean标签中的class属性

    @Bean
    public User getUser(){
        return new User();//就是返回要注入的bean对象
    }
}

```
   
测试类：
```import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pri.rong.config.Config1;
import pri.rong.pojo.User;

/**
 * @description：
 * @auther lurongrong
 * @create 2021-06-06 15:37
 */
public class MyTest {
    public static void main(String[] args) {
        //如果完全使用了配置类的方式去做，我们就只能通过AnnotationConfig上下文来获取容器，通过配置类的class对象加载！

        ApplicationContext context = new AnnotationConfigApplicationContext(Config1.class);
        User getUser = (User) context.getBean("user");
        System.out.println(getUser.getName());
    }
}
```

这种纯java的配置方式，在springBoot中随处可见！！！


## 代理模式
在不修改原有代码的基础上，对原有代码进行修改 
中介。
为什么要学习代理模式？

因为这是springAop的底层【springAOP和springMVC】

代理模式的分类：
* 静态代理
  角色分析：
    * 抽象角色：一般会使用接口或者抽象类来解决
        * 真实角色：被代理的角色
        * 代理角色：代理真实角色，代理真实角色后，我们一般会做一些附属操作
        * 客户：访问代理对象的人
    
代码步骤：
1.接口
```java 
package pri.rong.demo01;

/**
 * @description：
 * @auther lurongrong
 * @create 2021-06-06 20:40
 */
//租客
public interface Rent {
    public void rent();
}
```


2.真实角色

```java 
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

```
3.代理角色
```java
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

```
4.客户端访问代理角色
```java
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

```

代理模式的好处：
          * 可以使真实角色的操作更加纯粹，不用去关注一些公共的业务
    * 公共也就交给代理角色，实现了业务的分工
    * 公共业务发生扩展的时候，方便集中管理。
    缺点：
      * 一个真实角色就会产生一个代理角色：代码量会翻倍--开发效率会变低
    
* 动态代理