package br.com.alura.backend.challenge1.AluraChallenge.service;

import br.com.alura.backend.challenge1.AluraChallenge.dto.video.DadosVideoResponseDTO;
import br.com.alura.backend.challenge1.AluraChallenge.dto.video.DadosVideosDTO;
import br.com.alura.backend.challenge1.AluraChallenge.entity.Video;
import br.com.alura.backend.challenge1.AluraChallenge.repository.VideoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VideoService {

        private final VideoRepository videoRepository;

        public VideoService(VideoRepository videoRepository) {
            this.videoRepository = videoRepository;
        }

        public Page<DadosVideosDTO> listarVideos(Pageable pageable) {
            return videoRepository.findAll(pageable).map(video -> new DadosVideosDTO(video.getNome(), video.getDescricao(), video.getUrl()));
        }

        public DadosVideosDTO buscarVideoPorId(Long id) {
            Video video = videoRepository.findById(id).orElseThrow(() -> new RuntimeException("Video não encontrado"));
            return new DadosVideosDTO(video.getNome(), video.getDescricao(), video.getUrl());
        }

        public DadosVideoResponseDTO salvarVideo(DadosVideosDTO dadosVideosDTO) {
            try {
                Video video = new Video(dadosVideosDTO);
                Video videoSalvo = videoRepository.save(video);
                return new DadosVideoResponseDTO(videoSalvo.getId(), videoSalvo.getNome(), videoSalvo.getDescricao(), videoSalvo.getUrl());
            } catch (Exception e) {
                throw new RuntimeException("Erro ao salvar video", e);
            }
        }

        public void deletarVideo(Long id) {
            try {
                videoRepository.deleteById(id);
            } catch (Exception e) {
                throw new RuntimeException("Erro ao deletar video", e);
            }
        }

        public Optional<DadosVideosDTO> atualizarVideo(Long id, DadosVideosDTO dadosVideosDTO) {
            try {
                Video atualizar = videoRepository.findById(id).orElseThrow(() -> new RuntimeException("Video not found"));
                atualizar.setNome(dadosVideosDTO.nome());
                atualizar.setDescricao(dadosVideosDTO.descricao());
                atualizar.setUrl(dadosVideosDTO.url());
                Video videoSalvo = videoRepository.save(atualizar);
                return Optional.of(new DadosVideosDTO(videoSalvo.getNome(), videoSalvo.getDescricao(), videoSalvo.getUrl()));
            } catch (Exception e) {
                throw new RuntimeException("Erro ao atualizar video", e);
            }
        }
}
