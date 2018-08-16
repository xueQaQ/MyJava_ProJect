package com.bittech.javaweb.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Student {
    
    /**
     * 学生编号
     */
    private int stuId;
    
    /**
     * 学号
     */
    private String stuNo;
    
    /**
     * 姓名
     */
    private String stuName;
    
    /**
     * 性别
     */
    private String sex;
    
    /**
     * 生日
     */
    private Date birthday;
    
    /**
     * 所在班级
     */
    private int gradeId = -1;
    
    /**
     * 电子邮箱
     */
    private String email;
    
    /**
     * 学生备注
     */
    private String stuDesc;
    
    /**
     * 班级名称
     */
    private String gradeName;
}
