package cn.tedu.test;

import cn.tedu.entity.Emp;
import org.junit.Test;

import java.lang.reflect.Field;

/**
 * Created by Administrator on 18.1.7.
 */
public class TestCase2 {
    @Test
    public void test(){
        Emp emp=new Emp();
        try {
            Field field=emp.getClass().getDeclaredField("name");
            System.out.println(field.getName());
            field.setAccessible(true);
            field.set(emp,"caocao");
            System.out.println(emp.getName());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
