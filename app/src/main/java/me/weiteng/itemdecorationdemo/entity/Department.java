package me.weiteng.itemdecorationdemo.entity;

import java.util.List;

/**
 * Created by weiTeng on 2018/3/2
 */
public class Department {

    private String deptName;
    private List<User> employees;

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public List<User> getEmployees() {
        return employees;
    }

    public void setEmployees(List<User> employees) {
        this.employees = employees;
    }
}
