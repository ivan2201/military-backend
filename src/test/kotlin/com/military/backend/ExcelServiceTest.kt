package com.military.backend

import com.military.backend.component.ExcelHandler
import com.military.backend.domain.dto.MilitaryBaseExcelDTO
import com.military.backend.domain.dto.ObjectInformExcelDTO
import com.military.backend.repository.MilitaryBaseRepository
import com.military.backend.repository.ObjectInformatizationRepository
import com.military.backend.service.ExcelService
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ExcelServiceTest {

    @Autowired
    private val excelService: ExcelService? = null

    @Autowired
    private val militaryBaseRepository: MilitaryBaseRepository? = null

    @Autowired
    private val objectInformatizationRepository: ObjectInformatizationRepository? = null

    @Test
    fun `Export all military base infos test`() {
        requireNotNull(excelService)
        excelService.generateFullExcel()
    }

    @Test
    fun `Export military base info test`() {
        requireNotNull(excelService)
        val militaryBase = militaryBaseRepository!!.findAll().random()
        excelService.generateMilitaryBaseExcel(MilitaryBaseExcelDTO(militaryBase.id))
    }

    @Test
    fun `Export object inform info test`() {
        requireNotNull(excelService)
        val objectInformatization = objectInformatizationRepository!!.findAll().random()
        excelService.generateObjInformExcel(ObjectInformExcelDTO(objectInformatization.id))
    }
}