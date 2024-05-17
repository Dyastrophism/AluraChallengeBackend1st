package br.com.alura.backend.challenge1.AluraChallenge.controller;

import br.com.alura.backend.challenge1.AluraChallenge.dto.categoria.DadosCategoriaDTO;
import br.com.alura.backend.challenge1.AluraChallenge.dto.categoria.DadosCategoriaResponseDTO;
import br.com.alura.backend.challenge1.AluraChallenge.dto.categoria.DadosListagemCategoriasDTO;
import br.com.alura.backend.challenge1.AluraChallenge.service.CategoriaService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("/categorias")
public class CategoriasController {

    private final CategoriaService categoriaService;

    public CategoriasController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemCategoriasDTO>> listarCategorias(@PageableDefault(sort = {"titulo"}) Pageable pageable) {
        try {
            Page<DadosListagemCategoriasDTO> categorias = categoriaService.listarCategorias(pageable);
            return ResponseEntity.ok(categorias);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<DadosCategoriaResponseDTO> salvarCategoria(@RequestBody @Valid DadosCategoriaDTO dadosCategoriaDTO, UriComponentsBuilder uriComponentsBuilder) {
        try {
            DadosCategoriaResponseDTO categoriaSalva = categoriaService.salvarCategoria(dadosCategoriaDTO);
            return ResponseEntity.created(uriComponentsBuilder.path("/categorias/{id}").buildAndExpand(categoriaSalva.id()).toUri()).body(categoriaSalva);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosCategoriaDTO> buscarCategoriaPorId(@PathVariable Long id) {
        try {
            DadosCategoriaDTO categoria = categoriaService.buscarCategoriaPorId(id);
            return ResponseEntity.ok(categoria);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<DadosCategoriaDTO> atualizarCategoria(@PathVariable Long id, @RequestBody @Valid DadosCategoriaDTO dadosCategoriaDTO) {
        try {
            DadosCategoriaDTO categoriaAtualizada = categoriaService.atualizarCategoria(id, dadosCategoriaDTO);
            return ResponseEntity.ok(categoriaAtualizada);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCategoria(@PathVariable Long id) {
        try {
            categoriaService.deletarCategoria(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}