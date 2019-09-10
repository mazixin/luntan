package com.fatie.luntan.domain;
import lombok.Data;
import java.util.Date;

/**
 * 用户信息实体类
 */
@Data
public class User {

    private String id;
    private String username;
    private String password;
    private String email;
    private String phoneNum;
    private Date createTime;
    private Date updateTime;
    private Integer credit;
    private String avatar;
    private Byte type;
}
