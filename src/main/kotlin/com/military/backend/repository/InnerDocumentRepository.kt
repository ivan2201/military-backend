package com.military.backend.repository

import com.military.backend.domain.InnerDocumentModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository


@Repository
interface InnerDocumentRepository : JpaRepository<InnerDocumentModel, Int>
{
    @Query("select * from inner_document i where i.oi_id = ?1", nativeQuery = true)
    fun findAllByInformatizationObjectId(informatizationObjectId: Int):
            MutableList<InnerDocumentModel>
}
