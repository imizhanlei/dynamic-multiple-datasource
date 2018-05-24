package com.imi.controller;

import com.imi.entity.OrgCode;
import com.imi.entity.Result;
import com.imi.service.primary.OrgCodeServicePrimary;
import com.imi.service.secondary.OrgCodeServiceSecondary;
import com.imi.utils.ResultUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by mi on 2018/5/24.
 */
@Slf4j
@RestController
@RequestMapping("oc")
public class OrgCodeController {

    @Autowired
    private RedisTemplate redisTemplate;


    @Autowired
    OrgCodeServicePrimary orgCodeServicePrimary;

    @Autowired
    OrgCodeServiceSecondary orgCodeServiceSecondary;

    @GetMapping("/qaoc-one")
    public Result queryAllOrgCodePrimary(){
        List<OrgCode> orgCodeList = null;
        ValueOperations<String, List<OrgCode>> operations = this.redisTemplate.opsForValue();
        orgCodeList = operations.get("org-code-all-one");
        if(! CollectionUtils.isEmpty(orgCodeList)){
            // 重新保存到redis
            operations.set("org-code-all-one", orgCodeList);

            return ResultUtils.success(orgCodeList);
        }else{
            orgCodeList = orgCodeServicePrimary.queryAllOrgCode();

            // 保存进redis
            operations.set("org-code-all-one", orgCodeList);

            return ResultUtils.success(orgCodeList);
        }
    }


    @GetMapping("/qaoc-two")
    public Result queryAllOrgCodeSecondary(){
        List<OrgCode> orgCodeList = null;
        ValueOperations<String, List<OrgCode>> operations = this.redisTemplate.opsForValue();
        orgCodeList = operations.get("org-code-all-two");
        if(! CollectionUtils.isEmpty(orgCodeList)){
            // 重新保存到redis
            operations.set("org-code-all-two", orgCodeList);

            return ResultUtils.success(orgCodeList);
        }else{
            orgCodeList = orgCodeServiceSecondary.queryAllOrgCode();

            // 保存进redis
            operations.set("org-code-all-two", orgCodeList);

            return ResultUtils.success(orgCodeList);
        }
    }

    @GetMapping("/qbp-one/{p}")
    public Result<OrgCode> queryOrgCodeByProvincePrimary(@PathVariable("p") String province){
        List<OrgCode> orgCodeList = null;
        ValueOperations<String, List<OrgCode>> operations = this.redisTemplate.opsForValue();
        orgCodeList = operations.get("org-code-one-"+province);
        List<OrgCode> orgCodeListAll = operations.get("org-code-all-one");

        if(! CollectionUtils.isEmpty(orgCodeList)){
            // 重新保存到redis
            operations.set("org-code-one-" + province, orgCodeList);

            return ResultUtils.success(orgCodeList);
        }else if(! CollectionUtils.isEmpty(orgCodeListAll)){
            orgCodeList = orgCodeListAll.stream()
                    .filter(orgCode -> orgCode.getId().startsWith(province))
                    .collect(Collectors.toList());

            // 保存到redis
            operations.set("org-code-one-" + province, orgCodeList);

            return ResultUtils.success(orgCodeList);
        }else {
            orgCodeList = this.orgCodeServicePrimary.queryOrgCodeByProvince(province);
            // 保存到redis
            operations.set("org-code-one-" + province, orgCodeList);

            return ResultUtils.success(orgCodeList);
        }
    }


    @GetMapping("/qbp-two/{p}")
    public Result<OrgCode> queryOrgCodeByProvinceSecondary(@PathVariable("p") String province){
        List<OrgCode> orgCodeList = null;
        ValueOperations<String, List<OrgCode>> operations = this.redisTemplate.opsForValue();
        orgCodeList = operations.get("org-code-two-"+province);
        List<OrgCode> orgCodeListAll = operations.get("org-code-all-two");

        if(! CollectionUtils.isEmpty(orgCodeList)){
            // 重新保存到redis
            operations.set("org-code-two-" + province, orgCodeList);

            return ResultUtils.success(orgCodeList);
        }else if(! CollectionUtils.isEmpty(orgCodeListAll)){
            orgCodeList = orgCodeListAll.stream()
                    .filter(orgCode -> orgCode.getId().startsWith(province))
                    .collect(Collectors.toList());

            // 保存到redis
            operations.set("org-code-two-" + province, orgCodeList);

            return ResultUtils.success(orgCodeList);
        }else {
            orgCodeList = this.orgCodeServiceSecondary.queryOrgCodeByProvince(province);
            // 保存到redis
            operations.set("org-code-two-" + province, orgCodeList);

            return ResultUtils.success(orgCodeList);
        }
    }
}
