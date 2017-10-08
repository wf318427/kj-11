package cn.tedu.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by Administrator on 17.10.8.
 */
@RestController
public class MainController {
    @RequestMapping("hello")
    public String hello(){
        return "hello";
    }
}
