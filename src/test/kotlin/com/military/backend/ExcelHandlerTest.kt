package com.military.backend

import com.military.backend.component.ExcelHandler
import com.military.backend.repository.MilitaryBaseRepository
import com.military.backend.repository.ObjectInformatizationRepository
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ExcelHandlerTest {

    @Autowired
    private val excelHandler: ExcelHandler? = null

    @Autowired
    private val militaryBaseRepository: MilitaryBaseRepository? = null

    @Autowired
    private val objectInformatizationRepository: ObjectInformatizationRepository? = null

    @Test
    fun `Export all military base infos test`() {
        requireNotNull(excelHandler)
        excelHandler.generateFullExcel()
    }

    @Test
    fun `Export military base info test`() {
        requireNotNull(excelHandler)
        val militaryBase = militaryBaseRepository!!.findAll().random()
        excelHandler.generateMilitaryBaseExcel(militaryBase)
    }

    @Test
    fun `Export object inform info test`() {
        requireNotNull(excelHandler)
        val objectInformatization = objectInformatizationRepository!!.findAll().random()
        excelHandler.generateObjInfromExcel(objectInformatization)
    }
}