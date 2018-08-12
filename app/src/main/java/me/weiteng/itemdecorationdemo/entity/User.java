package me.weiteng.itemdecorationdemo.entity;

/**
 * Created by weiTeng on 2018/3/2
 */
public class User {

    private String deptName;
    private String name;
    private String avatar;
    private boolean displayGroup;

    public User(String name) {
        this.name = name;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public boolean isDisplayGroup() {
        return displayGroup;
    }

    public void setDisplayGroup(boolean displayGroup) {
        this.displayGroup = displayGroup;
    }

    @Override
    public String toString() {
        return "User{" +
                "deptName='" + deptName + '\'' +
                ", name='" + name + '\'' +
                ", avatar='" + avatar + '\'' +
                ", displayGroup=" + displayGroup +
                '}';
    }
}
