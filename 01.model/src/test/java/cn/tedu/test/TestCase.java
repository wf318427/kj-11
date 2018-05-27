package cn.tedu.test;

import cn.tedu.StartApp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Administrator on 17.10.14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = StartApp .class)
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "test")
public class TestCase {
    @Value("${spring.name}")
    String name;
    @Test
    public void test(){
        System.out.println(name);
    }
}
