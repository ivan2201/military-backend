package com.military.backend.service.impl

import com.military.backend.domain.SpecialCheckResultModel
import com.military.backend.domain.SpecialInvestigationModel
import com.military.backend.domain.dto.SpecialCheckResultDTO
import com.military.backend.repository.SpecialCheckResultRepository
import com.military.backend.service.SpecialCheckResultService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.sql.Date

@Service
class SpecialCheckResultServiceImpl: SpecialCheckResultService {

    @Autowired
    private val specialCheckResultRepository: SpecialCheckResultRepository? = null

    override fun addOrEdit(specCheckResult: SpecialCheckResultDTO) {
        val scrOptional = specialCheckResultRepository!!.findById(specCheckResult.id)
        val scrModel = if (scrOptional.isEmpty) {
            SpecialCheckResultModel(
                specialCheckResultNumber = specCheckResult.numberDoc,
                approveDate = Date.valueOf(specCheckResult.dateCheck),
            )
        } else {
            val oldScr = scrOptional.get()
            SpecialCheckResultModel(
                id = oldScr.id,
                specialCheckResultNumber = specCheckResult.numberDoc ?: oldScr.specialCheckResultNumber,
                approveDate = Date.valueOf(specCheckResult.dateCheck) ?: oldScr.approveDate,
            )
        }
        specialCheckResultRepository.save(scrModel)
    }

    override fun get(id: Int): SpecialCheckResultModel
    {
        return specialCheckResultRepository!!.getOne(id)
    }

    override fun deleteById(specCheckResultId: Int) {
        specialCheckResultRepository!!.deleteById(specCheckResultId)
    }

    override fun getAll(): Set<SpecialCheckResultModel> {
        return specialCheckResultRepository!!.findAll().toSet()
    }
}
