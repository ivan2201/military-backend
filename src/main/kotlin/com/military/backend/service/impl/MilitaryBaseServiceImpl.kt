package com.military.backend.service.impl

import com.military.backend.domain.MilitaryBaseModel
import com.military.backend.domain.dto.NewWarCampDTO
import com.military.backend.domain.dto.WarCampDTO
import com.military.backend.repository.MilitaryBaseRepository
import com.military.backend.service.MilitaryBaseService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class MilitaryBaseServiceImpl: MilitaryBaseService {
    @Autowired
    var militaryBaseRepository: MilitaryBaseRepository? = null

    override fun add(militaryBase: NewWarCampDTO): WarCampDTO
    {
        return WarCampDTO(militaryBaseRepository!!.save(MilitaryBaseModel(militaryBase)))
    }

    override fun edit(militaryBase: WarCampDTO): WarCampDTO
    {
        if (militaryBase.id > 0)
            return WarCampDTO(militaryBaseRepository!!.save(MilitaryBaseModel(militaryBase)))
        else
            throw Exception("Bad value")
    }

    override fun get(id: Int): WarCampDTO
    {
        return WarCampDTO(militaryBaseRepository!!.getOne(id))
    }

    override fun deleteById(militaryBaseId: Int)
    {
        militaryBaseRepository!!.deleteById(militaryBaseId)
    }

    override fun getAll(): Set<WarCampDTO>
    {
        return WarCampDTO.fromMilitaryBaseModelSet(militaryBaseRepository!!.findAll().toSet())
    }
}
