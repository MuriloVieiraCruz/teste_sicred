package com.murilovieira.testesicred.config;

import com.murilovieira.testesicred.repository.DiscussionRepository;
import com.murilovieira.testesicred.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
@EnableAsync
public class TimerVerifier {

    @Autowired
    private SessionRepository sessionRepository;

    @Autowired
    private DiscussionRepository discussionRepository;

//    public void endSession() {
//        sessaoAberta = false;
//    }

    @Async
    @Scheduled(fixedRate = 30000)
    public void verifyTime() {
        System.out.println("Funcionou, tempo:" + System.currentTimeMillis());
    }
}
