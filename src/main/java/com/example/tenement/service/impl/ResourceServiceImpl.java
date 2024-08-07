package com.example.tenement.service.impl;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.example.tenement.core.common.constant.ErrorCodeEnum;
import com.example.tenement.core.common.exception.BusinessException;
import com.example.tenement.core.common.resp.RestResp;
import com.example.tenement.core.util.ImageUtils;
import com.example.tenement.dto.resp.ImgVerifyCodeRespDto;
import com.example.tenement.manager.redis.VerifyCodeManager;
import com.example.tenement.service.ResourceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * 资源（图片/视频/文档）相关服务实现类
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class ResourceServiceImpl implements ResourceService {

    private final VerifyCodeManager verifyCodeManager;
    @Autowired
    private ImageUtils imageUtils;
    @Override
    public RestResp<ImgVerifyCodeRespDto> getImgVerifyCode() throws IOException {
        String sessionId = IdWorker.get32UUID();
        return RestResp.ok(ImgVerifyCodeRespDto.builder()
            .sessionId(sessionId)
            .img(verifyCodeManager.genImgVerifyCode(sessionId))
            .build());
    }
    @Override
    public RestResp<Map<String, List<String>>> uploadImages(MultipartFile[] multipartFiles) {
        if(ObjectUtils.isEmpty(multipartFiles)){
            throw new BusinessException(ErrorCodeEnum.USER_UPLOAD_FILE_ERROR);
        }
        Map<String, List<String>> uploadImagesUrl = imageUtils.uploadImages(multipartFiles);
        return RestResp.ok(uploadImagesUrl);
    }

}
