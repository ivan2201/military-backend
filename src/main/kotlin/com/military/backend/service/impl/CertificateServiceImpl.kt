package com.military.backend.service.impl

import com.military.backend.domain.CategoryModel
import com.military.backend.domain.CertificateModel
import com.military.backend.domain.dto.CertificateDTO
import com.military.backend.domain.dto.IdDTO
import com.military.backend.repository.CategoryRepository
import com.military.backend.repository.CertificateRepository
import com.military.backend.service.CertificateService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.sql.Date
import java.time.format.DateTimeFormatter
import java.util.*

@Service
class CertificateServiceImpl : CertificateService {

    @Autowired
    private val certificateRepository: CertificateRepository? = null

    @Autowired
    private val categoryRepository: CategoryRepository? = null

    override fun addOrEdit(certificateDTO: CertificateDTO) {
        val certOptional = certificateRepository!!.findById(certificateDTO.id)
        val categoryOptional = categoryRepository!!.findByCategoryName(certificateDTO.category ?: "")
        val certModel = if (certOptional.isEmpty) {
            CertificateModel(
                category = if (categoryOptional.isEmpty) null else categoryOptional.get(),
                certNumber = certificateDTO.numberCert,
                approveDate = Date.valueOf(certificateDTO.dateCreateCert),
                recertDate = Date.valueOf(certificateDTO.dateFinishCert),
                certCreator = certificateDTO.owner,
            )
        } else {
            val oldCert = certOptional.get()
            CertificateModel(
                id = oldCert.id,
                category = if (categoryOptional.isEmpty) null else oldCert.category,
                certNumber = certificateDTO.numberCert ?: oldCert.certNumber,
                approveDate = Date.valueOf(certificateDTO.dateCreateCert) ?: oldCert.approveDate,
                recertDate = Date.valueOf(certificateDTO.dateFinishCert) ?: oldCert.recertDate,
                certCreator = certificateDTO.owner ?: oldCert.certCreator,
            )
        }
        certificateRepository.save(certModel)
    }

    override fun get(idDTO: IdDTO): CertificateModel {
        return certificateRepository!!.getOne(idDTO.id.toInt())
    }

    override fun deleteById(certificateId: Int) {
        certificateRepository!!.deleteById(certificateId)
    }

    override fun getAll(): Set<CertificateModel> {
        return certificateRepository!!.findAll().toSet()
    }
}
