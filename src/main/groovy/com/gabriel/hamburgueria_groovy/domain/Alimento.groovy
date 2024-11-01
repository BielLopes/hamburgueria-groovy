package com.gabriel.hamburgueria_groovy.domain

import groovy.transform.Immutable

@Immutable
class Alimento {

  Long id
  String nome
  BigDecimal preco
  String descricao
  String categoria

}
