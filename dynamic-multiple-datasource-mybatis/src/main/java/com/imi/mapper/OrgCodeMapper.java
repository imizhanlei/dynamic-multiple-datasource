package com.imi.mapper;

import com.imi.entity.OrgCode;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by mi on 2018/5/24.
 */
@Mapper
public interface OrgCodeMapper {
    @Select(value = "select id,fullname,shortname, region, province,orgspell from org_code")
    List<OrgCode> queryAllOrgCode();

    @Select(value = "select id,fullname,shortname, region, province,orgspell from org_code oc where oc.id like '${province}%'")
    List<OrgCode> queryOrgCodeListByProvince(@Param("province") String province);
}
