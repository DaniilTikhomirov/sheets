package com.googleSheetsParser.sheets.config
import com.google.api.client.util.Value
import com.google.api.services.sheets.v4.Sheets
import com.google.auth.http.HttpCredentialsAdapter
import com.google.auth.oauth2.GoogleCredentials
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.io.FileInputStream

@Configuration
class ClientConfig {

    @Value("\${google.sheets.scope}")
    private lateinit var scopeLink: String
    @Value("\${google.sheets.json}")
    private lateinit var json: String

    @Bean
    fun getGoogleCredentials(): GoogleCredentials {
        return FileInputStream(json).use { inputStream ->
            GoogleCredentials.fromStream(inputStream)
                .createScoped(setOf(scopeLink))
        }
    }

    @Bean
    fun sheetsService(credentials: GoogleCredentials): Sheets {
        return Sheets.Builder(
            com.google.api.client.http.javanet.NetHttpTransport(),
            com.google.api.client.json.gson.GsonFactory.getDefaultInstance(),
            HttpCredentialsAdapter(credentials)
        ).setApplicationName("My Google Sheets App").build()
    }

}