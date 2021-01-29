package com.xp.note1.entity;

import lombok.Data;

import java.io.Serializable;

/********
 *  实体类基类
 */
@Data
public class BaseEntity implements Serializable {

    private String id;
}
