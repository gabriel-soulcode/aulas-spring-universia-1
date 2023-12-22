package com.soulcode.estudandospring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.soulcode.estudandospring.model.Filme;
import com.soulcode.estudandospring.repository.FilmeRepository;

@Controller
public class FilmeController {

  @Autowired
  private FilmeRepository filmeRepository;
  
  @GetMapping(value = "/filmes")
  public ModelAndView filmes() {
    try {
      List<Filme> filmes = filmeRepository.findAll();
      ModelAndView mv = new ModelAndView("filmes");
      mv.addObject("fils", filmes);
      return mv;
    } catch(Exception ex) {
      ModelAndView erro = new ModelAndView("erro");
      erro.addObject("msg", "Erro interno no servidor.");
      return erro;
    }
  }

  @GetMapping(value = "/filmes/{id}")
  public ModelAndView clientById(@PathVariable Integer id) {
    try {
      Optional<Filme> filmeOpt = filmeRepository.findById(id);
      if(filmeOpt.isPresent()) {
        Filme filme = filmeOpt.get();
        ModelAndView mv = new ModelAndView("filme");
        mv.addObject("fil", filme);
        return mv;
      }
      else {
        ModelAndView erro = new ModelAndView("erro");
        erro.addObject("msg", "Filme não encontrado.");
        return erro;
      }
    } catch(Exception ex) {
      ModelAndView erro = new ModelAndView("erro");
      erro.addObject("msg", "Erro interno no servidor.");
      return erro;
    }
  }

  @PostMapping(value = "/filmes/delete")
  public String delete(@RequestParam Integer id) {
    try {
      filmeRepository.deleteById(id);
    } catch(Exception ex) {
      return "erro";
    }
    return "redirect:/filmes";
  }

  @PostMapping(value = "/filmes")
  public String create(Filme filme) {
    try {
      filmeRepository.save(filme);
    } catch(Exception ex) {
      return "erro";
    }
    return "redirect:/filmes";
  }

  @GetMapping(value = "/filmes/{id}/edit")
  public ModelAndView update(@PathVariable Integer id){
    try {
      Optional<Filme> clientOpt = filmeRepository.findById(id);
      if(clientOpt.isPresent()) {
        ModelAndView mv = new ModelAndView("filme-edit");
        Filme filme = clientOpt.get();
        mv.addObject("fil", filme);
        return mv;
      }
      else {
        ModelAndView erro = new ModelAndView("erro");
        erro.addObject("msg", "Filme não encontrado.");
        return erro;
      }
    } catch(Exception ex) {
      ModelAndView erro = new ModelAndView("erro");
      erro.addObject("msg", "Erro interno no servidor.");
      return erro;
    }
  }

  @PostMapping(value = "/filmes/edit")
  public String edit(Filme filme) {
    try {
      Optional<Filme> clientOpt = filmeRepository.findById(filme.getId());
      if(clientOpt.isPresent()) {
        filmeRepository.save(filme);
      }
    } catch(Exception ex) {
      return "erro";
    }
    return "redirect:/filmes";
  }
}
