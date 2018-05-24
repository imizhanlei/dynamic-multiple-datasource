package com.imi.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by mi on 2018/5/24.
 */
@Data
public class OrgCode implements Serializable{

    private String id;
    private String fullname;
    private String shortname;
    private String region;
    private String province;
    private String orgspell;
}
