package me.weiteng.itemdecorationdemo.interf;

/**
 * Created by BTL02 on 2018/3/1.
 */
public interface GroupListener {

    /**
     * 获取组的名称
     *
     * @param position itemView的位置
     * @return 组的名称
     */
    String getGroupName(int position);

    /**
     * 是否显示组
     *
     * @param position itemView的位置
     * @return 组的名称
     */
    boolean isDisplayGroup(int position);
}
