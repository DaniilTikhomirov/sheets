package com.googleSheetsParser.sheets.dto


class HomeWorkContent {
    var title: String? = null
    var users: List<UserContent> = ArrayList()


    override fun toString(): String {
        return "HomeWorkContent(title=$title, users=${users.toString()})"
    }


}
