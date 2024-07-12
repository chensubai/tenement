package com.example.equestrian_event.controller;

import com.example.equestrian_event.core.auth.UserHolder;
import com.example.equestrian_event.core.constant.ApiRouterConsts;
import com.example.equestrian_event.core.constant.SystemConfigConsts;
import com.example.equestrian_event.core.common.resp.RestResp;
import com.example.equestrian_event.dto.req.UserInfoUptReqDto;
import com.example.equestrian_event.dto.req.UserLoginReqDto;
import com.example.equestrian_event.dto.req.UserRegisterReqDto;
import com.example.equestrian_event.dto.resp.UserInfoRespDto;
import com.example.equestrian_event.dto.resp.UserLoginRespDto;
import com.example.equestrian_event.dto.resp.UserRegisterRespDto;
import com.example.equestrian_event.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * 前台门户-会员模块 API 控制器
 *
 * @author xiongxiaoyang
 * @date 2022/5/17
 */
@Tag(name = "UserController", description = "前台门户-会员模块")
@SecurityRequirement(name = SystemConfigConsts.HTTP_AUTH_HEADER_NAME)
@RestController
@RequestMapping(ApiRouterConsts.API_FRONT_USER_URL_PREFIX)
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    /**
     * 用户注册接口
     */
    @Operation(summary = "用户注册接口")
    @PostMapping("register")
    public RestResp<UserRegisterRespDto> register(@Valid @RequestBody UserRegisterReqDto dto) {
        return userService.register(dto);
    }

    /**
     * 用户登录接口
     */
    @Operation(summary = "用户登录接口")
    @PostMapping("login")
    public RestResp<UserLoginRespDto> login(@Valid @RequestBody UserLoginReqDto dto) {
        return userService.login(dto);
    }

    /**
     * 用户信息查询接口
     */
    @Operation(summary = "用户信息查询接口")
    @GetMapping
    public RestResp<UserInfoRespDto> getUserInfo() {
        return userService.getUserInfo(UserHolder.getUserId());
    }

    /**
     * 用户信息修改接口
     */
    @Operation(summary = "用户信息修改接口")
    @PutMapping
    public RestResp<Void> updateUserInfo(@Valid @RequestBody UserInfoUptReqDto dto) {
        dto.setUserId(UserHolder.getUserId());
        return userService.updateUserInfo(dto);
    }
}

