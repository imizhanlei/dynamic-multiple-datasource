package com.imi.service.primary;

import com.imi.entity.OrgCode;

import java.util.List;

/**
 * Created by mi on 2018/5/24.
 */
public interface OrgCodeServicePrimary {
    List<OrgCode> queryAllOrgCode();

    List<OrgCode> queryOrgCodeByProvince(String province);
}
