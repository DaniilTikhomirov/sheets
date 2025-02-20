package com.googleSheetsParser.sheets.services

import com.googleSheetsParser.sheets.dto.HomeWorkContent
import com.googleSheetsParser.sheets.dto.UserContent
import org.springframework.stereotype.Service

@Service
class MapperSheets {

    fun map(dataAny: List<List<Any>>): List<HomeWorkContent> {
        val data: List<List<String>> = dataAny.map { innerList -> innerList.map { it.toString() } }
        val listHomework: MutableList<HomeWorkContent> = mutableListOf()

        for (row in data.indices) {
            val name = data[row][0].split(" ")

            for (column in 1..<data[row].size) {
                val title = data[0][column]
                val homeWorkContent: HomeWorkContent

                if (row == 0) {
                    homeWorkContent = HomeWorkContent()
                    homeWorkContent.title = title
                    listHomework.add(homeWorkContent)
                    continue
                }

                if (column - 1 >= listHomework.size) {
                    homeWorkContent = HomeWorkContent()
                    homeWorkContent.title = title
                    listHomework.add(homeWorkContent)
                } else {
                    homeWorkContent = listHomework[column - 1]
                }

                val content: String = data[row][column]
                val userContent = UserContent().apply {
                    this.content = content
                    this.firstName = name.getOrNull(1) ?: ""
                    this.lastName = name.getOrNull(0) ?: ""
                }

                homeWorkContent.users = homeWorkContent.users.toMutableList().apply {
                    add(userContent)
                }

                listHomework[column - 1] = homeWorkContent
            }
        }

        return listHomework
    }

}