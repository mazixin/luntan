package com.fatie.luntan.domain;


import com.fasterxml.jackson.databind.ser.Serializers;
import javafx.scene.control.Tab;
import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 主题实体类
 */
@Data
public class Topic {

    private User user;
    private Tab tab;
    private Integer countReplies;
    private Integer userId;
    private Date createTime;
    private Date updateTime;
    private String title;
    private Integer click;
    private Byte tabId;
    private String content;
}
