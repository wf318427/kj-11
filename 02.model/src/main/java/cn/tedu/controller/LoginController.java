package cn.tedu.controller;

import cn.tedu.annotation.MyLog;
import cn.tedu.service.Emp;
import com.thoughtworks.xstream.XStream;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 17.12.23.
 */
@Controller
public class  LoginController {
    @RequestMapping("hello")
    @ResponseBody
    public String hello(){
        return "hello";
    }
    @RequestMapping(value = "hello1",method = RequestMethod.POST)
    @ResponseBody
    public String hello1(String xml){
       Emp p= (Emp) new XStream().fromXML(xml);
        System.out.println(p);
        return "ok";
    }
    @RequestMapping("hello2")
    public void hello2(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {

         request.getRequestDispatcher("1.jsp").forward(request,response);
    }
    @MyLog(requestUrl = "index")
    @RequestMapping(method = RequestMethod.GET,value = "index")
    @ResponseBody
    public String index() {
        return "index";
    }
}
