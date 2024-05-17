package br.com.alura.backend.challenge1.AluraChallenge.repository;

import br.com.alura.backend.challenge1.AluraChallenge.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriasRepository extends JpaRepository<Categoria, Long> {


}
