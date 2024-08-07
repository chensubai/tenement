package com.example.tenement.dto.resp;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

/**
 * 用户信息 响应DTO
 */
@Data
@Builder
public class UserInfoRespDto {

    /**
     * 昵称
     * */
    @Schema(description = "昵称")
    private String nickName;

    /**
     * 用户头像
     * */
    @Schema(description = "用户头像")
    private String headUrl;
}
