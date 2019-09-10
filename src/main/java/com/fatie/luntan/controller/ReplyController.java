package com.fatie.luntan.controller;


import com.fatie.luntan.domain.Reply;
import com.fatie.luntan.domain.Topic;
import com.fatie.luntan.service.ReplyService;
import com.fatie.luntan.service.TopicService;
import com.fatie.luntan.service.UserService;
import com.fatie.luntan.util.UUIDUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * 回复相关控制类
 */
@Controller
public class ReplyController {

    @Autowired
    private ReplyService replyService;
    @Autowired
    private UserService userService;
    @Autowired
    private TopicService topicService;


    /**
     * 添加评论
     * @param request
     * @return
     */
    @PostMapping("/reply/add")
    public String addReply(HttpServletRequest request) {
        try {
            HttpSession session = request.getSession();
            Reply user = (Reply) session.getAttribute("user");
            if (user == null) {
                request.setAttribute("msg", "请登录!!");
                return "login";
            }
            //从页面获取回复内容
            Map<String, String[]> parameterMap = request.getParameterMap();
            Reply reply = new Reply();
            // 带着封装好的对象数据 调用service
            BeanUtils.populate(reply, parameterMap);
            //回复内容id
            reply.setId(UUIDUtils.getUUID());
            //获取当前回帖用户
            reply.setId((String)session.getAttribute(user.getId()));
            // 获取当前回帖时间
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            String date = dateFormat.format(new Date());
            reply.setCreateTime(date);
            //调用service保存回复内容
            replyService.addReply(reply);
        }catch (IllegalAccessException | InvocationTargetException e){
            e.printStackTrace();
        }
        return "index.html";
    }

}