package com.googleSheetsParser.sheets.kafka

import org.apache.kafka.clients.admin.NewTopic
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class KafkaConfig {

    @Bean
    fun newTopic() : NewTopic {
        return NewTopic("sheets-parser", 1, 1)
    }
}