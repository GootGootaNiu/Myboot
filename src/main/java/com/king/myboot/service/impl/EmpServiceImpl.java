package com.king.myboot.service.impl;

import com.king.myboot.mapper.EmpMapper;
import com.king.myboot.pojo.Emp;
import com.king.myboot.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional // 开启事务
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    /**
     * 显示员工信息
     * @return
     */
    @Override
    // 事务的传播行为
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Emp> selectEmpAll() {
        return empMapper.selectEmpAll();
    }

    /**
     * 添加员工信息
     * @param emp
     * @return
     */
    @Override
    public int insertEmpAll(Emp emp) {
//        emp.setId(UUID.randomUUID().toString());

//        user.setId(UUID.randomUUID().toString());

        return empMapper.insertAll(emp);
    }

    @Override
    public int deleteEmpId(Integer id) {
        return empMapper.deleteEmpId(id);
    }

    @Override
    public Emp selectById(Integer id) {
        return empMapper.selectById(id);
    }

    @Override
    public int updateAll(Emp emp) {
        return empMapper.updateAll(emp);
    }
}
