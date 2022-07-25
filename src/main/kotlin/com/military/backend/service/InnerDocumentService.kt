package com.military.backend.service

import com.military.backend.domain.dto.DocumentDTO

interface InnerDocumentService {
    fun add(document: DocumentDTO): DocumentDTO
    fun edit(document: DocumentDTO): DocumentDTO
    fun get(id: Int): DocumentDTO
    fun deleteById(documentId: Int)
    fun getAllByInformatizationObjectId(iOId: Int?): Set<DocumentDTO>
    fun getAll(): Set<DocumentDTO>
}
