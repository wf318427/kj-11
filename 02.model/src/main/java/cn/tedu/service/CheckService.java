package cn.tedu.service;

import cn.tedu.annotation.MyLog;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 18.1.7.
 */
//@Service
public class CheckService {
    @MyLog(requestUrl="sss")
    public void ff(){
        System.out.println("合法");
    }
}
