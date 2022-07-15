package com.military.backend.service

import com.military.backend.domain.InnerDocumentModel

interface InnerDocumentService {
    fun add(document: InnerDocumentModel): InnerDocumentModel
    fun edit(document: InnerDocumentModel): InnerDocumentModel
    fun get(id: Int): InnerDocumentModel
    fun delete(document: InnerDocumentModel)
    fun deleteById(documentId: Int)
    fun getAllByInformatizationObjectId(iOId: Int?): Set<InnerDocumentModel>
    fun getAll(): Set<InnerDocumentModel>
}
