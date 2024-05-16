package br.com.alura.backend.challenge1.AluraChallenge.entity;

import br.com.alura.backend.challenge1.AluraChallenge.dto.DadosVideosDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    private String nome;
    private String descricao;
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
