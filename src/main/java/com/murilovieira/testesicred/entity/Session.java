package com.murilovieira.testesicred.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.murilovieira.testesicred.entity.enums.SessionState;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "tb_session")
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dt_session_start", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm", timezone = "GMT")
    private LocalDateTime sessionStart;

    @Column(name = "tm_session_duration", nullable = false)
    private Integer sessionDuration;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "nr_session_state", nullable = false)
    private SessionState sessionState;

    @OneToOne
    @JoinColumn(name = "id_discussion", nullable = false)
    private Discussion discussion;

    @ManyToOne
    private List<Vote> votes = new ArrayList<>();

    public Session(LocalDateTime sessionStart, Integer sessionDuration, SessionState sessionState, Discussion discussion, List<Vote> votes) {
        this.sessionStart = sessionStart;
        this.sessionDuration = sessionDuration;
        this.sessionState = sessionState;
        this.discussion = discussion;
        this.votes = votes;
    }

    private void sessionDurationValidation(Integer sessionDuration) {
        if (this.sessionDuration == null) {
            this.sessionDuration = Math.toIntExact(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(1));
        }
    }
}
