package br.com.alura.backend.challenge1.AluraChallenge.dto.categoria;

import br.com.alura.backend.challenge1.AluraChallenge.entity.Categoria;

public record DadosListagemCategoriasDTO(Long id, String nome, String cor) {
    public DadosListagemCategoriasDTO(Categoria categoria) {
        this(categoria.getId(), categoria.getTitulo(), categoria.getCor());
    }
}
