package com.example.equestrian_event.controller;

import com.example.equestrian_event.core.common.resp.RestResp;
import com.example.equestrian_event.core.constant.ApiRouterConsts;
import  com.example.equestrian_event.dto.resp.ImgVerifyCodeRespDto;
import  com.example.equestrian_event.service.ResourceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * 资源模块 api 控制器
 */
@Tag(name = "ResourceController", description = "资源模块")
@RestController
@RequestMapping(ApiRouterConsts.API_FRONT_RESOURCE_URL_PREFIX)
@RequiredArgsConstructor
public class ResourceController {

    private final ResourceService resourceService;
    /**
     * 获取图片验证码接口
     */
    @Operation(summary = "获取图片验证码接口")
    @GetMapping("img_verify_code")
    public RestResp<ImgVerifyCodeRespDto> getImgVerifyCode() throws IOException {
        return resourceService.getImgVerifyCode();
    }

    /**
     * 图片上传接口
     */
    @Operation(summary = "图片上传接口")
    @PostMapping(value = "/image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    RestResp<Map<String, List<String>>> uploadImages(@RequestParam("files") MultipartFile[] multipartFile) {
        return resourceService.uploadImages(multipartFile);
    }

}
