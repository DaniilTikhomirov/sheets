package com.googleSheetsParser.sheets.controllers

import com.googleSheetsParser.sheets.services.GoogleSheetsService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class GoogleSheetsController(private val googleSheetsService: GoogleSheetsService) {

    @GetMapping("/get-data")
    fun getData(
        @RequestParam spreadsheetId: String,
        @RequestParam range: String
    ): List<List<Any>> {
        return googleSheetsService.getSheetData(spreadsheetId, range)
    }
}