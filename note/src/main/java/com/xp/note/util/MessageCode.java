package com.xp.note.util;

public enum MessageCode implements IMessageCodeEnum {

    SUCCESS(0, "操作成功！"),
    NORMAL_ERROR(1,"程序错误！"),
    SYS_ERROR(10000,"系统错误！");


    private Integer key;

    private String value;


    MessageCode(Integer key, String value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public Integer getKey() {
        return this.key;
    }

    @Override
    public String getValue() {
        return this.value;
    }
}
