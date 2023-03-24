package com.app.web.Security;

import com.app.web.modelos.Usuario;
import com.app.web.repositorio.Usuario_repositorio;
import com.app.web.servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("usuarioDetailsService")
public class UsuarioDetailsServiceImpl implements UserDetailsService {


    @Autowired

    private Usuario_repositorio usuarioRepository;

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> usuarioOptional = usuarioRepository.findByEmail(username);
        Usuario usuario = usuarioOptional.orElseThrow(() -> new UsernameNotFoundException(username));

        List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority(usuario.getRol().getNombreRol()));
        return new User(usuario.getEmail(), usuario.getPassword(), roles);
    }

}


