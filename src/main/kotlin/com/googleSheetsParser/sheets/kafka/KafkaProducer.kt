package com.googleSheetsParser.sheets.kafka

import com.google.gson.Gson
import com.googleSheetsParser.sheets.dto.HomeWorkContent
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service


@Service
class KafkaProducer(private val kafkaTemplate: KafkaTemplate<String, String>) {
    private val gson = Gson()

    fun send(homeWorkContent: List<HomeWorkContent>) {
        val jsonString = gson.toJson(homeWorkContent)
        kafkaTemplate.send("sheets-parser", jsonString)
    }
}