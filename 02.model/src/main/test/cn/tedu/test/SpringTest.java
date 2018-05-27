package cn.tedu.test;

import cn.tedu.annotation.Age;
import cn.tedu.service.CheckService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Administrator on 18.1.7.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring-web.xml")
public class SpringTest {
    @Age(age = "35")
    String string;
    @Test
    public void test(){
        System.out.println(string);
    }

}
