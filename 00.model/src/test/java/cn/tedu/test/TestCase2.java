package cn.tedu.test;

import cn.tedu.service.WeatherService;
import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by Administrator on 17.10.8.
 */
public class TestCase2 {
    @Test
    public void test(){
        Enhancer en=new Enhancer();
        en.setSuperclass(WeatherService.class);
        en.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o,
                                    Method method,
                                    Object[] objects,
                                    MethodProxy methodProxy) throws Throwable {
                System.out.println("before");
                Object returnValue=methodProxy.invokeSuper(o,objects);
                System.out.println("after");
                return returnValue;
            }
        });
        //获取代理对象
        WeatherService weatherService= (WeatherService) en.create();
        String s=weatherService.getWeatherByCity("南京");
        System.out.println(s);
    }
}
