package com.murilovieira.testesicred.controller;

import com.murilovieira.testesicred.dto.DiscussionCreateDto;
import com.murilovieira.testesicred.service.impl.DiscussionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/discussion")
public class DiscussionController {

    @Autowired
    private DiscussionService discussionService;

    @PostMapping("/create")
    public ResponseEntity<?> createDiscussion(@RequestBody @Valid DiscussionCreateDto discussionCreateDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(discussionService.createDiscussion(discussionCreateDto));
    }
}