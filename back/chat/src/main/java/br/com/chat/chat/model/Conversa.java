package br.com.chat.chat.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Conversa implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Integer id;
    
    @Column(nullable = false)
    private Integer idUser1;
    @Column(nullable = false)
    private Integer idUser2;
    @Column(columnDefinition = "MEDIUMTEXT")
    private String conteudo;
    
    public Conversa(Integer id, Integer idUser1, Integer idUser2, String conteudo) {
        this.id = id;
        this.idUser1 = idUser1;
        this.idUser2 = idUser2;
        this.conteudo = conteudo;
    }

    public Conversa() {
        super();
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getidUser1() {
        return idUser1;
    }

    public void setidUser1(Integer idUser1) {
        this.idUser1 = idUser1;
    }

    public Integer getidUser2() {
        return idUser2;
    }

    public void setidUser2(Integer idUser2) {
        this.idUser2 = idUser2;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    
    
}
