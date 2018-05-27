package cn.tedu.service;

import cn.tedu.dao.EmpDAO;
import cn.tedu.entity.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

/**
 * Created by Administrator on 17.12.24.
 */
@Service
public class EmpService {
    @Autowired
    EmpDAO dao;
    @Transactional
    public boolean deleteById(int id){
         dao.deleteById(id);
        //System.out.println(1/0);
        File file=new File("111.txt");
        try {
            RandomAccessFile rf=new RandomAccessFile(file,"r");
        } catch (FileNotFoundException e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
        }
        return true;
    }

    public void ff(int i) {
        deleteById(i);
    }
}
