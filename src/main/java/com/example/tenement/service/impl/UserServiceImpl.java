package com.example.tenement.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.tenement.core.common.exception.BusinessException;
import com.example.tenement.core.common.constant.ErrorCodeEnum;
import com.example.tenement.core.common.resp.RestResp;
import com.example.tenement.core.constant.DatabaseConsts;
import com.example.tenement.core.constant.SystemConfigConsts;
import com.example.tenement.core.util.ImageUtils;
import com.example.tenement.core.util.JwtUtils;
import com.example.tenement.dao.mapper.UserInfoMapper;
import com.example.tenement.dao.model.UserInfo;
import com.example.tenement.dto.req.UserInfoUptReqDto;
import com.example.tenement.dto.req.UserLoginReqDto;
import com.example.tenement.dto.req.UserRegisterReqDto;
import com.example.tenement.dto.resp.UserInfoRespDto;
import com.example.tenement.dto.resp.UserLoginRespDto;
import com.example.tenement.dto.resp.UserRegisterRespDto;
import com.example.tenement.manager.redis.VerifyCodeManager;
import com.example.tenement.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * 用户模块 服务实现类
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserInfoMapper userInfoMapper;

    private final VerifyCodeManager verifyCodeManager;

    private final JwtUtils jwtUtils;

    private final ImageUtils imageUtils;

    @Override
    public RestResp<UserRegisterRespDto> register(UserRegisterReqDto dto) {
        // 校验图形验证码是否正确
        if (!verifyCodeManager.imgVerifyCodeOk(dto.getSessionId(), dto.getVelCode())) {
            // 图形验证码校验失败
            throw new BusinessException(ErrorCodeEnum.USER_VERIFY_CODE_ERROR);
        }

        // 校验手机号是否已注册
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(DatabaseConsts.UserInfoTable.COLUMN_USERNAME, dto.getUsername())
            .last(DatabaseConsts.SqlEnum.LIMIT_1.getSql());
        if (userInfoMapper.selectCount(queryWrapper) > 0) {
            // 手机号已注册
            throw new BusinessException(ErrorCodeEnum.USER_NAME_EXIST);
        }

        // 注册成功，保存用户信息
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername(dto.getUsername());
        userInfo.setNickName(dto.getUsername());
        userInfo.setCreatedAt(LocalDateTime.now());
        userInfo.setUpdatedAt(LocalDateTime.now());
        userInfoMapper.insert(userInfo);

        // 删除验证码
        verifyCodeManager.removeImgVerifyCode(dto.getSessionId());

        // 生成JWT 并返回
        return RestResp.ok(
            UserRegisterRespDto.builder()
                .token(jwtUtils.generateToken(userInfo.getId(), SystemConfigConsts.NOVEL_FRONT_KEY))
                .uid(userInfo.getId())
                .build()
        );

    }

    @Override
    public RestResp<UserLoginRespDto> login(UserLoginReqDto dto) {
        // 查询用户信息
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(DatabaseConsts.UserInfoTable.COLUMN_USERNAME, dto.getUsername())
            .last(DatabaseConsts.SqlEnum.LIMIT_1.getSql());
        UserInfo userInfo = userInfoMapper.selectOne(queryWrapper);
        if (Objects.isNull(userInfo)) {
            // 用户不存在
            throw new BusinessException(ErrorCodeEnum.USER_ACCOUNT_NOT_EXIST);
        }
        // 登录成功，生成JWT并返回
        return RestResp.ok(UserLoginRespDto.builder()
            .token(jwtUtils.generateToken(userInfo.getId(), SystemConfigConsts.NOVEL_FRONT_KEY))
            .uid(userInfo.getId())
            .nickName(userInfo.getNickName()).build());
    }


    @Override
    public RestResp<Void> updateUserInfo(UserInfoUptReqDto dto) {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(dto.getUserId());
        userInfo.setNickName(dto.getNickName());
        userInfo.setHeadImg(dto.getHeadUrl());
        userInfoMapper.updateById(userInfo);
        return RestResp.ok();
    }

    @Override
    public RestResp<UserInfoRespDto> getUserInfo(Long userId) {
        UserInfo userInfo = userInfoMapper.selectById(userId);
        String timestampedHeadUrl = imageUtils.getOSSToken(userInfo.getHeadImg());
        return RestResp.ok(UserInfoRespDto.builder()
            .nickName(userInfo.getNickName())
            .headUrl(timestampedHeadUrl)
            .build());
    }
}
