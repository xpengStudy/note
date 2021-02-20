package com.xp.note.vo;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;


public class PageVo<T> extends Page<T> {

    private T params;

    public T getParams() {
        return params;
    }

    public void setParams(T params) {
        this.params = params;
    }


}
