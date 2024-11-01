package com.gabriel.hamburgueria_groovy.controllers

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.http.HttpStatus
import jakarta.validation.Valid

import com.gabriel.hamburgueria_groovy.controllers.dto.AlimentoDto
import com.gabriel.hamburgueria_groovy.domain.Alimento
import com.gabriel.hamburgueria_groovy.services.AlimentoService

@RestController
@RequestMapping('/v1/alimento')
class AlimentoController {

  private final AlimentoService alimentoService

  AlimentoController(AlimentoService alimentoService) {
    this.alimentoService = alimentoService
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  Alimento salvar(@Valid @RequestBody AlimentoDto alimentoDto) {
    return alimentoService.salvar(alimentoDto)
  }

  @GetMapping
  List<Alimento> buscarTodos() {
    return alimentoService.buscarTodos()
  }

  @GetMapping('/{pesquisa}')
  Alimento buscarComFiltro(@PathVariable String pesquisa) {
    return alimentoService.buscarComFiltro(pesquisa)
  }

  @DeleteMapping('/{id}')
  @ResponseStatus(HttpStatus.NO_CONTENT)
  void deletar(@PathVariable Long id) {
    alimentoService.deletar(id)
  }

  @PutMapping('/{id}')
  Alimento atualizar(@PathVariable Long id, @RequestBody AlimentoDto alimentoDto) {
    return alimentoService.atualizar(id, alimentoDto)
  }

}
