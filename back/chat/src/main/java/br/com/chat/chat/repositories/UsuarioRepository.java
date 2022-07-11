package br.com.chat.chat.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.chat.chat.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> { 
 
    Optional<Usuario> findByEmail(String email);
    
    @Query(value = " SELECT * FROM usuario  WHERE email = :email and senha = :password", nativeQuery = true)
    Usuario findByEmailAndPassword(String email, String password);
   
}
