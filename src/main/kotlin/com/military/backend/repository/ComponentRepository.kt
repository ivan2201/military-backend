package com.military.backend.repository

import com.military.backend.domain.ComponentModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface ComponentRepository : JpaRepository<ComponentModel, Int>
{
    @Query("select * from components c where c.oi_id = ?1", nativeQuery = true)
    fun findAllByInformatizationObjectId( informatizationObjectId: Int):
            MutableList<ComponentModel>
}
