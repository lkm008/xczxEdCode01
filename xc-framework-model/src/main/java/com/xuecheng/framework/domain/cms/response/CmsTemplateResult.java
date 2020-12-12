package com.xuecheng.framework.domain.cms.response;

import com.xuecheng.framework.domain.cms.CmsTemplate;
import com.xuecheng.framework.model.response.CommonCode;
import com.xuecheng.framework.model.response.ResponseResult;

public class CmsTemplateResult extends ResponseResult {
    CmsTemplate cmsTemplate;

    public CmsTemplateResult(CommonCode commonCode, CmsTemplate cmsTemplate) {
        super(commonCode);
        this.cmsTemplate = cmsTemplate;
    }

    public CmsTemplate getCmsTemplate() {
        return cmsTemplate;
    }
}
