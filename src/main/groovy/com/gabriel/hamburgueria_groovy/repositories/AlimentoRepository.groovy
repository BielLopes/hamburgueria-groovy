package com.gabriel.hamburgueria_groovy.repositories

import org.springframework.data.jpa.repository.JpaRepository
import com.gabriel.hamburgueria_groovy.repositories.models.AlimentoEntity

interface AlimentoRepository extends JpaRepository<AlimentoEntity, Long> {

  AlimentoEntity findByNome(String nome)

}
