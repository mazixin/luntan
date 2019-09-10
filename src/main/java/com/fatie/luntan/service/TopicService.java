package com.fatie.luntan.service;

import com.fatie.luntan.dao.TopicMapper;
import com.fatie.luntan.domain.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Hxx
 */
@Service
public class TopicService {
    @Autowired
    private TopicMapper topicMapper;

    public void addTopic(Topic topic){
        topicMapper.addTopic(topic);
    }

}