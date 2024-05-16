package br.com.alura.backend.challenge1.AluraChallenge.controller;

import br.com.alura.backend.challenge1.AluraChallenge.dto.DadosVideosDTO;
import br.com.alura.backend.challenge1.AluraChallenge.service.VideoService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@RestController
@RequestMapping("/videos")
public class VideoController {

    private final VideoService videoService;

    public VideoController(VideoService videoService) {
        this.videoService = videoService;
    }

    @GetMapping
    public ResponseEntity<Page<DadosVideosDTO>> listarVideos(Pageable pageable) {
        try {
            var videos = videoService.listarVideos(pageable);
            return ResponseEntity.ok(videos);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarVideoPorId(@PathVariable Long id) {
        try {
            DadosVideosDTO video = videoService.buscarVideoPorId(id);
            return ResponseEntity.ok(video);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @PostMapping
    @Transactional
    public ResponseEntity<DadosVideosDTO> salvarVideo(@RequestBody @Valid DadosVideosDTO dadosVideosDTO, UriComponentsBuilder uriComponentsBuilder) {
        try {
            DadosVideosDTO videoSalvo = videoService.salvarVideo(dadosVideosDTO);
            return ResponseEntity.created(uriComponentsBuilder.path("/videos/{id}").buildAndExpand(videoSalvo).toUri()).body(videoSalvo);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Optional<DadosVideosDTO>> atualizarVideo(@PathVariable Long id, @RequestBody DadosVideosDTO dadosVideosDTO) {
        try {
            Optional<DadosVideosDTO> videoSalvo = videoService.atualizarVideo(id, dadosVideosDTO);
            return ResponseEntity.ok(videoSalvo);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deletarVideo(@PathVariable Long id) {
        try {
            videoService.deletarVideo(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }
}
