package com.king.myboot.mapper;

import com.king.myboot.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmpMapper {
    /**
     * 查询全部信息
     */
    List<Emp> selectEmpAll();


    /**
     * 添加员工信息
     * @param emp
     * @return
     */
    int insertAll(Emp emp);

    /**
     * 根据用户id 删除信息
     * @param id
     * @return
     */
    int deleteEmpId(Integer id);

    /**
     * 根据用户修改数据
     * @param id
     * @return
     */
    Emp selectById(Integer id);

    /**
     * 修改用户信息
     * @param emp
     * @return
     */
    int updateAll(Emp emp);
}
