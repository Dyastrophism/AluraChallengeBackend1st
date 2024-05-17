package br.com.alura.backend.challenge1.AluraChallenge.service;

import br.com.alura.backend.challenge1.AluraChallenge.dto.categoria.DadosCategoriaDTO;
import br.com.alura.backend.challenge1.AluraChallenge.dto.categoria.DadosCategoriaResponseDTO;
import br.com.alura.backend.challenge1.AluraChallenge.dto.categoria.DadosListagemCategoriasDTO;
import br.com.alura.backend.challenge1.AluraChallenge.entity.Categoria;
import br.com.alura.backend.challenge1.AluraChallenge.repository.CategoriasRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    private final CategoriasRepository categoriasRepository;

    public CategoriaService(CategoriasRepository categoriasRepository) {
        this.categoriasRepository = categoriasRepository;
    }

    public Page<DadosListagemCategoriasDTO> listarCategorias(Pageable pageable) {
        return categoriasRepository.findAll(pageable).map(DadosListagemCategoriasDTO::new);
    }

    public DadosCategoriaResponseDTO salvarCategoria(DadosCategoriaDTO dadosCategoriaDTO) {
        Categoria novaCategoria = new Categoria(dadosCategoriaDTO);
        Categoria categoriaSalva = categoriasRepository.save(novaCategoria);
        return new DadosCategoriaResponseDTO(categoriaSalva.getId(), categoriaSalva.getTitulo(), categoriaSalva.getCor());
    }

    public void deletarCategoria(Long id) {
        if (!categoriasRepository.existsById(id)) {
            throw new RuntimeException("Categoria não encontrada");
        }
        categoriasRepository.deleteById(id);
    }

    public DadosCategoriaDTO atualizarCategoria(Long id, DadosCategoriaDTO dadosCategoriaDTO) {
        Categoria categoria = categoriasRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
        categoria.atualizarInformacoes(dadosCategoriaDTO);
        Categoria categoriaAtualizada = categoriasRepository.save(categoria);
        return converterParaDTO(categoriaAtualizada);
    }

    public DadosCategoriaDTO buscarCategoriaPorId(Long id) {
        Categoria categoria = categoriasRepository.findById(id).orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
        return converterParaDTO(categoria);
    }

    private DadosCategoriaDTO converterParaDTO(Categoria categoria) {
        return new DadosCategoriaDTO(categoria.getTitulo(), categoria.getCor());
    }
}
