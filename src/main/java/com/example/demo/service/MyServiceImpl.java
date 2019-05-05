package com.example.demo.service;

import com.example.demo.BossRole;
import com.example.demo.BossRoleExample;
import com.example.demo.map.BossRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MyServiceImpl implements MyService{

    @Autowired
    private BossRoleMapper bossRoleDAO;
    @Override
    @Transactional
    public void test() {
        BossRoleExample example = new BossRoleExample();
        List<BossRole> list =bossRoleDAO.selectByExample(example);
        BossRole bossRole = new BossRole();
        bossRole.setRoleName("youshiwu222");
        int num = bossRoleDAO.insert(bossRole);
        String a =null;
//        //让他报错，查看事物是否生效
//        if(a.equals("")){
//
//        }
        System.out.println();
    }
}
