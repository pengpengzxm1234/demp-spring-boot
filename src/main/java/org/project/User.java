package org.project;

import java.util.Date;

/**
 * @author pengpeng
 * @date 2017/11/17 上午11:35
 * @desc
 */
public class User {
    private String name;
    private String sex;
    private int age;
    private Date date;

    public User(String name, String sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
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
}
