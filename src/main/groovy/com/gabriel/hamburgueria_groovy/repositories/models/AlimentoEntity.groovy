package com.gabriel.hamburgueria_groovy.repositories.models

import groovy.transform.Canonical
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType

import com.gabriel.hamburgueria_groovy.domain.Alimento

@Canonical
@Entity(name = 'alimento')
class AlimentoEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id
  String nome
  BigDecimal preco
  String descricao
  String categoria

  static AlimentoEntity toEntity(Alimento alimento) {
    return new AlimentoEntity(
            id: alimento.id,
            nome: alimento.nome,
            preco: alimento.preco,
            descricao: alimento.descricao,
            categoria: alimento.categoria
        )
  }

  Alimento toDomain() {
    return new Alimento(
            id,
            nome,
            preco,
            descricao,
            categoria
        )
  }

}

