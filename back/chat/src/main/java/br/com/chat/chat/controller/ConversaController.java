package br.com.chat.chat.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.chat.chat.model.Conversa;
import br.com.chat.chat.services.ConversaService;

@RestController
@RequestMapping(value = "/conversa")
public class ConversaController {
    
    @Autowired ConversaService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Conversa> findById(@PathVariable Integer id){
        Conversa obj = this.service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping
    public ResponseEntity<List<Conversa>> findAll() {
        List<Conversa> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Conversa> update(@PathVariable Integer id, @RequestBody Conversa obj){
        Conversa newObj = service.update(id, obj);
        return ResponseEntity.ok().body(newObj); 
    }

    @PostMapping
    public ResponseEntity<Conversa> create(@RequestBody Conversa obj){
        Conversa newObj = service.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/find/{iduser1}")
    public ResponseEntity<Conversa> findByEmail(@PathVariable Integer iduser1) {
        Conversa obj = service.findByIdUser1(iduser1);
        return ResponseEntity.ok().body(obj);
    }

}
