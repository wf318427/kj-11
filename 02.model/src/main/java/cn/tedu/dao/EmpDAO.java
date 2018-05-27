package cn.tedu.dao;

import cn.tedu.annotation.Myannotation;
import cn.tedu.entity.Emp;

import java.util.List;

/**
 * Created by Administrator on 17.12.23.
 */
//@Myannotation
public interface EmpDAO {
    Emp findEmpById(int id);
    List<Emp> findAll();
    void save(Emp emp);
    void deleteById(int id);
}
