package org.project.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @author pengpeng
 * @date 2017/11/17 上午11:35
 * @desc
 */
public class User {
    @ApiModelProperty(name = "姓名")
    private String name;
    @ApiModelProperty(name = "性别")
    private String sex;
    @ApiModelProperty(name = "年龄")
    private int age;
    @ApiModelProperty(name = "时间 yyyy-MM-dd HH:mm:ss")
    private Date date;

    public User(String name, String sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
