package com.imi.mapper.primary;


import com.imi.entity.OrgCode;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by mi on 2018/5/24.
 */
@RepositoryDefinition(domainClass = OrgCode.class, idClass = String.class)
public interface OrgCodeRepositoryPrimary {

    @Query(nativeQuery = true, value = "select id,fullname,shortname, region, province,orgspell from org_code")
    List<OrgCode> queryAllOrgCode();


    @Query(nativeQuery = true, value = "select id,fullname,shortname, region, province,orgspell from org_code oc where oc.id like ':province%'")
    List<OrgCode> queryOrgCodeListByProvince(@Param("province") String province);
}
