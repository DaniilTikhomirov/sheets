package com.googleSheetsParser.sheets.controllers

import com.googleSheetsParser.sheets.kafka.KafkaProducer
import com.googleSheetsParser.sheets.services.GoogleSheetsService
import com.googleSheetsParser.sheets.services.MapperSheets
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class GoogleSheetsController(private val googleSheetsService: GoogleSheetsService,
    private val mapperSheets: MapperSheets, private val kafkaProducer: KafkaProducer) {

    @GetMapping("/get-data")
    fun getData(
        @RequestParam spreadsheetId: String,
        @RequestParam range: String
    ): ResponseEntity<HttpStatus> {
        kafkaProducer.send(mapperSheets.map(googleSheetsService.getSheetData(spreadsheetId, range)))
        return ResponseEntity(HttpStatus.OK)


    }
}