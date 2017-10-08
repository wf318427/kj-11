package cn.tedu.test;

import cn.tedu.service.CheckRules;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 17.10.8.
 */
public class CheckRulesTest extends TestBase {
    @Autowired
    CheckRules checkRules;
    @Test
    public void docheckRules() throws Exception {
        checkRules.docheckRules();
    }

}