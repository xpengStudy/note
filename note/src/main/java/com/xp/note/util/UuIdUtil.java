package com.xp.note.util;

import java.util.UUID;

public class UuIdUtil {

    public static String getUuId32(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }
}
