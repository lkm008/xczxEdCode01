package com.xuecheng.ucenter.dao;

import com.xuecheng.framework.domain.ucenter.XcRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface XcRoleRepository extends JpaRepository<XcRole,String> {
    //根据用户id查询所属企业id
    XcRole findByUserId(String userId);
}
