package br.com.alura.backend.challenge1.AluraChallenge.entity;

import br.com.alura.backend.challenge1.AluraChallenge.dto.video.DadosVideosDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "videos")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Video {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private String url;

    public Video(DadosVideosDTO dadosVideosDTO) {
        this.nome = dadosVideosDTO.nome();
        this.descricao = dadosVideosDTO.descricao();
        this.url = dadosVideosDTO.url();
    }

    public void atualizarInformacoes(DadosVideosDTO dadosVideosDTO) {
        this.nome = dadosVideosDTO.nome();
        this.descricao = dadosVideosDTO.descricao();
        this.url = dadosVideosDTO.url();
    }
}
