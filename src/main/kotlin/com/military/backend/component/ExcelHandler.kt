package com.military.backend.component

import com.military.backend.domain.MilitaryBaseModel
import com.military.backend.domain.ObjectInformatizationModel
import com.military.backend.repository.ObjectInformatizationRepository
import org.apache.poi.ss.usermodel.*
import org.apache.poi.ss.util.CellRangeAddress
import org.apache.poi.xssf.usermodel.XSSFCell
import org.apache.poi.xssf.usermodel.XSSFRow
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.io.File
import java.io.FileOutputStream
import kotlin.math.max


@Component
class ExcelHandler {

    @Autowired
    private val objectInformatizationRepository: ObjectInformatizationRepository? = null

    // headers
    private final val militaryBaseHeader = "Подразделение или в/ч"
    private final val informObjectHeader = "Объект информатизации"
    private final val certHeader = "Сертификат соответствия"
    private final val siHeader = "Акт о спец исследовании"
    private final val scrHeader = "Заключение по результатам спец проверки"
    private final val componentsHeader = "Комплектующие"
    private final val innerDocsHeader = "Внутренние документы"

    private val subheaderMap = mapOf(
        militaryBaseHeader to arrayOf("Наименование", "Номер", "Месторасположение"),
        informObjectHeader to arrayOf("Наименование"),
        certHeader to arrayOf("Номер", "Дата принятия", "Дата переаттестации", "Категория", "Выдал"),
        siHeader to arrayOf("Номер", "Дата согласования"),
        scrHeader to arrayOf("Номер", "Дата согласования"),
        componentsHeader to arrayOf("Наименование", "Серийный номер"),
        innerDocsHeader to arrayOf("Наименование", "Учетный номер", "Дата согласования"),
    )

    private val columnWidthMap = mapOf(
        militaryBaseHeader to arrayOf(50 * 256, 8 * 256, 40 * 256),
        informObjectHeader to arrayOf(30 * 256),
        certHeader to arrayOf(15 * 256, 15 * 256, 15 * 256, 20 * 256, 40 * 256),
        siHeader to arrayOf(15 * 256, 15 * 256),
        scrHeader to arrayOf(15 * 256, 15 * 256),
        componentsHeader to arrayOf(30 * 256, 20 * 256),
        innerDocsHeader to arrayOf(30 * 256, 20 * 256, 15 * 256),
    )

    /**
     * Creates excel [File] with info about all informatization objects from all military bases.
     */
    fun generateFullExcel(): File {
        val mappedObjects = objectInformatizationRepository!!.findAll()
            .sortedWith(compareBy({ it.militaryBase?.name }, { it.name }))
            .groupBy { it.militaryBase }
        val headers = listOf(
            militaryBaseHeader,
            informObjectHeader,
            certHeader,
            siHeader,
            scrHeader,
            componentsHeader,
            innerDocsHeader
        )

        val wb = generateExcelWorkBook(mappedObjects, headers)
        return writeExcel(wb, "Все объекты информатизации")
    }

    /**
     * Creates excel [File] with info about all informatization objects for specified [militaryBase].
     */
    fun generateMilitaryBaseExcel(militaryBase: MilitaryBaseModel): File {
        val mappedObjects = mapOf(
            militaryBase as MilitaryBaseModel? to
                    objectInformatizationRepository!!.findAllByMilitaryBase(militaryBase).sortedBy { it.name }
        )
        val headers = listOf(
            informObjectHeader,
            certHeader,
            siHeader,
            scrHeader,
            componentsHeader,
            innerDocsHeader
        )

        val wb = generateExcelWorkBook(mappedObjects, headers)
        return writeExcel(wb, "Объекты информатизации военной части ${militaryBase.baseNumber}")
    }

    /**
     * Creates excel [File] with info about specified [informatizationObject].
     */
    fun generateObjInfromExcel(informatizationObject: ObjectInformatizationModel): File {
        val mappedObjects = mapOf(informatizationObject.militaryBase to listOf(informatizationObject))
        val headers = listOf(
            certHeader,
            siHeader,
            scrHeader,
            componentsHeader,
            innerDocsHeader
        )

        val wb = generateExcelWorkBook(mappedObjects, headers)
        return writeExcel(
            wb,
            "Объект информатизации ${informatizationObject.name} " +
                    "военной части ${informatizationObject.militaryBase?.baseNumber}"
        )
    }

    private fun generateExcelWorkBook(
        mappedObjects: Map<MilitaryBaseModel?, Iterable<ObjectInformatizationModel>>,
        headers: Iterable<String>
    ): Workbook {
        val wb = XSSFWorkbook()

        val styles = createStyles(wb)

        val sheet = wb.createSheet(
            when {
                headers.contains(militaryBaseHeader) ->
                    "Все военные части"
                headers.contains(militaryBaseHeader) ->
                    "Военная часть №${mappedObjects.toList().first().first?.baseNumber ?: "00000"}"
                else ->
                    "Объект информатизации \"${mappedObjects.toList().first().second.first().name}\""
            }
        )

        // sheet settings
        sheet.horizontallyCenter = true
        sheet.printSetup.landscape = true

        var i = 0
        var cell: XSSFCell
        var row: XSSFRow
        var style: CellStyle

        val totalSubheaders = headers.sumOf { max(1, subheaderMap[it]!!.size) }
        val leftBorders = mutableListOf<Int>()
        val rightBorders = mutableListOf<Int>()
        val firstHeaderRow = sheet.createRow(0)
        val secondHeaderRow = sheet.createRow(1)
        firstHeaderRow.heightInPoints = 60f
        secondHeaderRow.heightInPoints = 40f
        for (header in headers) {

            val subheaders = subheaderMap[header]!!
            val columnWidth = columnWidthMap[header]!!
            val headerCellCount = max(1, subheaders.size)

            leftBorders.add(i)
            rightBorders.add(i + headerCellCount - 1)

            var j = i
            do {
                val firstRowCell = firstHeaderRow.createCell(j)
                val secondRowCell = secondHeaderRow.createCell(j)
                val firstRowBorders = BorderSides(top = 3, bottom = 1)
                val secondRowBorders = BorderSides(top = 1, bottom = 3)
                if (j == i) {
                    firstRowCell.setCellValue(header)
                    if (j == 0) {
                        firstRowBorders.left = 3
                        secondRowBorders.left = 3
                    } else {
                        firstRowBorders.left = 2
                        secondRowBorders.left = 2
                    }
                }
                if (j == i + headerCellCount - 1) {
                    if (j == totalSubheaders - 1) {
                        firstRowBorders.right = 3
                        secondRowBorders.right = 3
                    } else {
                        firstRowBorders.right = 2
                        secondRowBorders.right = 2
                    }
                }

                firstRowCell.setCellStyle(withBorder(wb, styles["header"]!!, firstRowBorders))
                secondRowCell.setCellValue(if (j - i >= headerCellCount) "" else subheaders[j - i])
                secondRowCell.setCellStyle(withBorder(wb, styles["subheader"]!!, secondRowBorders))
                sheet.setColumnWidth(j, columnWidth[j - i])
            } while (++j - i < headerCellCount)

            if (headerCellCount > 1) {
                sheet.addMergedRegion(CellRangeAddress(0, 0, i, i + headerCellCount - 1))
            }

            i += headerCellCount
        }

        // freeze the first row
        sheet.createFreezePane(0, 2)

        // filling with data
        i = 2
        val writeMilitaryBaseSection = headers.contains(militaryBaseHeader)
        val writeInformObjectSection = headers.contains(informObjectHeader)
        mappedObjects.forEach { (base, objectSet) ->
            var printMilitaryBase = true
            var normalStyle = withBorder(wb, styles["normal"]!!, BorderSides(top = 2))
            var normalCenterStyle = withBorder(wb, styles["normal_center"]!!, BorderSides(top = 2))
            var dateStyle = withBorder(wb, styles["date"]!!, BorderSides(top = 2))

            for (objectInform in objectSet) {
                row = sheet.createRow(i)
                var cellIndex = 0

                // military base info
                if (writeMilitaryBaseSection) {
                    cell = row.createCell(cellIndex++)
                    cell.setCellStyle(normalStyle)

                    cell = row.createCell(cellIndex++)
                    cell.setCellStyle(normalStyle)

                    cell = row.createCell(cellIndex++)
                    cell.setCellStyle(normalStyle)

                    if (printMilitaryBase) {
                        printMilitaryBase = false

                        row.getCell(cellIndex - 3).setCellValue(base?.name ?: "")
                        row.getCell(cellIndex - 2).setCellValue(base?.baseNumber ?: "")
                        row.getCell(cellIndex - 1).setCellValue(base?.location ?: "")
                    }
                }

                // informatization object info
                if (writeInformObjectSection) {
                    cell = row.createCell(cellIndex++)
                    cell.setCellStyle(normalStyle)
                    cell.setCellValue(objectInform.name ?: "")
                }

                // certificate info
                cell = row.createCell(cellIndex++)
                cell.setCellStyle(normalStyle)
                cell.setCellValue(objectInform.cert?.certNumber?.toString() ?: "")

                cell = row.createCell(cellIndex++)
                cell.setCellStyle(dateStyle)
                cell.setCellValue(objectInform.cert?.approveDate)

                cell = row.createCell(cellIndex++)
                cell.setCellStyle(dateStyle)
                cell.setCellValue(objectInform.cert?.recertDate)

                cell = row.createCell(cellIndex++)
                cell.setCellStyle(normalStyle)
                cell.setCellValue(objectInform.cert?.category?.categoryName ?: "")

                cell = row.createCell(cellIndex++)
                cell.setCellStyle(normalStyle)
                cell.setCellValue(objectInform.cert?.certCreator ?: "")

                // special investigation info
                cell = row.createCell(cellIndex++)
                cell.setCellStyle(normalStyle)
                cell.setCellValue(objectInform.specialInvestigation?.specialInvestigationNumber ?: "")

                cell = row.createCell(cellIndex++)
                cell.setCellStyle(dateStyle)
                cell.setCellValue(objectInform.specialInvestigation?.approveDate)

                // special check result info
                cell = row.createCell(cellIndex++)
                cell.setCellStyle(normalStyle)
                cell.setCellValue(objectInform.specialCheckResult?.specialCheckResultNumber ?: "")

                cell = row.createCell(cellIndex++)
                cell.setCellStyle(dateStyle)
                cell.setCellValue(objectInform.specialCheckResult?.approveDate)

                // components general info
                val components = objectInform.components?.toList()?.sortedBy { it.name } ?: emptyList()
                cell = row.createCell(cellIndex++)
                cell.setCellStyle(normalCenterStyle)
                cell.setCellValue("Всего комплектующих: ${components.size}")

                cell = row.createCell(cellIndex++)
                cell.setCellStyle(normalStyle)

                sheet.addMergedRegion(CellRangeAddress(i, i, cellIndex - 2, cellIndex - 1))

                // inner docs general info
                val innerDocuments = objectInform.innerDocuments?.toList()?.sortedBy { it.name } ?: emptyList()
                cell = row.createCell(cellIndex++)
                cell.setCellStyle(normalCenterStyle)
                cell.setCellValue("Всего документов: ${innerDocuments.size}")

                cell = row.createCell(cellIndex++)
                cell.setCellStyle(normalStyle)

                cell = row.createCell(cellIndex)
                cell.setCellStyle(normalStyle)

                sheet.addMergedRegion(CellRangeAddress(i, i, cellIndex - 2, cellIndex))

                val additionalRowCount = max(innerDocuments.size, components.size)
                var j = 0
                while (j < additionalRowCount) {
                    val component = components.getOrNull(j)
                    val innerDocument = innerDocuments.getOrNull(j)
                    normalStyle = withBorder(wb, styles["normal"]!!)
                    normalCenterStyle = withBorder(wb, styles["normal_center"]!!)
                    dateStyle = withBorder(wb, styles["date"]!!)
                    row = sheet.createRow(++j + i)

                    // component info
                    cell = row.createCell(cellIndex - 4)
                    cell.setCellStyle(normalStyle)
                    cell.setCellValue(component?.name ?: "")

                    cell = row.createCell(cellIndex - 3)
                    cell.setCellStyle(normalStyle)
                    cell.setCellValue(component?.seriesNumber ?: "")

                    // inner document info
                    cell = row.createCell(cellIndex - 2)
                    cell.setCellStyle(normalStyle)
                    cell.setCellValue(innerDocument?.name ?: "")

                    cell = row.createCell(cellIndex - 1)
                    cell.setCellStyle(normalStyle)
                    cell.setCellValue(innerDocument?.registrationNumber ?: "")

                    cell = row.createCell(cellIndex)
                    cell.setCellStyle(dateStyle)
                    cell.setCellValue(innerDocument?.approveDate)
                }

                for (k in 0..17) {
                    cell = row.getCell(k, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)
                    style = withBorder(wb, cell.cellStyle, BorderSides(bottom = 2))
                    cell.setCellStyle(style)
                }

                i += j + 1
            }
        }

        // bordering table
        row = sheet.getRow(i - 1)

        for (k in 0 until totalSubheaders) {
            cell = row.getCell(k, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)
            style = withBorder(wb, cell.cellStyle, BorderSides(bottom = 3))
            cell.setCellStyle(style)
        }

        for (r in 2 until i) {
            row = sheet.getRow(r)

            for (c in leftBorders) {
                val borderThickness = if (c == 0) 3 else 2
                cell = row.getCell(c, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)
                cell.setCellStyle(withBorder(wb, cell.cellStyle, BorderSides(left = borderThickness)))
            }

            for (c in rightBorders) {
                val borderThickness = if (c == totalSubheaders - 1) 3 else 2
                cell = row.getCell(c, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)
                cell.setCellStyle(withBorder(wb, cell.cellStyle, BorderSides(right = borderThickness)))
            }
        }

        return wb
    }

    private fun writeExcel(wb: Workbook, fileName: String): File {
        val excelFileName = "$fileName.xlsx"
        FileOutputStream(excelFileName).use {
            wb.write(it)
        }
        return File(excelFileName)
    }

    private fun createStyles(wb: Workbook): Map<String, CellStyle> {
        val styles = mutableMapOf<String, CellStyle>()

        val df = wb.createDataFormat()

        var style = wb.createCellStyle()
        style.alignment = HorizontalAlignment.LEFT
        style.wrapText = true
        styles["normal"] = style

        style = wb.createCellStyle()
        style.alignment = HorizontalAlignment.CENTER
        style.wrapText = true
        styles["normal_center"] = style

        style = wb.createCellStyle()
        style.alignment = HorizontalAlignment.CENTER
        style.dataFormat = df.getFormat("dd-mm-yyyy")
        styles["date"] = style

        val headerFont = wb.createFont()
        headerFont.bold = true
        headerFont.fontHeightInPoints = 14.toShort()
        style = wb.createCellStyle()
        style.alignment = HorizontalAlignment.CENTER
        style.verticalAlignment = VerticalAlignment.CENTER
        style.wrapText = true
        style.fillForegroundColor = IndexedColors.LIGHT_GREEN.getIndex()
        style.fillPattern = FillPatternType.SOLID_FOREGROUND
        style.setFont(headerFont)
        styles["header"] = style

        val subheaderFont = wb.createFont()
        subheaderFont.bold = true
        style = wb.createCellStyle()
        style.alignment = HorizontalAlignment.CENTER
        style.verticalAlignment = VerticalAlignment.CENTER
        style.wrapText = true
        style.fillForegroundColor = IndexedColors.LIGHT_GREEN.getIndex()
        style.fillPattern = FillPatternType.SOLID_FOREGROUND
        style.setFont(subheaderFont)
        styles["subheader"] = style

        return styles
    }

    private fun withBorder(wb: Workbook, style: CellStyle, borderSides: BorderSides = BorderSides()): CellStyle {
        val borderedStyle = wb.createCellStyle().apply {
            cloneStyleFrom(style)
        }

        getBorderParams(borderSides.top).also {
            borderedStyle.borderTop = it.first ?: borderedStyle.borderTop
            borderedStyle.topBorderColor = it.second
        }

        getBorderParams(borderSides.bottom).also {
            borderedStyle.borderBottom = it.first ?: borderedStyle.borderTop
            borderedStyle.bottomBorderColor = it.second
        }

        getBorderParams(borderSides.left).also {
            borderedStyle.borderLeft = it.first ?: borderedStyle.borderTop
            borderedStyle.leftBorderColor = it.second
        }
        getBorderParams(borderSides.right).also {
            borderedStyle.borderRight = it.first ?: borderedStyle.borderTop
            borderedStyle.rightBorderColor = it.second
        }

        return borderedStyle
    }

    private fun getBorderParams(borderType: Int): Pair<BorderStyle?, Short> = when (borderType) {
        1 -> BorderStyle.THIN to IndexedColors.GREY_50_PERCENT.index
        2 -> BorderStyle.THIN to IndexedColors.GREY_80_PERCENT.index
        3 -> BorderStyle.THICK to IndexedColors.GREY_80_PERCENT.index
        else -> null to IndexedColors.BLACK.index
    }

    private data class BorderSides(
        var top: Int = 0,
        var bottom: Int = 0,
        var left: Int = 0,
        var right: Int = 0
    )
}
