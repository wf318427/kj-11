package cn.tedu.test;

import cn.tedu.annotation.Age;
import cn.tedu.annotation.MyComponent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Administrator on 18.1.7.
 */
@Configuration
public class ComponentAnnotationTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.register(ComponentAnnotationTest.class);
        annotationConfigApplicationContext.refresh();
        InjectClass injectClass = annotationConfigApplicationContext.getBean(InjectClass.class);
        injectClass.print();
    }
    @MyComponent("ssss")
    public static class InjectClass {
        @Age
        String name;
        public void print() {
            System.out.println("hello world"+name);
        }
    }
}

