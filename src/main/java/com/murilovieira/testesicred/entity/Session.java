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

    @Column(name = "dt_session_end", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm", timezone = "GMT")
    private LocalDateTime sessionEnd;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "nr_session_state", nullable = false)
    private SessionState sessionState;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "discussion_id", nullable = false)
    private Discussion discussion;

    public void validateSessionDuration() {
        if (this.sessionDuration == null) {
            this.sessionDuration = Math.toIntExact(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(1));
        }
        addSessionEnd();
    }

    public void addSessionEnd() {
        this.sessionEnd = LocalDateTime.now().plusMinutes(this.sessionDuration);
    }
}
