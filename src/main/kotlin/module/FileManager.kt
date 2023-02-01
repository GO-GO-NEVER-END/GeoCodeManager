package module

import model.excelModel.ExcelRowData
import model.excelModel.toExcelRowData
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.FileReader
import java.io.FileWriter

class FileManager(fileName: String = "ggne_base_data") {

    private val geoCodeManager = GeocodeManager()

    private var baseFilePath = "baseData"
    private var updatedFilePath = "updatedData"

    private val BASE_FILE_PATH =
        System.getProperty("user.dir") + "/src/main/kotlin/$baseFilePath/$fileName.csv"
    private val UPDATED_FILE_PATH =
        System.getProperty("user.dir") + "/src/main/kotlin/$updatedFilePath/$fileName.csv"


    private val file = File(BASE_FILE_PATH)
    private val bufferedFileReader = BufferedReader(FileReader(file))
    private val fileWriter = FileWriter(UPDATED_FILE_PATH)
    private val bufferedFileWriter = BufferedWriter(fileWriter)

    fun processFile() {

        while (true) {

            val line = bufferedFileReader.readLine() ?: break
            val baseExcelData = line.split(",").map { it.trim() }.toExcelRowData()

            val processedData =
                if (hasLatitudeData(baseExcelData).not()) {

                    // 지오코드 변환
                    val geocode = geoCodeManager.convertToGeocode(baseExcelData.roadAddress.replace(";", ","))
                    // 위도 경도가 추가된 데이터
                    val newExcelData = baseExcelData.copy(longitude = geocode.longitude, latitude = geocode.latitude)

                    newExcelData
                } else {
                    baseExcelData
                }

            bufferedFileWriter.apply {
                write(processedData.toCsvData())
                newLine()
            }

        }
        bufferedFileWriter.flush()
        bufferedFileWriter.close()

    }

    private fun hasLatitudeData(excelData: ExcelRowData): Boolean = excelData.latitude.isNotEmpty()
}