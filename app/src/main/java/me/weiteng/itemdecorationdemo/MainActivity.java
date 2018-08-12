package me.weiteng.itemdecorationdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;

import java.util.ArrayList;
import java.util.List;

import me.weiteng.itemdecorationdemo.decoration.ItemDecoration;
import me.weiteng.itemdecorationdemo.entity.Department;
import me.weiteng.itemdecorationdemo.entity.User;
import me.weiteng.itemdecorationdemo.interf.GroupListener;

/**
 * 主页
 *
 * @author weiTeng
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.main_recycler_view);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        final List<Department> departments = getDepartment();
        final DemoAdapter adapter = new DemoAdapter(departments);
        recyclerView.setAdapter(adapter);


        int lineHeight = getResources().getDimensionPixelSize(R.dimen.common_line_height);
        int textSize = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 14, getResources().getDisplayMetrics());
        ItemDecoration itemDecoration = new ItemDecoration(lineHeight, textSize);

        int groupHeight = getResources().getDimensionPixelSize(R.dimen.gap_item_decoration_top_margin);
        itemDecoration.setGroupHeight(groupHeight);
        itemDecoration.setLeftMargin(getResources().getDimensionPixelSize(R.dimen.activity_horizontal_margin));
        itemDecoration.setGroupListener(new GroupListener() {

            @Override
            public String getGroupName(int position) {
                return adapter.getUsers().get(position).getDeptName();
            }

            @Override
            public boolean isDisplayGroup(int position) {
                return adapter.getUsers().get(position).isDisplayGroup();
            }
        });
        recyclerView.addItemDecoration(itemDecoration);
    }

    private List<Department> getDepartment() {
        List<Department> departments = new ArrayList<>();

        Department department = new Department();
        department.setDeptName("运营部门");
        department.setEmployees(new ArrayList<User>());
        department.getEmployees().add(new User("小美"));
        department.getEmployees().add(new User("小萌"));
        department.getEmployees().add(new User("小玲"));
        department.getEmployees().add(new User("小爽"));
        department.getEmployees().add(new User("小艾"));
        department.getEmployees().add(new User("小晓"));
        department.getEmployees().add(new User("小猪"));
        department.getEmployees().add(new User("小辉"));
        departments.add(department);

        Department department2 = new Department();
        department2.setDeptName("产品部门");
        department2.setEmployees(new ArrayList<User>());
        department2.getEmployees().add(new User("小白"));
        department2.getEmployees().add(new User("傻子"));
        department2.getEmployees().add(new User("墩子"));
        department2.getEmployees().add(new User("二愣子"));
        department2.getEmployees().add(new User("小矮子"));
        department2.getEmployees().add(new User("木瓜"));
        department2.getEmployees().add(new User("黑土"));
        departments.add(department2);

        Department department3 = new Department();
        department3.setDeptName("测试部门");
        department3.setEmployees(new ArrayList<User>());
        department3.getEmployees().add(new User("云姐"));
        department3.getEmployees().add(new User("南方妹子"));
        department3.getEmployees().add(new User("北方姑娘"));
        department3.getEmployees().add(new User("山东傻姑"));
        department3.getEmployees().add(new User("四川辣妹"));
        department3.getEmployees().add(new User("东北小姐姐"));
        department3.getEmployees().add(new User("海南小姐姐"));
        departments.add(department3);

        Department department4 = new Department();
        department4.setDeptName("研发部门");
        department4.setEmployees(new ArrayList<User>());
        department4.getEmployees().add(new User("妮妮"));
        department4.getEmployees().add(new User("小帅"));
        department4.getEmployees().add(new User("小胖墩"));
        department4.getEmployees().add(new User("Android小妹"));
        department4.getEmployees().add(new User("水仙不开花"));
        department4.getEmployees().add(new User("水仙花不开"));
        department4.getEmployees().add(new User("悠悠"));
        department4.getEmployees().add(new User("黑衣人"));
        department4.getEmployees().add(new User("关怀"));
        department4.getEmployees().add(new User("冷风"));
        department4.getEmployees().add(new User("一叶扁舟"));
        department4.getEmployees().add(new User("摆渡人"));
        department4.getEmployees().add(new User("小茗同学"));
        department4.getEmployees().add(new User("冰红茶"));
        department4.getEmployees().add(new User("布鲁斯"));
        department4.getEmployees().add(new User("京城四少"));
        department4.getEmployees().add(new User("京城二少"));
        department4.getEmployees().add(new User("京城二妹"));
        department4.getEmployees().add(new User("孙二娘"));
        department4.getEmployees().add(new User("阿力"));
        departments.add(department4);

        return departments;
    }
}
