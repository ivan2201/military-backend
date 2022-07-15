package com.military.backend.repository

import com.military.backend.domain.InnerDocumentModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface InnerDocumentRepository : JpaRepository<InnerDocumentModel, Int>
{

    fun findAllByObjectInformatizationId(objectInformatizationId: Int):
            Set<InnerDocumentModel>
}
