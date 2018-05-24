package com.imi.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by mi on 2018/5/24.
 */
@Data
public class Result<T> implements Serializable {

    private Integer code;
    private String msg;
    private T data;
}
