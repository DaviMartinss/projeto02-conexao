package br.com.chat.chat.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.chat.chat.model.Usuario;
import br.com.chat.chat.repositories.UsuarioRepository;
import br.com.chat.chat.services.exceptions.ObjectNotFoundException;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository repository;

    public Usuario findById(Integer id){
        Optional<Usuario> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Usuario.class.getName()));
    }

    public List<Usuario> findAll() {
        return repository.findAll();
    }

    public Usuario update(Integer id, Usuario obj) {
        Usuario newObj = findById(id);
        newObj.setNome(obj.getNome());
        newObj.setFoto(obj.getFoto());
        newObj.setGenero(obj.getGenero());
        newObj.setSenha(obj.getSenha());
        return repository.save(newObj);

    }

    public Usuario create(Usuario obj) {
        obj.setId(null);
        return repository.save(obj);
    }

    public void delete(Integer id) {
        findById(id);
        repository.deleteById(id);

    }

    public Usuario findByEmail(String email) {
        Optional<Usuario> obj = repository.findByEmail(email); 
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Email: " + email + ", Tipo"+ UsuarioService.class.getName()));
    }
    
    public Usuario findByEmailAndPassword(String email, String password) {
        Usuario obj = repository.findByEmailAndPassword(email, password); 
        return obj;
    }
}
