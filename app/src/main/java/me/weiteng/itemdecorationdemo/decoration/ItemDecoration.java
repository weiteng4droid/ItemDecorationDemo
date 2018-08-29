package me.weiteng.itemdecorationdemo.decoration;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;

import me.weiteng.itemdecorationdemo.interf.GroupListener;
import me.weiteng.itemdecorationdemo.R;

/**
 * 首页 Item 装饰器
 *
 * @author weiTeng on 2018/03/01
 */
public class ItemDecoration extends RecyclerView.ItemDecoration {

    private int mLineHeight;
    private int mGroupHeight;
    private int mLeftMargin;

    private Paint mPaint;
    private Paint mTextPaint;
    private Paint mGroutPaint;

    private GroupListener mGroupListener;

    public void setGroupListener(GroupListener groupListener) {
        mGroupListener = groupListener;
    }

    public void setGroupHeight(int groupHeight) {
        mGroupHeight = groupHeight;
    }

    public void setLeftMargin(int leftMargin) {
        mLeftMargin = leftMargin;
    }

    public ItemDecoration(int lineHeight, float textSize) {
        mLineHeight = lineHeight;
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.parseColor("#b2bec3"));

        mTextPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG);
        mTextPaint.setColor(Color.parseColor("#ecf0f1"));
        mTextPaint.setTextSize(textSize);

        mGroutPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mGroutPaint.setColor(Color.parseColor("#1abc9c"));
        mGroutPaint.setStyle(Paint.Style.FILL);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        int position = parent.getChildAdapterPosition(view);
        if (position == 0) {
            final int paddingTop = (int) view.getResources().getDimension(R.dimen.gap_item_decoration_top_margin);
            outRect.top = paddingTop + mLineHeight;
        } else {
            if (isDisplayGroup(position)) {
                outRect.top = mGroupHeight;
            } else {
                outRect.top = mLineHeight;
            }
        }
    }

    private boolean isDisplayGroup(int position) {
        return mGroupListener != null && mGroupListener.isDisplayGroup(position);
    }

    private String getGroupName(int position) {
        if (mGroupListener != null) {
            return mGroupListener.getGroupName(position);
        }
        return null;
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
        final int left = parent.getLeft();
        final int right = parent.getRight();
        final int childCount = parent.getChildCount();

        for (int i = 1; i < childCount; i++) {
            final View childView = parent.getChildAt(i);

            final int bottom = childView.getTop();
            int position = parent.getChildAdapterPosition(childView);
            if (isDisplayGroup(position)) {
                final int top = bottom - mGroupHeight;
                c.drawRect(left, top, right, bottom, mGroutPaint);
                drawText(c, parent, childView, bottom);
            } else {
                c.drawRect(left + mLeftMargin, bottom - mLineHeight, right, bottom, mPaint);
            }
        }
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(c, parent, state);

        View childView = parent.getChildAt(0);
        int width = childView.getWidth();
        int position = parent.getChildAdapterPosition(childView);
        String groupName = getGroupName(position);

        if (groupName == null) {
            return;
        }

        if (childView.getBottom() <= mGroupHeight && isDisplayGroup(position + 1)) {
            // 缩小替换效果
            c.drawRect(0, 0, width, childView.getBottom() , mGroutPaint);
            drawText(c, groupName, childView, childView.getBottom());
        } else {
            // 固定不动
            c.drawRect(0, 0, width, mGroupHeight, mGroutPaint);
            drawText(c, groupName, childView, mGroupHeight);
        }
    }

    private void drawText(Canvas c, RecyclerView parent, View view, int floatHeight) {
        int position = parent.getChildAdapterPosition(view);
        String name = getGroupName(position);

        if (!TextUtils.isEmpty(name)) {
            drawText(c, name, view, floatHeight);
        }
    }

    private void drawText(Canvas c, String name, View view, int height) {
        int left  = view.getLeft();
        Paint.FontMetrics fm = mTextPaint.getFontMetrics();
        float baseLine = height - (fm.bottom - fm.top) / 2;
        c.drawText(name, left + mLeftMargin, baseLine, mTextPaint);
    }
}
