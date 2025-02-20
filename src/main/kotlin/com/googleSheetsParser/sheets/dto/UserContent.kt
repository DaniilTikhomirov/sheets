package com.googleSheetsParser.sheets.dto


class UserContent {
    var firstName: String? = null
    var lastName: String? = null
    var content: String? = null

    override fun toString(): String {
        return "UserContent(firstName=$firstName, lastName=$lastName, content=$content)"
    }


}
