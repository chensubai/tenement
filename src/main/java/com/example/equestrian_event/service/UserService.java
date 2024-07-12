package com.example.equestrian_event.service;

import com.example.equestrian_event.core.common.resp.RestResp;
import com.example.equestrian_event.dto.req.UserInfoUptReqDto;
import com.example.equestrian_event.dto.req.UserLoginReqDto;
import com.example.equestrian_event.dto.req.UserRegisterReqDto;
import com.example.equestrian_event.dto.resp.UserInfoRespDto;
import com.example.equestrian_event.dto.resp.UserLoginRespDto;
import com.example.equestrian_event.dto.resp.UserRegisterRespDto;

/**
 * 会员模块 服务类
 *
 * @author xiongxiaoyang
 * @date 2022/5/17
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
