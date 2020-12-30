package com.xuecheng.ucenter.dao;

import com.xuecheng.framework.domain.ucenter.XcMenu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface XcMenuRepository extends JpaRepository<XcMenu,String> {
    //根据用户id查询所属企业id
    XcMenu findByUserId(String userId);
}
