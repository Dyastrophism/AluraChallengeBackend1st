package br.com.alura.backend.challenge1.AluraChallenge.dto.categoria;

import jakarta.validation.constraints.NotBlank;

public record DadosCategoriaDTO(
        @NotBlank(message = "O título é obrigatório")
        String titulo,
        @NotBlank(message = "A cor é obrigatória")
        String cor
) {
}
