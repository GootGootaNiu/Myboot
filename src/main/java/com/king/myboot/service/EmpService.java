package com.king.myboot.service;

import com.king.myboot.pojo.Emp;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.List;

public interface EmpService {
    List<Emp> selectEmpAll();

    /**
     * 添加员工信息
     * @param emp
     * @return
     */
    int insertEmpAll(Emp emp);

    /**
     * 删除信息
     * @param id
     * @return
     */
    int deleteEmpId(Integer id);

    /**
     * 根据id 查询用户信息
     * @param id
     * @return
     */
    Emp selectById(Integer id);

    int updateAll(Emp emp);
}
