package com.military.backend.repository

import com.military.backend.domain.ComponentModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ComponentRepository : JpaRepository<ComponentModel, Int>
{
    fun findAllByObjectInformatizationId(objectInformatizationId: Int):
            Set<ComponentModel>
}
