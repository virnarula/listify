package com.virnarula.listify.ui;

import com.virnarula.listify.R;

public enum ModelObject {
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
