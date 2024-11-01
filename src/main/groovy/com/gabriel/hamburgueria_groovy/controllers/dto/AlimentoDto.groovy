package com.gabriel.hamburgueria_groovy.controllers.dto

import groovy.transform.Canonical
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import jakarta.validation.constraints.Min
import com.gabriel.hamburgueria_groovy.domain.Alimento

@Canonical
class AlimentoDto {

  @NotBlank(message = 'Nome é obrigatório')
  @Size(min = 3, max = 20, message = 'Nome deve ter entre 3 e 20 caracteres')
  String nome

  @NotNull(message = 'Preço é obrigatório')
  @Min(value = 0L, message = 'Preço deve ser maior que 0')
  BigDecimal preco

  String descricao

  @NotBlank(message = 'Categoria é obrigatório')
  @Size(max = 20, message = 'Categoria deve ter no máximo 20 caracteres')
  String categoria

  Alimento toDomain() {
    return new Alimento(
            null,
            nome,
            preco,
            descricao,
            categoria
        )
  }

}
