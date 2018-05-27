package cn.tedu.test;

import cn.tedu.dao.EmpDAO;
import cn.tedu.entity.Emp;
import cn.tedu.service.EmpService;
import cn.tedu.service.WeatherService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 17.12.23.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring-web.xml")
public class TestCase {
    @Autowired
    WeatherService weatherService;
    @Autowired
    DataSource dataSource;
    @Autowired
    EmpDAO dao;
    @Autowired
    DataSourceTransactionManager transactionManager;
    @Test
    public void test(){
        String s=weatherService.getWeatherService("南京");
        System.out.println(s);
//        try {
//            Connection connection=dataSource.getConnection();
//            System.out.println(connection);
//            Statement statement=connection.createStatement();
//            ResultSet rs=statement.executeQuery("SELECT * FROM  emp ");
//            rs.next();
//            System.out.println(rs.getObject(2));
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }
    @Test
    public void test2(){
        Emp e=dao.findEmpById(1);
        List<Emp> list=dao.findAll();
        System.out.println(e);
        System.out.println(list);
    }
    @Test
    //@Transactional
    public void test3(){
        Emp p=new Emp();
        p.setName("zhanfei");
        p.setId((long) 3);
        p.setAge((long) 26);
        dao.save(p);
        List<Emp> list=dao.findAll();
        System.out.println(list);
    }
    @Test
    @Transactional
    public void test4() throws SQLException {
        System.out.println(transactionManager.getDataSource().getConnection());
        dao.deleteById(3);
        List<Emp> list=dao.findAll();
        System.out.println(list);
    }
    @Autowired
    EmpService empService;

    /**
     * 1.事物回滚只对unchecked 异常生效 checked 不生效
     * unchecked runtimeexception 异常 无需不做
     * checked filenofindexception 异常 必须捕捉
     * 2.事物方法的调用，必须是有事物的直接被调用 生效
     *  而同一个类一个无事物方法调用有事物的方法事物不生效
     */
    @Test
    public void test5(){
        //empService.ff(3);
        empService.deleteById(3);
        List<Emp> list=dao.findAll();
        System.out.println(list);

    }

    /**
     * 插入排序
     *
     */
    @Test
    public void test6(){
        int[] a={8,2,5,7,1,3};

        for(int i=1;i<a.length;i++){
            int tmp=a[i];
            for(int j=i-1;j>=0;j--){
                if(tmp<a[j]){
                    a[j+1]=a[j];
                    a[j]=tmp;
                    tmp=a[j];
                }
            }
            for(int k:a){
                System.out.print(k+" ");
            }
            System.out.println("");
        }
       for(int i:a){
           System.out.print(i+" ");
       }
    }
}
