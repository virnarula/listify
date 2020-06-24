package com.virnarula.listify.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.PagerAdapter;

import com.virnarula.listify.R;

import java.util.zip.Inflater;

public class CustomPagerAdapter extends PagerAdapter {

    private Context mContext;

    public CustomPagerAdapter(Context context) {
        mContext = context;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ModelObject modelObject = ModelObject.values()[position];
        LayoutInflater inflater = LayoutInflater.from(mContext);
        ViewGroup layout = (ViewGroup) inflater.inflate(modelObject.getmLayoutResID(), container, false);
        container.addView(layout);
        return layout;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return ModelObject.values().length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getString(ModelObject.values()[position].getmLayoutTitleID());
    }
}

enum ModelObject {
    MY_DAY(R.string.my_day, R.layout.fragment_day),
    ASSIGNMENTS(R.string.assignments, R.layout.fragement_assignments),
    HISTORY(R.string.history, R.layout.fragment_history);

    private int mLayoutResID;
    private int mLayoutTitleID;

    ModelObject(int s, int i) {
        mLayoutTitleID = s;
        mLayoutResID = i;
    }

    public int getmLayoutResID() {
        return mLayoutResID;
    }

    public void setmLayoutResID(int mLayoutResID) {
        this.mLayoutResID = mLayoutResID;
    }

    public int getmLayoutTitleID() {
        return mLayoutTitleID;
    }

    public void setmLayoutTitleID(int mLayoutTitleID) {
        this.mLayoutTitleID = mLayoutTitleID;
    }
}