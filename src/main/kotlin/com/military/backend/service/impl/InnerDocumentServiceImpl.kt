package com.military.backend.service.impl

import com.military.backend.domain.InnerDocumentModel
import com.military.backend.domain.dto.DocumentDTO
import com.military.backend.repository.InnerDocumentRepository
import com.military.backend.service.InnerDocumentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class InnerDocumentServiceImpl: InnerDocumentService {
    @Autowired
    var innerDocumentRepository: InnerDocumentRepository? = null

    override fun add(document: DocumentDTO): DocumentDTO
    {
        if (document.id == -1)
            return DocumentDTO(innerDocumentRepository!!.save(InnerDocumentModel(document)))
        else
            throw Exception("Bad value")
    }

    override fun edit(document: DocumentDTO): DocumentDTO
    {
        if (document.id > 0)
            return DocumentDTO(innerDocumentRepository!!.save(InnerDocumentModel(document)))
        else
            throw Exception("Bad value")
    }

    override fun get(id: Int): DocumentDTO
    {
        return DocumentDTO(innerDocumentRepository!!.getOne(id))
    }

    override fun deleteById(documentId: Int) {
        innerDocumentRepository!!.deleteById(documentId)
    }

    override fun getAllByInformatizationObjectId(iOId: Int?): Set<DocumentDTO> {
        iOId?.let {
            return DocumentDTO.fromInnerDocumentModelSet(
                innerDocumentRepository!!.findAllByObjectInformatizationId(iOId)
            )
        }
        return getAll()
    }

    override fun getAll(): Set<DocumentDTO> {
        return DocumentDTO.fromInnerDocumentModelSet(innerDocumentRepository!!.findAll().toSet())
    }
}
