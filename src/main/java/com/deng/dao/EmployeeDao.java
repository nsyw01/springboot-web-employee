package com.deng.dao;

import com.deng.pojo.Department;
import com.deng.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeDao {



    public static Map<Integer, Employee> employeeMap = null;
    @Autowired
    private DepartmentDao departmentDao;

    static {
        employeeMap = new HashMap<Integer, Employee>();
        //new Department(101,"教学部")
        employeeMap.put(1001,new Employee(1001,"jarry1","1482831003@qq.com",1,new Department(101,"教学部")));
        employeeMap.put(1002,new Employee(1002,"jarry2","2482831003@qq.com",0,new Department(102,"市场部")));
        employeeMap.put(1003,new Employee(1003,"jarry3","3482831003@qq.com",1,new Department(103,"教研部")));
        employeeMap.put(1004,new Employee(1004,"jarry4","4482831003@qq.com",0,new Department(104,"运营部")));
        employeeMap.put(1005,new Employee(1005,"jarry5","5482831003@qq.com",1,new Department(105,"后勤部")));
    }

    private static Integer initId = 1006;

    /**
     * 新增一个员工
     */
    public void saveEmploy(Employee employee){
        if (employee.getId() == null){
            employee.setId(initId++);
        }

        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));

        employeeMap.put(employee.getId(),employee);

    }

    /**
     * 查询全部员工信息
     */
    public Collection<Employee> getEmployees(){
        return employeeMap.values();
    }

    /**
     *  通过id查询员工
     */
    public Employee getEmployeeById(Integer id){
        return employeeMap.get(id);
    }

    /**
     *  删除一个员工
     */
    public void deleteEmployeeById(Integer id){
        employeeMap.remove(id);
    }

}
