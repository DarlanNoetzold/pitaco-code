package tech.noetzold.pitacocode.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tech.noetzold.pitacocode.model.Post;

import java.util.List;

public interface PostService extends JpaRepository<Post, Long> {
    @Query("select p from Post p where p.usuario = ?1")
    List<Post> findAllByUsuario(String usuario);
}
