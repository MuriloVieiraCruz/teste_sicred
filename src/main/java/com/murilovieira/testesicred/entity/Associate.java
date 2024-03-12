package com.murilovieira.testesicred.entity;

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
@SequenceGenerator(name = "associate_sequence", sequenceName = "sq_tb_associate", allocationSize = 1)
@Table(name = "tb_associate")
public class Associate {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "associate_sequence")
    private Long id;

    @Column(name = "nr_cpf", nullable = false)
    private String cpf;
}
