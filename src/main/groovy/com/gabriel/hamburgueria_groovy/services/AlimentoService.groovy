package com.gabriel.hamburgueria_groovy.services

import org.springframework.stereotype.Service

import com.gabriel.hamburgueria_groovy.domain.Alimento
import com.gabriel.hamburgueria_groovy.controllers.dto.AlimentoDto
import com.gabriel.hamburgueria_groovy.repositories.AlimentoRepository
import com.gabriel.hamburgueria_groovy.repositories.models.AlimentoEntity

@Service
class AlimentoService {

  private final AlimentoRepository alimentoRepository

  AlimentoService(AlimentoRepository alimentoRepository) {
    this.alimentoRepository = alimentoRepository
  }

  Alimento salvar(AlimentoDto alimentoDto) {
    Alimento alimento = alimentoDto.toDomain()
    return alimentoRepository.save(AlimentoEntity.toEntity(alimento)).toDomain()
  }

  List<Alimento> buscarTodos() {
    return alimentoRepository.findAll().collect { it.toDomain() }
  }

  Alimento buscarComFiltro(String pesquisa) {
    Long id = pesquisa.toLong() as Long

    AlimentoEntity alimentoEntity
    if (id == null) {
      alimentoEntity = alimentoRepository.findByNome(pesquisa)
        } else {
      alimentoEntity = alimentoRepository.findById(id)
                    .orElseThrow { new RuntimeException('Alimento not found') }
    }
    return alimentoEntity.toDomain()
  }

  void deletar(Long id) {
    alimentoRepository.deleteById(id)
  }

  Alimento atualizar(Long id, AlimentoDto alimentoDto) {
    Alimento alimento = alimentoDto.toDomain()
    alimento.id = id
    return alimentoRepository.save(AlimentoEntity.toEntity(alimento)).toDomain()
  }

}
