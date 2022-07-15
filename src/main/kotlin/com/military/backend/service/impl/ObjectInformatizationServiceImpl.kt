package com.military.backend.service.impl

import com.military.backend.domain.ObjectInformatizationModel
import com.military.backend.repository.ObjectInformatizationRepository
import com.military.backend.service.ObjectInformatizationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ObjectInformatizationServiceImpl: ObjectInformatizationService {
    @Autowired
    var objectInformatizationRepository: ObjectInformatizationRepository? = null

    override fun add(informatizationObject: ObjectInformatizationModel): ObjectInformatizationModel
    {
        if (informatizationObject.id == null || informatizationObject.id == -1)
            return objectInformatizationRepository!!.save(informatizationObject)
        else
            throw Exception("Bad value")
    }

    override fun edit(informatizationObject: ObjectInformatizationModel): ObjectInformatizationModel
    {
        if (informatizationObject.id != null && informatizationObject.id > 0)
            return objectInformatizationRepository!!.save(informatizationObject)
        else
            throw Exception("Bad value")
    }

    override fun get(id: Int): ObjectInformatizationModel
    {
        return objectInformatizationRepository!!.getOne(id)
    }

    override fun delete(informatizationObject: ObjectInformatizationModel)
    {
        objectInformatizationRepository!!.delete(informatizationObject)
    }

    override fun deleteById(informatizationObjectId: Int) {
        objectInformatizationRepository!!.deleteById(informatizationObjectId)
    }

    override fun getAllByMilitaryBaseId(militaryBaseId: Int?): Set<ObjectInformatizationModel> {
        militaryBaseId?.let {
            return objectInformatizationRepository!!.findAllByMilitaryBaseId(militaryBaseId)
        }
        return getAll()
    }

    override fun getAll(): Set<ObjectInformatizationModel> {
        return objectInformatizationRepository!!.findAll().toSet()
    }
}
