package com.app.boardgames.controller;


import java.beans.Transient;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.boardgames.dto.RequisicaoNovoJogo;
import com.app.boardgames.model.DadosJogo;
import com.app.boardgames.repository.DadosJogosRepository;

//@Controller
//@Repository
//public class JogosAddController {
//
////-----------------@Autowired--------------------------------------------------
//    //spring cria uma instância dessa classe
//    // e vai utilizar essa classe para salvar os dados no banco de dados
//
//    @Autowired
//    private DadosJogosRepository dadosJogosRepository;
//
//    @Transactional
//    @GetMapping("/dados/formulario")
//    public String formulario(RequisicaoNovoJogo requisicao) {
//        return "dados/formulario";
//    }
//
//
//
//
//    @Transactional
//    @PostMapping("/dados/novo")
//    public String novo(@Valid RequisicaoNovoJogo requisicao,BindingResult result) {
//        if(result.hasErrors()) {
//            return "dados/formulario";
//        }
//        DadosJogo dadosJogo = requisicao.toDadosJogos();
//        dadosJogosRepository.save(dadosJogo);
//        return "redirect:index";
//    }
//
//}

@Controller
@Repository
public class JogosAddController {

    @Autowired
    private DadosJogosRepository dadosJogosRepository;

    @Transactional
    @GetMapping("/dados/formulario")
    public String formulario(Model model) {
        model.addAttribute("requisicaoNovoJogo", new RequisicaoNovoJogo());
        return "dados/formulario";
    }

    @Transactional
    @PostMapping("/dados/novo")
    public String novo(@Valid RequisicaoNovoJogo requisicao, BindingResult result) {
        if (result.hasErrors()) {
            return "dados/formulario";
        }
        DadosJogo dadosJogo = requisicao.toDadosJogos();
        dadosJogosRepository.save(dadosJogo);
        return "redirect:index";
    }
}