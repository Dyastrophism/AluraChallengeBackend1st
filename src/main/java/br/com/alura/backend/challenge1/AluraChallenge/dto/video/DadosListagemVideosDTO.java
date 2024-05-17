package br.com.alura.backend.challenge1.AluraChallenge.dto.video;

import br.com.alura.backend.challenge1.AluraChallenge.entity.Video;

public record DadosListagemVideosDTO(Long id, String nome, String descricao, String url) {
    public DadosListagemVideosDTO(Video video) {
        this(video.getId(), video.getNome(), video.getDescricao(), video.getUrl());
    }
}
