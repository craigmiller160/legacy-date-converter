/*
 * legacy-date-converter
 * Copyright (C) 2020 Craig Miller
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package io.craigmiller160.date.converter

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.ZonedDateTime
import java.util.Date

class LegacyDateConverterTest {

    private val legacyDateConverter = LegacyDateConverter()

    @Test
    fun test_convertLocalDateTimeToDate() {
        val localDateTime = LocalDateTime.of(2019, 1, 1, 1, 1)
        val format = SimpleDateFormat("yyyy-MM-dd HH:mm")
        val date = legacyDateConverter.convertLocalDateTimeToDate(localDateTime)
        assertEquals("2019-01-01 01:01", format.format(date))
    }

    @Test
    fun test_convertDateToLocalDateTime() {
        val date = Date(119, 0, 1, 1, 1)
        val localDateTime = legacyDateConverter.convertDateToLocalDateTime(date)
        val expected = LocalDateTime.of(2019, 1, 1, 1, 1)
        assertEquals(expected, localDateTime)
    }

    @Test
    fun test_convertZonedDateTimeToDate() {
        val zdt = ZonedDateTime.of(LocalDateTime.of(2019, 1, 1, 1, 1), ZoneId.systemDefault())
        val expected = Date(119, 0, 1, 1, 1)
        val actual = legacyDateConverter.convertZonedDateTimeToDate(zdt)
        assertEquals(expected, actual)
    }

    @Test
    fun test_convertDateToZonedDateTime() {
        val date = Date(119, 0, 1, 1, 1)
        val expected = ZonedDateTime.of(LocalDateTime.of(2019, 1, 1, 1, 1), ZoneId.systemDefault())
        val actual = legacyDateConverter.convertDateToZonedDateTime(date, ZoneId.systemDefault())
        assertEquals(expected, actual)
    }

}
