package me.weiteng.itemdecorationdemo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import me.weiteng.itemdecorationdemo.entity.Department;
import me.weiteng.itemdecorationdemo.entity.User;

/**
 * Created by weiTeng on 2018/3/2
 */
public class DemoAdapter extends RecyclerView.Adapter<DemoViewHolder> {

    private List<User> users;

    public DemoAdapter(List<Department> departments) {
        this.users = convert2Users(departments);
    }

    private List<User> convert2Users(List<Department> departments) {
        List<User> users = new ArrayList<>();
        for (Department department : departments) {
            List<User> employees = department.getEmployees();
            for (int i = 0; i < employees.size(); i++) {
                User user = employees.get(i);
                user.setDeptName(department.getDeptName());
                user.setDisplayGroup(i == 0);
                users.add(user);
            }
        }
        return users;
    }

    @Override
    public DemoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_demo, parent, false);
        return new DemoViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(DemoViewHolder holder, int position) {
        final User user = users.get(position);
        holder.nameLabel.setText(user.getName());
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public List<User> getUsers() {
        return users;
    }
}
