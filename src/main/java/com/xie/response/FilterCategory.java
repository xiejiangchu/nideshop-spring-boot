package com.xie.response;

/**
 * Created by xie on 17/9/3.
 */
public class FilterCategory {

    /**
     * id : 0
     * name : 全部
     * checked : false
     */

    private int id;
    private String name;
    private boolean checked;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
