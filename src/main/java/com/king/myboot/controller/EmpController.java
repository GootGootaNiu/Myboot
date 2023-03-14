package com.king.myboot.controller;

import com.king.myboot.pojo.Emp;
import com.king.myboot.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/emp")
public class EmpController {

    @Autowired
    private EmpService empService;

    /**
     * 显示员工信息
     * @param model
     * @return
     */
    @GetMapping("/selectEmp")
    public String selectEmpAll(Model model){
        List<Emp> emps = empService.selectEmpAll();
        model.addAttribute("empList",emps);
        return "emplist";
    }

    @GetMapping("/insertAll")
    public String insertEmp(){
        return "addEmp";
    }

    /**
     * 添加数据
     * @param emp
     * @return
     */
    @PostMapping("/insertAlls")
    public String insertEmpAll(Emp emp){
        int i = empService.insertEmpAll(emp);
        System.out.println("添加数据成功");
        return "redirect:/emp/selectEmp";
    }

    //{/emp/delete(id=${emp.id})}
    @GetMapping("/delete")
    public String deleteEmpId(Integer id){
        int i = empService.deleteEmpId(id);
        System.out.println("用户删除成功");
        return "redirect:/emp/selectEmp";
    }

    @GetMapping("/myupdate")
    public String updateEmpId(Integer id,Model model){
        Emp emp = empService.selectById(id);
        model.addAttribute("emp",emp);
        return "updateEmp";
    }

    @PostMapping("/updateAll")
    public String updateAll(Emp emp){
        int i = empService.updateAll(emp);
        return "redirect:/emp/selectEmp";
    }

}
