package cn.tedu.test;

import cn.tedu.annotation.Age;
import cn.tedu.annotation.FruitName;
import cn.tedu.annotation.Name;
import cn.tedu.entity.Apple;
import cn.tedu.entity.Emp;
import cn.tedu.utils.FruitInfoUtil;
import org.junit.Test;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 18.1.7.
 */
public class AnnotationStartTest {
    /**
     * 自定义注解学习
     */
    @Test
    public void test(){
       // FruitInfoUtil.getFruitInfo(Apple.class);
        //getDeclaredFields 获取所有字段
        //getFields 获取public 字段
        Field[] fields=Apple.class.getDeclaredFields();

        for(Field field:fields){
            if(field.isAnnotationPresent(FruitName.class)){
                FruitName fruitName = (FruitName) field.getAnnotation(FruitName.class);
                System.out.println(fruitName.value());
            }
        }
        Name name=Apple.class.getAnnotation(Name.class);
        if (name.value().equals("")){
            System.out.println(Apple.class.getSimpleName());
        }
        try {
            Method method=Apple.class.getMethod("ff");
            Age age=method.getAnnotation(Age.class);
            System.out.println(age.age());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }

}
