package com.example.tenement.service;

import com.example.tenement.core.common.resp.RestResp;
import com.example.tenement.dto.resp.ImgVerifyCodeRespDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * 资源（图片/视频/文档）相关服务类
 */
public interface ResourceService {

    /**
     * 获取图片验证码
     *
     * @throws IOException 验证码图片生成失败
     * @return Base64编码的图片
     */
    RestResp<ImgVerifyCodeRespDto> getImgVerifyCode() throws IOException;

    /**
     * 图片上传
     * @param multipartFiles 需要上传的图片
     * @return 图片访问路径
     * */
    RestResp<Map<String, List<String>>> uploadImages(MultipartFile[] multipartFiles);
}
