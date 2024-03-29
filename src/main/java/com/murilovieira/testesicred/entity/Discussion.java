package com.murilovieira.testesicred.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "tb_discussion")
public class Discussion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "ds_subject", nullable = false)
    private String subject;

    @NotNull
    @Column(name = "ds_description", nullable = false)
    private String description;

    @Column(name = "dt_creation_date", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone = "GMT")
    private LocalDate creationDate;

    @Column(name = "nr_total_votes_yes")
    private Integer totalVotesYes;

    @Column(name = "nr_total_votes_no")
    private Integer totalVotesNo;
}
