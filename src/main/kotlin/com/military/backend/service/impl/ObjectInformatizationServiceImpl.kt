package com.military.backend.service.impl

import com.military.backend.domain.ObjectInformatizationModel
import com.military.backend.domain.dto.ObjectInformatizationDTO
import com.military.backend.repository.ObjectInformatizationRepository
import com.military.backend.service.ObjectInformatizationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ObjectInformatizationServiceImpl: ObjectInformatizationService {
    @Autowired
    var objectInformatizationRepository: ObjectInformatizationRepository? = null

    override fun add(informatizationObject: ObjectInformatizationDTO): ObjectInformatizationDTO
    {
        if (informatizationObject.id == -1)
            return ObjectInformatizationDTO(objectInformatizationRepository!!.save(
                ObjectInformatizationModel(informatizationObject)))
        else
            throw Exception("Bad value")
    }

    override fun edit(informatizationObject: ObjectInformatizationDTO): ObjectInformatizationDTO
    {
        if (informatizationObject.id > 0)
            return ObjectInformatizationDTO(objectInformatizationRepository!!.save(
                ObjectInformatizationModel(informatizationObject)))
        else
            throw Exception("Bad value")
    }

    override fun get(id: Int): ObjectInformatizationDTO
    {
        return ObjectInformatizationDTO(objectInformatizationRepository!!.getOne(id))
    }


    override fun deleteById(informatizationObjectId: Int) {
        objectInformatizationRepository!!.deleteById(informatizationObjectId)
    }

    override fun getAllByMilitaryBaseId(militaryBaseId: Int?): Set<ObjectInformatizationDTO> {
        militaryBaseId?.let {
            return ObjectInformatizationDTO.fromObjectInformatizationModelSet(
                    objectInformatizationRepository!!.findAllByMilitaryBaseId(militaryBaseId)
            )
        }
        return getAll()
    }

    override fun getAll(): Set<ObjectInformatizationDTO> {
        return ObjectInformatizationDTO.fromObjectInformatizationModelSet(
                objectInformatizationRepository!!.findAll().toSet()
        )
    }
}
