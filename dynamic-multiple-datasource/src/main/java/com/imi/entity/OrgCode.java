package com.imi.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by mi on 2018/5/24.
 */
@Data
@Entity
public class OrgCode implements Serializable {

    @Id
    private String id;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "shortname")
    private String shortname;

    @Column(name = "region")
    private String region;

    @Column(name = "province")
    private String province;

    @Column(name = "orgspell")
    private String orgspell;
}
