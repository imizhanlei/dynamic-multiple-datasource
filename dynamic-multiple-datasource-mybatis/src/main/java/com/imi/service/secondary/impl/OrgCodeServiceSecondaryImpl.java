package com.imi.service.secondary.impl;

import com.imi.entity.OrgCode;
import com.imi.mapper.OrgCodeMapper;
import com.imi.service.secondary.OrgCodeServiceSecondary;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by mi on 2018/5/24.
 */
@Slf4j
@Service
public class OrgCodeServiceSecondaryImpl implements OrgCodeServiceSecondary {

    @Autowired
    OrgCodeMapper orgCodeMapper;

    @Override
    public List<OrgCode> queryAllOrgCode() {
        return orgCodeMapper.queryAllOrgCode();
    }

    @Override
    public List<OrgCode> queryOrgCodeByProvince(String province) {
        return orgCodeMapper.queryOrgCodeListByProvince(province);
    }
}
