package com.military.backend.service.impl

import com.military.backend.domain.MilitaryBaseModel
import com.military.backend.repository.MilitaryBaseRepository
import com.military.backend.service.MilitaryBaseService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class MilitaryBaseServiceImpl: MilitaryBaseService {
    @Autowired
    var militaryBaseRepository: MilitaryBaseRepository? = null

    override fun add(militaryBase: MilitaryBaseModel): MilitaryBaseModel
    {
        if (militaryBase.id == null || militaryBase.id == -1)
            return militaryBaseRepository!!.save(militaryBase)
        else
            throw Exception("Bad value")
    }

    override fun edit(militaryBase: MilitaryBaseModel): MilitaryBaseModel
    {
        if (militaryBase.id != null && militaryBase.id > 0)
            return militaryBaseRepository!!.save(militaryBase)
        else
            throw Exception("Bad value")
    }

    override fun get(id: Int): MilitaryBaseModel
    {
        return militaryBaseRepository!!.getOne(id)
    }

    override fun delete(militaryBase: MilitaryBaseModel)
    {
        militaryBaseRepository!!.delete(militaryBase)
    }

    override fun deleteById(militaryBaseId: Int)
    {
        militaryBaseRepository!!.deleteById(militaryBaseId)
    }

    override fun getAll(): Set<MilitaryBaseModel>
    {
        return militaryBaseRepository!!.findAll().toSet()
    }
}
