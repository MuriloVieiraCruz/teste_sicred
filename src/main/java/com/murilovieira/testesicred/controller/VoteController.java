package com.murilovieira.testesicred.controller;

import com.murilovieira.testesicred.dto.VoteCreateDto;
import com.murilovieira.testesicred.service.impl.VoteServiceImpl;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vote")
public class VoteController {

    @Autowired
    private VoteServiceImpl voteService;

    @PostMapping("/vote")
    public ResponseEntity<?> voteInSession(
            @RequestParam
            @NotNull
            Long idSession,
            @Valid
            VoteCreateDto voteCreateDto) {
        voteService.voteInSession(idSession, voteCreateDto);
        return ResponseEntity.ok().build();
    }
}
