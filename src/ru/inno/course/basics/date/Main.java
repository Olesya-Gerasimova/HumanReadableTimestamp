package ru.inno.course.basics.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        // Настройка логгера для вывода логов в консоль
        Logger logger = Logger.getLogger(HumanReadableTimestampImpl.class.getName());
        ConsoleHandler handler = new ConsoleHandler();
        handler.setLevel(Level.ALL);
        logger.addHandler(handler);
        logger.setLevel(Level.ALL);

        // Создаем объект HumanReadableTimestampImpl
        HumanReadableTimestamp timestampFormatter = new HumanReadableTimestampImpl();

        // Примеры меток времени
        LocalDateTime oneMinuteAgo = LocalDateTime.now().minusMinutes(1);
        LocalDateTime threeHoursAgo = LocalDateTime.now().minusHours(3);
        LocalDateTime yesterday = LocalDateTime.of(LocalDate.now().minusDays(1), LocalTime.now().minusHours(5));
        LocalDateTime fiveDaysAgo = LocalDateTime.now().minusDays(5);

        // Вывод результатов
        System.out.println(timestampFormatter.getTimestamp(oneMinuteAgo));  // ожидается: "опубликовано X минут назад"
        System.out.println(timestampFormatter.getTimestamp(threeHoursAgo)); // ожидается: "опубликовано X часов назад"
        System.out.println(timestampFormatter.getTimestamp(yesterday));     // ожидается: "опубликовано вчера"
        System.out.println(timestampFormatter.getTimestamp(fiveDaysAgo));   // ожидается: "опубликовано X дней назад"
    }
}
