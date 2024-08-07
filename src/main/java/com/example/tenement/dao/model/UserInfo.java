package com.example.tenement.dao.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 用户信息
 * </p>
 */
@TableName("user")
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 登录名
     */
    private String username;
    /**
     * 昵称
     */
    private String nickName;

    /**
     * 用户头像
     */
    private String headImg;

    /**
     * 用户类型(1.个人2.房东3.中介)
     */
    private Integer userType;
    /**
     * 用户小程序唯一编号
     */
    private String openId;
    /**
     * 会员积分
     */
    private Integer points;
    /**
     * 创建时间
     */
    private LocalDateTime createdAt;

    /**
     * 更新时间
     */
    private LocalDateTime updatedAt;
    /**
     * 删除时间
     */
    private LocalDateTime deletedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public Integer getUserType(){return userType;}
    public void setUserType(Integer userType){this.userType = userType;}

    public String getOpenId(){return openId;}
    public void setOpenId(String openId){this.openId = openId;}
    public Integer getPoints(){return points;}
    public void setPoints(Integer points){this.points = points;}
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public LocalDateTime getDeletedAt() {return deletedAt;}
    public void setDeletedAt(LocalDateTime deletedAt) {this.deletedAt = deletedAt;}
    @Override
    public String toString() {
        return "UserInfo{" +
        "id=" + id +
        ", username=" + username +
        ", userType=" + userType +
        ", openId=" + openId +
        ", points=" + points +
        ", nickName=" + nickName +
        ", headImg=" + headImg +
        ", createAt=" + createdAt +
        ", updatedAt=" + updatedAt +
        "}";
    }
}
