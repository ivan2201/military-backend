package com.military.backend.service.impl

import com.military.backend.domain.CertificateModel
import com.military.backend.domain.SpecialInvestigationModel
import com.military.backend.domain.dto.SpecialInvestigationDTO
import com.military.backend.repository.SpecialInvestigationRepository
import com.military.backend.service.SpecialInvestigationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.sql.Date
import javax.persistence.Column

@Service
class SpecialInvestigationServiceImpl : SpecialInvestigationService {

    @Autowired
    private val specialInvestigationRepository: SpecialInvestigationRepository? = null

    override fun addOrEdit(specInvestigation: SpecialInvestigationDTO) {
        val siOptional = specialInvestigationRepository!!.findById(specInvestigation.id)
        val siModel = if (siOptional.isEmpty) {
            SpecialInvestigationModel(
                specialInvestigationNumber = specInvestigation.numberDoc,
                approveDate = Date.valueOf(specInvestigation.dateCheck),
            )
        } else {
            val oldSi = siOptional.get()
            SpecialInvestigationModel(
                id = oldSi.id,
                specialInvestigationNumber = specInvestigation.numberDoc ?: oldSi.specialInvestigationNumber,
                approveDate = Date.valueOf(specInvestigation.dateCheck) ?: oldSi.approveDate,
            )
        }
        specialInvestigationRepository.save(siModel)
    }

    override fun get(id: Int): SpecialInvestigationModel {
        return specialInvestigationRepository!!.getOne(id)
    }

    override fun deleteById(specInvestigationId: Int) {
        specialInvestigationRepository!!.deleteById(specInvestigationId)
    }

    override fun getAll(): Set<SpecialInvestigationModel> {
        return specialInvestigationRepository!!.findAll().toSet()
    }
}
