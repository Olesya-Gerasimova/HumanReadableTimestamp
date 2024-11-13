package ru.inno.course.basics.date;

import java.time.LocalDateTime;

public interface HumanReadableTimestamp {
    String getTimestamp(LocalDateTime eventTimestamp);
}
