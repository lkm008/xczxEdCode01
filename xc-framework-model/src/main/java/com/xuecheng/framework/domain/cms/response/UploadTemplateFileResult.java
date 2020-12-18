package com.xuecheng.framework.domain.cms.response;

import com.xuecheng.framework.model.response.ResponseResult;
import com.xuecheng.framework.model.response.ResultCode;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UploadTemplateFileResult extends ResponseResult {
    @ApiModelProperty(value = "文件信息", example = "true", required = true)
    String templateFileId;
    public UploadTemplateFileResult(ResultCode resultCode, String templateFileId) {
        super(resultCode);
        this.templateFileId = templateFileId;
    }
}
