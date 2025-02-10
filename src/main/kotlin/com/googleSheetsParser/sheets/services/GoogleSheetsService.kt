package com.googleSheetsParser.sheets.services
import com.google.api.services.sheets.v4.Sheets
import com.google.api.services.sheets.v4.model.ValueRange
import org.springframework.stereotype.Service

@Service
class GoogleSheetsService(private val sheets: Sheets) {

    fun getSheetData(spreadsheetId: String, range: String): List<List<Any>> {
        val response: ValueRange = sheets.spreadsheets().values()
            .get(spreadsheetId, range)
            .execute()

        return response.getValues() ?: emptyList()
    }

}