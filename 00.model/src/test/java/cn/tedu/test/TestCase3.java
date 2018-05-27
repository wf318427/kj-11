package cn.tedu.test;

import cn.tedu.service.WeatherService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 17.10.8.
 */
public class TestCase3 extends TestBase {
    @Autowired
    WeatherService weatherService;
    @Test
    public void test(){
        String s=weatherService.getWeatherByCity("内蒙古");
        System.out.println(s);
    }
}
