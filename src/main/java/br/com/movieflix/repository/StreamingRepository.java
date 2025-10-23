package br.com.movieflix.repository;

import br.com.movieflix.entity.Streaming;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StreamingRepository extends JpaRepository<Streaming, Long> {
}
