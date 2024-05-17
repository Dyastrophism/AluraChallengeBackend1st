package br.com.alura.backend.challenge1.AluraChallenge.repository;

import br.com.alura.backend.challenge1.AluraChallenge.entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<Video, Long> {
}
