package com.deng.controller;

import com.deng.dao.DepartmentDao;
import com.deng.dao.EmployeeDao;
import com.deng.pojo.Department;
import com.deng.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

/**
 * @author DengTao
 */
@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    @RequestMapping("/emps")
    public String employeeManager(Model model){
        Collection<Employee> employeeCollection = employeeDao.getEmployees();
        model.addAttribute("emps",employeeCollection);
        return "emps/list";
    }

    @RequestMapping("/addEmp")
    public String toAddEmployee(Model model){
        Collection<Department> departments = departmentDao.getDepartmets();
        model.addAttribute("departments",departments);
        return "emps/add";
    }

    @PostMapping("/addEmp")
    public String addEmployee(Employee employee){
        employeeDao.saveEmploy(employee);
        return "redirect:/emps";
    }


    /**
     * 编辑1
     */
    @GetMapping("/edit1")
    public String toUpdateEmployee1(Integer id,Model model){
        Employee employee = employeeDao.getEmployeeById(id);
        model.addAttribute("employee",employee);
        Collection<Department> departments = departmentDao.getDepartmets();
        model.addAttribute("departments",departments);
        return "emps/update";
    }


    /**
     * 编辑2
     */
    @GetMapping("/edit2/{id}")
    public String toUpdateEmployee2(@PathVariable("id") Integer id,Model model){
        Employee employee = employeeDao.getEmployeeById(id);
        model.addAttribute("employee",employee);
        Collection<Department> departments = departmentDao.getDepartmets();
        model.addAttribute("departments",departments);
        return "emps/update";
    }


    @PostMapping("/updateEmp")
    public String updateEmployee(Employee employee){
        employeeDao.saveEmploy(employee);
        return "redirect:/emps";
    }


    @GetMapping("/delEmp/{id}")
    public String delEmployee(@PathVariable("id") Integer id){
        employeeDao.deleteEmployeeById(id);
        return "redirect:/emps";
    }


}
