package com.murilovieira.testesicred.entity;

import com.murilovieira.testesicred.entity.enums.VoteAnswer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "tb_vote")
public class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "vl_vote_answer", nullable = false)
    private Boolean voteAnswer;

    @ManyToOne
    @JoinColumn(name = "associate_id", nullable = false)
    private Associate associate;

    @ManyToOne
    @JoinColumn(name = "session_id", nullable = false)
    private Session session;
}
