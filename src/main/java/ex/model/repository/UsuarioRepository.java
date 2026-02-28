package ex.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ex.model.Usuario;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    UserDetails findByEmail(String email);
    List<Usuario> findAll();

    @Query("SELECT u FROM Usuario u WHERE LOWER(u.nome) LIKE LOWER(CONCAT('%', :nome, '%')) AND u.congregacao.idCongregacao = :idCongregacao")
    List<Usuario> findByNomeContainingIgnoreCaseAndCongregacao(@Param("nome") String nome, @Param("idCongregacao") Long idCongregacao);
}