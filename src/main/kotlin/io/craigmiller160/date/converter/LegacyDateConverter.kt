package io.craigmiller160.date.converter

import java.time.LocalDateTime
import java.time.ZoneId
import java.util.Date

class LegacyDateConverter {

    fun convertLocalDateTimeToDate(localDateTime: LocalDateTime): Date {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant())
    }

    fun convertDateToLocalDateTime(date: Date): LocalDateTime {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault())
    }

}
