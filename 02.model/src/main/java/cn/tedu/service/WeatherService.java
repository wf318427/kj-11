package cn.tedu.service;

import cn.tedu.entity.Emp;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Created by Administrator on 17.12.24.
 */
public interface WeatherService {
    String getWeatherService(String city);
    void printBean(Emp emp);
    String getXml(Emp emp);
}
