package com.murilovieira.testesicred.service.impl;

import com.murilovieira.testesicred.dto.DiscussionCreateDto;
import com.murilovieira.testesicred.entity.Discussion;
import com.murilovieira.testesicred.entity.Session;
import com.murilovieira.testesicred.entity.enums.SessionState;
import com.murilovieira.testesicred.repository.DiscussionRepository;
import com.murilovieira.testesicred.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class DiscussionServiceImpl {

    @Autowired
    private DiscussionRepository discussionRepository;

    public Discussion createDiscussion(DiscussionCreateDto discussionCreateDto) {
        Discussion newDiscussion = Discussion.builder()
                .description(discussionCreateDto.description())
                .subject(discussionCreateDto.subject())
                .build();
        return discussionRepository.save(newDiscussion);
    }
}
