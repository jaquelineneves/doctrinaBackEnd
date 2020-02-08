package com.app.doctrinabackend.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Disciplina implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String foto;

    // disciplina tem 1 professor
    @ManyToOne
    @JoinColumn(name="professor_id")
    private Professor professor;

    // disciplina tem varios modulos, foi mapeado pelo campo cliente
    @OneToMany(mappedBy = "disciplina")
    private List<Modulo> modulos = new ArrayList<>();

    public Disciplina(){

    }

    // td que for colecao, mais de um, vc nao coloca
    public Disciplina(Integer id, String nome, String foto, Professor professor) {
        this.id = id;
        this.nome = nome;
        this.foto = foto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public List<Modulo> getModulos() {
        return modulos;
    }

    public void setModulos(List<Modulo> modulos) {
        this.modulos = modulos;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    //GERAR DNV O HASHCODE EQUALS
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Disciplina)) return false;
        Disciplina that = (Disciplina) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
