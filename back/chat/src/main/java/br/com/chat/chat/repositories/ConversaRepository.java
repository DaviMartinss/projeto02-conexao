package br.com.chat.chat.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.chat.chat.model.Conversa;

public interface ConversaRepository extends JpaRepository<Conversa, Integer>{
 
    Optional<Conversa> findByIdUser1(Integer idUser1 );
}
