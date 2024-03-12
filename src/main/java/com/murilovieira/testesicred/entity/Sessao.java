package com.murilovieira.testesicred.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.murilovieira.testesicred.entity.enums.EstadoSessao;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "sessao")
public class Sessao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "pauta_id")
    private Pauta pauta;

    @ManyToOne
    private List<Voto> votos = new ArrayList<>();

    @Column(name = "inicio_sessao", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm", timezone = "GMT")
    private LocalDateTime inicioSessao;

    @Column(name = "duracao_sessao", nullable = false)
    private Integer duracaoDaSessao;


    @Enumerated(value = EnumType.STRING)
    @Column(name = "estado_sessao", nullable = false)
    private EstadoSessao estadoSessao;

    public Sessao() {

    }

    public Sessao(Long id,
                  Pauta pauta,
                  List<Voto> votos,
                  LocalDateTime inicioSessao,
                  Integer duracaoDaSessao,
                  EstadoSessao estadoSessao
    ) {
        this.id = id;
        this.pauta = pauta;
        this.votos = votos;
        this.inicioSessao = inicioSessao;
        this.duracaoDaSessao = duracaoDaSessao;
        this.estadoSessao = estadoSessao;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pauta getPauta() {
        return pauta;
    }

    public void setPauta(Pauta pauta) {
        this.pauta = pauta;
    }

    public List<Voto> getVotos() {
        return votos;
    }

    public void setVotos(List<Voto> votos) {
        this.votos = votos;
    }

    public LocalDateTime getInicioSessao() {
        return inicioSessao;
    }

    public void setInicioSessao(LocalDateTime inicioSessao) {
        this.inicioSessao = inicioSessao;
    }

    public Integer getDuracaoDaSessao() {
        return duracaoDaSessao;
    }

    public void setDuracaoDaSessao(Integer duracaoDaSessao) {
        this.duracaoDaSessao = duracaoDaSessao;
    }

    public EstadoSessao getEstadoSessao() {
        return estadoSessao;
    }

    public void setEstadoSessao(EstadoSessao estadoSessao) {
        this.estadoSessao = estadoSessao;
    }
}
