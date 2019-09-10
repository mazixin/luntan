package com.fatie.luntan.dao;

import com.fatie.luntan.domain.Reply;
import com.fatie.luntan.domain.Topic;
import com.fatie.luntan.domain.User;
import org.apache.ibatis.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ReplyMapper {
    /**
     * 添加评论
     * @param reply
     * @return
     */

    @Results(id = "replyMap", value = {
            @Result(property = "id", column = "id"),
            @Result(property = "topicId", column = "topic_id"),
            @Result(property = "replyUserId", column = "reply_user_id"),
            @Result(property = "replyTime", column = "reply_time"),
            @Result(property = "content", column = "content")
    })
    @Insert("insert into reply(id,topic_id,reply_user_id,reply_time,content)VALUES(#{reply.id},#{reply.topicId},#{reply.replyUserId},#{reply.replyTime},#{reply.content})")
    Reply addReply(@Param("reply") Reply reply);

}
