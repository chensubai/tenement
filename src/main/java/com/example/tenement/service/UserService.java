package com.example.tenement.service;

import com.example.tenement.core.common.resp.RestResp;
import com.example.tenement.dto.req.UserInfoUptReqDto;
import com.example.tenement.dto.req.UserLoginReqDto;
import com.example.tenement.dto.req.UserRegisterReqDto;
import com.example.tenement.dto.resp.UserInfoRespDto;
import com.example.tenement.dto.resp.UserLoginRespDto;
import com.example.tenement.dto.resp.UserRegisterRespDto;

/**
 * 用户模块 服务类
 */
public interface UserService {

    /**
     * 用户注册
     *
     * @param dto 注册参数
     * @return JWT
     */
    RestResp<UserRegisterRespDto> register(UserRegisterReqDto dto);

    /**
     * 用户登录
     *
     * @param dto 登录参数
     * @return JWT + 昵称
     */
    RestResp<UserLoginRespDto> login(UserLoginReqDto dto);

    /**
     * 用户信息修改
     *
     * @param dto 用户信息
     * @return void
     */
    RestResp<Void> updateUserInfo(UserInfoUptReqDto dto);
    /**
     * 用户信息查询
     * @param userId 用户ID
     * @return 用户信息
     */
    RestResp<UserInfoRespDto> getUserInfo(Long userId);
}
