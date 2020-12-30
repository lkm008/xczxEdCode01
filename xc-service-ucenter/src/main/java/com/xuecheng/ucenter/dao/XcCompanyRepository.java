package com.xuecheng.ucenter.dao;

import com.xuecheng.framework.domain.ucenter.XcCompany;
import org.springframework.data.jpa.repository.JpaRepository;

public interface XcCompanyRepository extends JpaRepository<XcCompany,String> {
    //根据用户id查询所属企业id
    XcCompany findByUserId(String userId);
}
