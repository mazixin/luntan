package com.fatie.luntan.domain;

import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * 回复实体类
 * */
@Data
public class Reply{

    private User user;

    private String id;

    private String topicId;

    private String replyUserId;

    private String createTime;

    private String updateTime;

    private String content;

}
