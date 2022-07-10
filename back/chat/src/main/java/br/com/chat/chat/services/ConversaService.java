package br.com.chat.chat.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.chat.chat.model.Conversa;
import br.com.chat.chat.repositories.ConversaRepository;
import br.com.chat.chat.services.exceptions.ObjectNotFoundException;

@Service
public class ConversaService {
    

    @Autowired ConversaRepository repository;

    public Conversa findById(Integer id){
        Optional<Conversa> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Conversa.class.getName()));
    }

    public List<Conversa> findAll() {
        return repository.findAll();
    }

    public Conversa update(Integer id, Conversa obj) {
        Conversa newObj = findById(id);
        newObj.setConteudo(obj.getConteudo());
        newObj.setidUser1(obj.getidUser1());
        newObj.setidUser2(obj.getidUser2());
        return repository.save(newObj);
    }

    public Conversa create(Conversa obj) {
        obj.setId(null);
        return repository.save(obj);
    }

    public void delete(Integer id) {
        findById(id);
        repository.deleteById(id);
    }

    public Conversa findByIdUser1(Integer iduser1) {
        Optional<Conversa> obj = repository.findByIdUser1(iduser1);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Email: " + iduser1 + ", Tipo"+ UsuarioService.class.getName()));
    }

}
