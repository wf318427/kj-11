package cn.tedu.service;

import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 17.10.8.
 */
@Service
public class WeatherService {
    public String getWeatherByCity(String city){
        System.out.println(city);
        return city+"\t风和日丽";
    }
    public String getWeatherByCitZone(String zone){
        return zone+"\t该地区大范围将雨";
    }
}
