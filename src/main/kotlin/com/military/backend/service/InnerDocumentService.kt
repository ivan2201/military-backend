package com.military.backend.service

import com.military.backend.domain.dto.DocumentDTO
import com.military.backend.domain.dto.EditDocumentDTO
import com.military.backend.domain.dto.NewDocumentDTO

interface InnerDocumentService {
    fun add(document: NewDocumentDTO): DocumentDTO
    fun edit(document: EditDocumentDTO): DocumentDTO
    fun get(id: Int): DocumentDTO
    fun deleteById(documentId: Int)
    fun getAllByInformatizationObjectId(iOId: Int?): Set<DocumentDTO>
    fun getAll(): Set<DocumentDTO>
}
