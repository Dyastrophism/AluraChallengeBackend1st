package br.com.alura.backend.challenge1.AluraChallenge.entity;

import br.com.alura.backend.challenge1.AluraChallenge.dto.categoria.DadosCategoriaDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "categorias")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String cor;

    public Categoria(DadosCategoriaDTO dadosCategoriaDTO) {
        this.titulo = dadosCategoriaDTO.titulo();
        this.cor = dadosCategoriaDTO.cor();
    }

    public void atualizarInformacoes(DadosCategoriaDTO dadosCategoriaDTO) {
        this.titulo = dadosCategoriaDTO.titulo();
        this.cor = dadosCategoriaDTO.cor();
    }
}
