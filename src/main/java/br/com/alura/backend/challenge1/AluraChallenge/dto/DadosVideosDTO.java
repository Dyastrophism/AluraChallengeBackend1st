package br.com.alura.backend.challenge1.AluraChallenge.dto;

import jakarta.validation.constraints.NotBlank;

public record DadosVideosDTO(
        @NotBlank
        String nome,
        @NotBlank
        String descricao,
        @NotBlank
        String url
) {
}
