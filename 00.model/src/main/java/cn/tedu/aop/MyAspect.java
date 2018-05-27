package cn.tedu.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 17.10.8.
 */
@Aspect
@Component
public class MyAspect {

    /**
     * 定义拦截规则：拦截com.xjj.web.controller包下面的所有类中，有@RequestMapping注解的方法。
     */
    @Pointcut("execution(public * cn.tedu.service.WeatherService.getWeatherByCity(..))")
    public void controllerMethodPointcut(){}
    @Before("controllerMethodPointcut()")
    public void before(){
        System.out.println("aopaopaoapoaa");

    }
}
