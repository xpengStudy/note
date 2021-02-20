package com.xp.note.util;

public enum MessageLevel implements IEnum {
    INFO("info", "普通消息"),
    WARN("warn", "警告消息"),
    FAIL("fail", "失败消息");

    private String key;
    private String value;

    MessageLevel(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return this.key;
    }

    public String getValue() {
        return this.value;
    }
}
