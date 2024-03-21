package com.murilovieira.testesicred.controller;

import com.murilovieira.testesicred.dto.SessionCreateDto;
import com.murilovieira.testesicred.service.impl.SessionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/session")
public class SessionController {

    @Autowired
    private SessionService sessionService;

    @PostMapping("/create")
    public ResponseEntity<?> createSession(@RequestBody @Valid SessionCreateDto sessionCreateDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(sessionService.createSession(sessionCreateDto));
    }
}
