package com.xuecheng.ucenter.dao;

import com.xuecheng.framework.domain.ucenter.XcPermission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface XcPermissionRepository extends JpaRepository<XcPermission,String> {
    //根据用户id查询所属企业id
    XcPermission findByUserId(String userId);
}
