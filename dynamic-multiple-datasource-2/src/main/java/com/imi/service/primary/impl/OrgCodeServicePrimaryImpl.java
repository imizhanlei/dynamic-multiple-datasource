package com.imi.service.primary.impl;

import com.imi.entity.OrgCode;
import com.imi.mapper.primary.OrgCodeRepositoryPrimary;
import com.imi.service.primary.OrgCodeServicePrimary;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by mi on 2018/5/24.
 */
@Slf4j
@Service
public class OrgCodeServicePrimaryImpl  implements OrgCodeServicePrimary{

    @Autowired
    OrgCodeRepositoryPrimary orgCodeRepositoryPrimary;

    @Override
    public List<OrgCode> queryAllOrgCode() {
        return orgCodeRepositoryPrimary.queryAllOrgCode();
    }
}
