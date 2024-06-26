package ru.practicum.mainservice.mapper;

import lombok.experimental.UtilityClass;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@UtilityClass
public class DateTimeMapper {

    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static String fromLocalDateTime(LocalDateTime localDateTime) {
        return localDateTime.format(FORMATTER);
    }
}
