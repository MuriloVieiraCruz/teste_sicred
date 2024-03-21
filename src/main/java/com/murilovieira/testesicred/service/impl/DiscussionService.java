package com.murilovieira.testesicred.service.impl;

import com.murilovieira.testesicred.dto.DiscussionCreateDto;
import com.murilovieira.testesicred.entity.Discussion;
import com.murilovieira.testesicred.repository.DiscussionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class DiscussionService {

    @Autowired
    private DiscussionRepository discussionRepository;

    @Transactional
    public Discussion createDiscussion(DiscussionCreateDto discussionCreateDto) {
        Discussion newDiscussion = Discussion.builder()
                .description(discussionCreateDto.description())
                .subject(discussionCreateDto.subject())
                .creationDate(LocalDate.now())
                .build();
        return discussionRepository.save(newDiscussion);
    }
}
