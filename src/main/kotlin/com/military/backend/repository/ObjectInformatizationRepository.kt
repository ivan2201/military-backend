package com.military.backend.repository

import com.military.backend.domain.ObjectInformatizationModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ObjectInformatizationRepository : JpaRepository<ObjectInformatizationModel, Int> {

    fun findAllByMilitaryBaseId(militaryBaseId: Int?): Set<ObjectInformatizationModel>

    fun findAllByMilitaryBaseId(militaryBaseId: Int): Set<ObjectInformatizationModel>
}
