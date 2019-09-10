package com.fatie.luntan.dao;


import com.fatie.luntan.domain.Topic;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

/**
 * 帖子信息持久化接口
 *
 * @author Hxx
 */


@Mapper
@Repository
public interface TopicMapper {

    /**
     * 发表新帖
     *
     * @param
     * @return
     * @topic
     */

    @Insert("INSERT INTO topic(id,create_time,update_time,title,content,click)VAlUES(#{topic.id},#{topic.createTime},#{topic.updateTime},#{topic.title},#{topic.content},#{topic.click})")
    @Results(id = "topicMap", value = {
            @Result(property = "id", column = "id"),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "tabId", column = "tab_id"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "updateTime", column = "update_time"),
            @Result(property = "title", column = "title"),
            @Result(property = "content", column = "content"),
            @Result(property = "click", column = "click")

    }
    )
    Topic addTopic(@Param("topic") Topic topic);

    /**
     * 根据用户id删除帖子
     *
     * @param id
     * @return
     */

    @ResultMap("topicMap")
    @Delete("DELETE FROM topic WHERE id=#{id} ")
    Topic deleteTopic(String id);

    /**
     * 根据用户id更新帖子
     *
     * @param topic
     */

    @ResultMap("topicMap")
    @Update("Update topic set create_time=#{topic.createTime},update_time=#{topic.updateTime},title=#{topic.title},content=#{topic.content} WHERE id=#{topic.id}")
    void update(@Param("topic") Topic topic);

}