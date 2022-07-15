package com.military.backend.service.impl

import com.military.backend.domain.SpecialCheckResultModel
import com.military.backend.repository.SpecialCheckResultRepository
import com.military.backend.service.SpecialCheckResultService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class SpecialCheckResultServiceImpl: SpecialCheckResultService {
    @Autowired
    var specialCheckResultRepository: SpecialCheckResultRepository? = null

    override fun add(specCheckResult: SpecialCheckResultModel): SpecialCheckResultModel
    {
        if (specCheckResult.id == null || specCheckResult.id == -1)
            return specialCheckResultRepository!!.save(specCheckResult)
        else
            throw Exception("Bad value")
    }

    override fun edit(specCheckResult: SpecialCheckResultModel): SpecialCheckResultModel
    {
        if (specCheckResult.id != null && specCheckResult.id > 0)
            return specialCheckResultRepository!!.save(specCheckResult)
        else
            throw Exception("Bad value")
    }

    override fun get(id: Int): SpecialCheckResultModel
    {
        return specialCheckResultRepository!!.getOne(id)
    }

    override fun delete(specCheckResult: SpecialCheckResultModel)
    {
        specialCheckResultRepository!!.delete(specCheckResult)
    }

    override fun deleteById(specCheckResultId: Int) {
        specialCheckResultRepository!!.deleteById(specCheckResultId)
    }

    override fun getAll(): Set<SpecialCheckResultModel> {
        return specialCheckResultRepository!!.findAll().toSet()
    }
}
