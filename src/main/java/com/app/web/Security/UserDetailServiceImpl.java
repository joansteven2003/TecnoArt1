package com.app.web.Security;

import com.app.web.modelos.Usuario;
import com.app.web.repositorio.Usuario_repositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private Usuario_repositorio usuarioRepositorio;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
     Usuario usuario = usuarioRepositorio
                .findOneByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("El Usuario con email " + email + "no existe"));

  return new UserDetailsImpl(usuario);
    }
}
