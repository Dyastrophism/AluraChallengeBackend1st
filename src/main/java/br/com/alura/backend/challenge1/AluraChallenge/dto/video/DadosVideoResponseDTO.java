package br.com.alura.backend.challenge1.AluraChallenge.dto.video;

public record DadosVideoResponseDTO(
        Long id,
        String nome,
        String descricao,
        String url
) {
}
