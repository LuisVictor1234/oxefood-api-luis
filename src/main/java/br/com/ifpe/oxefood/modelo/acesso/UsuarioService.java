package br.com.ifpe.oxefood.modelo.acesso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public UsuarioService(UsuarioRepository repo, AuthenticationManager auth, PasswordEncoder encoder) {
        this.repository = repo;
        this.authenticationManager = auth;
        this.passwordEncoder = encoder;
    }

    public Usuario authenticate(String username, String password) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        return repository.findByUsername(username).orElseThrow();
    }

    @Transactional
    public Usuario save(Usuario user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setHabilitado(true);
        return repository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));
    }
}
