package br.com.alura.backend.challenge1.AluraChallenge.dto.video;

import jakarta.validation.constraints.NotBlank;

public record DadosVideosDTO(
        @NotBlank(message = "O nome é obrigatório")
        String nome,
        @NotBlank(message = "A descrição é obrigatória")
        String descricao,
        @NotBlank(message = "A URL é obrigatória")
        String url
) {
}
