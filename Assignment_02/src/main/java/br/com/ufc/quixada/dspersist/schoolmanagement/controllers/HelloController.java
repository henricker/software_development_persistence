package br.com.ufc.quixada.dspersist.schoolmanagement.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HelloController {
  @GetMapping("hello")
  public String hello() {
    return "hello";
  }

  @PostMapping("/pega-dados-formulario")
  public String saveGay() {
    return "hello";
  }
}
