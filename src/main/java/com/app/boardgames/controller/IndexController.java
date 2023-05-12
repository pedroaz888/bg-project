package com.app.boardgames.controller;

import java.security.Principal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import com.app.boardgames.model.DadosJogo;
import com.app.boardgames.repository.DadosJogosRepository;
import org.springframework.web.servlet.view.RedirectView;


@Repository
@Controller
public class IndexController {

    @Autowired
    private DadosJogosRepository pedidoRepository;


    @Transactional
    @GetMapping("/index")
    public String index(Model model, Principal principal) {

        PageRequest paginacao = PageRequest.of(0,7);

        List<DadosJogo>dados = pedidoRepository.findAll();
        model.addAttribute("dados",dados);

        return "index";
    }

    @Transactional
    @RequestMapping("/preco")
    public String preco(Model model, Principal principal) {

        Sort sort = Sort.by("preco").ascending();
        PageRequest paginacao = PageRequest.of(0,7,sort);

        List<DadosJogo>dados = pedidoRepository.findAll();
        model.addAttribute("dados",dados);

        return "index";

    }

    @Transactional
    @RequestMapping("/notas")
    public String notas(Model model, Principal principal) {

        Sort sort = Sort.by("nota").descending();
        PageRequest paginacao = PageRequest.of(0,7,sort);

        List<DadosJogo>dados = pedidoRepository.findAll();
        model.addAttribute("dados",dados);

        return "index";

    }

//    @Transactional
//    @RequestMapping("/notas")
//    public String notas(Model model, Principal principal) {
//
//        Sort sort = Sort.by("nota").descending();
//        PageRequest paginacao = PageRequest.of(0,7,sort);
//
//        List<DadosJogo>dados = pedidoRepository.findAll(paginacao);
//        model.addAttribute("dados",dados);
//
//        return "index";
//
//    }


    @Transactional
    @RequestMapping("/lista")
    public ModelAndView pesquisar (@RequestParam("nomeDoJogo")String nomeJogo){

        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("dados",pedidoRepository.findByNomeDoJogoEqualsIgnoreCase(nomeJogo));
        return modelAndView;
    }

    @Transactional
    @DeleteMapping("/dados/{id}")
    public String excluirJogo(@PathVariable(value = "id") Long id){

      pedidoRepository.deleteById(id);
      return "redirect:index";
    }


}
