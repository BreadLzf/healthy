package healthy.tichuang.com.adapter;

import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Item类型的adapter基类
 * Created by ccheng on 8/11/14.
 */
public abstract class ItemAdapter<T> extends BaseAdapter {

    private List<T> mItems = new ArrayList<T>();

    public void setItems(List<T> items) {
        if (items == null) {
            return;
        }
        mItems = items;
        notifyDataSetChanged();
    }

    public void setItems(T[] items) {
        if (items == null) {
            return;
        }
        for (T item : items) {
            mItems.add(item);
        }
        notifyDataSetChanged();
    }

    public void addItems(List<T> items) {
        mItems.addAll(items);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public T getItem(int position) {
        return mItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public List<T> getItems() {
        return mItems;
    }

}
