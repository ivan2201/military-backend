package com.military.backend.repository

import com.military.backend.domain.ObjectInformatizationModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface ObjectInformatizationRepository : JpaRepository<ObjectInformatizationModel, Int>
{
    @Query("SELECT * FROM object_informatization o WHERE o.military_base_id = ?1", nativeQuery = true)
    fun findAllByMilitaryBaseId(MilitaryBaseId: Int):
            MutableList<ObjectInformatizationModel>
}