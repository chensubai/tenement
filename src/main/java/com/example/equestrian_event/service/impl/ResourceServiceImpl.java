package com.example.equestrian_event.service.impl;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.example.equestrian_event.core.common.constant.ErrorCodeEnum;
import com.example.equestrian_event.core.common.exception.BusinessException;
import com.example.equestrian_event.core.common.resp.RestResp;
import com.example.equestrian_event.core.constant.SystemConfigConsts;
import com.example.equestrian_event.core.util.ImageUtils;
import com.example.equestrian_event.dto.resp.ImgVerifyCodeRespDto;
import com.example.equestrian_event.manager.redis.VerifyCodeManager;
import com.example.equestrian_event.service.ResourceService;
import io.netty.handler.codec.http.HttpResponseStatus;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Objects;

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
    @Value("${equestrian.file.upload.path}")
    private String fileUploadPath;

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
