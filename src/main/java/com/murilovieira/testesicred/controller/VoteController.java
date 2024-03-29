package com.murilovieira.testesicred.controller;

import com.murilovieira.testesicred.dto.VoteCreateDto;
import com.murilovieira.testesicred.service.impl.VoteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vote")
public class VoteController {

    @Autowired
    private VoteService voteService;

    @PostMapping("/vote-session/{sessionId}")
    public ResponseEntity<?> voteInSession(
            @PathVariable("sessionId")
            Long sessionId,
            @RequestBody
            @Valid
            VoteCreateDto voteCreateDto) {
        try {
            voteService.voteInSession(sessionId, voteCreateDto);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
