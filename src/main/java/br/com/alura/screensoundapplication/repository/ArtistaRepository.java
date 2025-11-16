package br.com.alura.screensoundapplication.repository;

import br.com.alura.screensoundapplication.model.Artista;
import br.com.alura.screensoundapplication.model.Musica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ArtistaRepository extends JpaRepository<Artista, Long> {

    Optional<Artista> findByNomeContainingIgnoreCase(String nome);

    @Query("""
            SELECT m 
            FROM Artista a 
            JOIN a.musicas m
            WHERE LOWER (a.nome) LIKE LOWER(CONCAT('%', :nome%, '%'))
            """)
    List<Musica> buscaMusicasPorArtista(String nome);
}
