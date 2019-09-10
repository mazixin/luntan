package com.fatie.luntan.service;

import com.fatie.luntan.dao.ReplyMapper;
import com.fatie.luntan.domain.Reply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ReplyService {
    @Autowired
    private ReplyMapper replyMapper;

    /**
     * 添加评论
     * @param reply
     * @return
     */
    public Reply addReply(Reply reply){
        return replyMapper.addReply(reply);
    }

}
