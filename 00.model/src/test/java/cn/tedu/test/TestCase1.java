package cn.tedu.test;

import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by Administrator on 17.10.8.
 */
public class TestCase1 {
    @Test
    public void test(){
        UserDaocglib target=new UserDaocglib();
        ProxyFactory p=new ProxyFactory(target);
        UserDaocglib dao= (UserDaocglib) p.getProxyInstance();
        dao.save();
    }
    @Test
    public void test1(){
        Enhancer en=new Enhancer();
        en.setSuperclass(UserDaocglib.class);

        en.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o,
                                    Method method,
                                    Object[] objects,
                                    MethodProxy methodProxy) throws Throwable {
                System.out.println("ssssssssss");
                Object object=methodProxy.invokeSuper(o,objects);
                System.out.println("三生三世");
                return object;
            }
        });
        UserDaocglib userDaocglib= (UserDaocglib) en.create();
        userDaocglib.save();
    }
}

class UserDaocglib {
    public void save() {
        System.out.println("----已经保存数据!----");
    }
}
/**
 * Cglib子类代理工厂
 * 对UserDao在内存中动态构建一个子类对象
 */
 class ProxyFactory implements MethodInterceptor {
    //维护目标对象
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    //给目标对象创建一个代理对象
    public Object getProxyInstance(){
        //1.工具类
        Enhancer en = new Enhancer();
        //2.设置父类
        en.setSuperclass(target.getClass());
        //3.设置回调函数
        en.setCallback(this);
        //4.创建子类(代理对象)
        return en.create();

    }

    @Override
    public Object intercept(Object obj,
                            Method method,
                            Object[] args,
                            MethodProxy proxy) throws Throwable {
        System.out.println("开始事务...");

        //执行目标对象的方法
        Object returnValue = method.invoke(target, args);

        System.out.println("提交事务...");

        return returnValue;
    }
}