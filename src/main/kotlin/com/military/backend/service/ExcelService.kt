package com.military.backend.service

import com.military.backend.component.ExcelHandler
import com.military.backend.domain.dto.IdDTO
import com.military.backend.domain.dto.MilitaryBaseExcelDTO
import com.military.backend.domain.dto.ObjectInformExcelDTO
import com.military.backend.exceptions.ExcelDTOException
import com.military.backend.repository.ObjectInformatizationRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.io.File
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

@Service
class ExcelService {

    @Autowired
    private val excelHandler: ExcelHandler? = null

    @Autowired
    private val objectInformatizationRepository: ObjectInformatizationRepository? = null

    private val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")

    /**
     * Creates excel [File] with info about all informatization objects from
     * all military bases.
     */
    fun generateFullExcel(): Pair<String, ByteArray> {
        val informObjects = objectInformatizationRepository!!.findAll()
        val excelFile = excelHandler!!.generateExcel(
            informObjects = informObjects,
            addMilitaryBaseSection = true,
            addInformObjectSection = true
        )
        return toNamedBytes("Все объекты информатизации", excelFile)
    }

    /**
     * Creates excel [File] with info about all informatization objects for
     * military base by [IdDTO.id].
     */
    fun generateMilitaryBaseExcel(idDTO: IdDTO): Pair<String, ByteArray> {
        val informObjects = objectInformatizationRepository!!.findAllByMilitaryBaseId(idDTO.id.toInt())
        val excelFile = excelHandler!!.generateExcel(
            informObjects = informObjects,
            addMilitaryBaseSection = false,
            addInformObjectSection = true
        )
        val militaryBaseNumber = informObjects.first().militaryBase?.baseNumber ?: "00000"
        return toNamedBytes("Объекты информатизации военной части №$militaryBaseNumber", excelFile)
    }

    /**
     * Creates excel [File] with info about informatization object
     * by [IdDTO.id].
     */
    fun generateObjInformExcel(idDTO: IdDTO): Pair<String, ByteArray> {
        val informObject = objectInformatizationRepository!!.findById(idDTO.id.toInt()).get()
        val excelFile = excelHandler!!.generateExcel(
            informObjects = setOf(informObject),
            addMilitaryBaseSection = false,
            addInformObjectSection = false
        )
        val informObjectName = informObject.name
        val militaryBaseNumber = informObject.militaryBase?.baseNumber ?: "00000"
        return toNamedBytes(
            "Объект информатизации $informObjectName военной части №$militaryBaseNumber",
            excelFile
        )
    }

    private fun toNamedBytes(name: String?, file: File): Pair<String, ByteArray> {
        val creationDateTime = LocalDateTime.now().format(formatter)
        val fileName = "$creationDateTime - ${name?.fileNameCorrection()}.xlsx"
        val bytes = file.readBytes()
        file.delete()
        return fileName to bytes
    }

    private fun String.fileNameCorrection(): String {
        return this.replace("[\\\\/:\"*?<>|]+".toRegex(), "_")
    }
}