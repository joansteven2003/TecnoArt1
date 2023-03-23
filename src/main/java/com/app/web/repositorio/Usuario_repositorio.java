package com.app.web.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.app.web.modelos.Usuario;

import java.util.Optional;

@Repository
public interface Usuario_repositorio extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findOneByEmail(String email);


}
