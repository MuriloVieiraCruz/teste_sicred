package com.murilovieira.testesicred.controller;

import com.murilovieira.testesicred.dto.SessionCreateDto;
import com.murilovieira.testesicred.service.impl.SessionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sessao")
public class SessionController {

    @Autowired
    private SessionServiceImpl sessionService;

    @PostMapping("/criar")
    public ResponseEntity<?> createSession(SessionCreateDto sessionCreateDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(sessionService.createSession(sessionCreateDto));
    }

    @PostMapping("/vote")
    public ResponseEntity<?> voteInSession(SessionCreateDto sessionCreateDto) {
        //sessionService.createSession()
        return null;
    }

}
