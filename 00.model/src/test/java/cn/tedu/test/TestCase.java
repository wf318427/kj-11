package cn.tedu.test;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by Administrator on 17.10.8.
 */
public class TestCase {
    @Test
    /**
     * 静态代理
     */
    public void test(){
        UserDao dao=new UserDao();
        UserDaoProxy poxy=new UserDaoProxy(dao);
        poxy.save();
    }
    @Test
    /**
     * jdk动态代理
     */
    public void test1(){
        final  UserDao dao=new UserDao();
        IUserDao proxy= (IUserDao) Proxy.newProxyInstance(dao.getClass().getClassLoader(),
                dao.getClass().getInterfaces(), new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("前");
                Object returnValue=method.invoke(dao,args);
                System.out.println("后");
                return returnValue;
            }
        });
        proxy.save();
    }
}
interface IUserDao {

    void save();
}
/**
 * 接口实现
 * 目标对象
 */
class UserDao implements IUserDao {
    public void save() {
        System.out.println("----已经保存数据!----");
    }
}
/**
 * 代理对象,静态代理
 */
class UserDaoProxy implements IUserDao{
    //接收保存目标对象
    private IUserDao target;
    public UserDaoProxy(IUserDao target){
        this.target=target;
    }

    public void save() {
        System.out.println("开始事务...");
        target.save();//执行目标对象的方法
        System.out.println("提交事务...");
    }
}
