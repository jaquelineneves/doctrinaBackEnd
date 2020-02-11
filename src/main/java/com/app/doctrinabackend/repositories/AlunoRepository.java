package com.app.doctrinabackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.doctrinabackend.domain.Aluno;

@Repository
public interface AlunoRepository  extends JpaRepository<Aluno, Integer> {
    //faz operacoes de acesso a dados

}