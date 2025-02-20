package com.googleSheetsParser.sheets

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.kafka.annotation.EnableKafka

@EnableKafka
@SpringBootApplication
class SheetsApplication

fun main(args: Array<String>) {
	runApplication<SheetsApplication>(*args)
}
