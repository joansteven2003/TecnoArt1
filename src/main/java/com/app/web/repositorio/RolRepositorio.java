package com.app.web.repositorio;

import com.app.web.modelos.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolRepositorio extends JpaRepository <Rol,Long> {
    public Rol findBy(Class<Rol> aClass, long id);
}
