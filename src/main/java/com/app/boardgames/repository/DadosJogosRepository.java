package com.app.boardgames.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.boardgames.model.DadosJogo;


@Transactional
@Repository
public interface DadosJogosRepository extends CrudRepository<DadosJogo,Long> {


    List<DadosJogo> findAll();




    List<DadosJogo> findByNomeDoJogoEqualsIgnoreCase(String nome);


    void delete(Optional<DadosJogo> dado);
}





//--------------------------tecnologia Spring DATA JPA----------------------------------

// ---------------------public List<DadosJogo> findAll ();----------------------------




