package com.example.equestrian_event.dao.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import org.w3c.dom.Text;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.Year;

/**
 * <p>
 * 用户信息
 * </p>
 */
@TableName("user")
public class HorseInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 马匹名称
     */
    private String name;
    /**
     * 品种
     */
    private String breed;

    /**
     * 性别;1.公 2.母
     */
    private Integer gender;
    /**
     * 出生年份
     */
    private Year birthYear;
    /**
     * 血统信息
     */
    private Text pedigree;
    /**
     * 健康状况
     */
    private String healthStatus;
    /**
     * 创建时间
     */
    private LocalDateTime createdAt;

    /**
     * 更新时间
     */
    private LocalDateTime updatedAt;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Year getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(Year birthYear) {
        this.birthYear = birthYear;
    }

    public Text getPedigree() {
        return pedigree;
    }

    public void setPedigree(Text pedigree) {
        this.pedigree = pedigree;
    }

    public String getHealthStatus() {
        return healthStatus;
    }

    public void setHealthStatus(String healthStatus) {
        this.healthStatus = healthStatus;
    }

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

    @Override
    public String toString() {
        return "HorseInfo{" +
                "id=" + id +
                ", name=" + name +
                ", breed=" + breed +
                ", gender=" + gender +
                ", birthYear=" + birthYear +
                ", pedigree=" + pedigree +
                ", healthStatus=" + healthStatus +
                ", createAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                "}";
    }
}
