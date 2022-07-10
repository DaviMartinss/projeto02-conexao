package br.com.chat.chat.controller;

import java.io.Console;
import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.chat.chat.model.Usuario;
import br.com.chat.chat.services.UsuarioService;

@CrossOrigin(origins =  "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {
    
    @Autowired
    private UsuarioService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable Integer id){
        Usuario obj = this.service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> findAll() {
        List<Usuario> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Usuario> update(@PathVariable Integer id, @RequestBody Usuario obj){
        Usuario newObj = service.update(id, obj);
        return ResponseEntity.ok().body(newObj); 
    }

    @PostMapping
    public ResponseEntity<Usuario> create(@RequestBody Usuario obj){
    	System.out.println("Bateu");
        Usuario newObj = service.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    // @GetMapping(value = "/email/{email}")
    // public ResponseEntity<Usuario> findByEmail(@PathVariable String email){
    //     List<Usuario> list = service.findAll();
    //     return ResponseEntity.ok().body(list.get(list.indexOf(email)));
    // }

    @GetMapping(value = "/email/{email}")
    public ResponseEntity<Usuario> findByEmail(@PathVariable String email) {
        Usuario obj = service.findByEmail(email);
        return ResponseEntity.ok().body(obj);
    }

}
