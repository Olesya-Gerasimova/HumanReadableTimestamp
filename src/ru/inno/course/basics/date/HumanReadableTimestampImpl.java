package ru.inno.course.basics.date;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HumanReadableTimestampImpl implements HumanReadableTimestamp {

    private static final Logger LOGGER = Logger.getLogger(HumanReadableTimestampImpl.class.getName());

    @Override
    public String getTimestamp(LocalDateTime eventTimestamp) {
        if (eventTimestamp == null) {
            LOGGER.log(Level.SEVERE, "Timestamp cannot be null");
            throw new IllegalArgumentException("Timestamp cannot be null");
        }

        try {
            LocalDateTime now = LocalDateTime.now();
            Duration duration = Duration.between(eventTimestamp, now);

            long days = duration.toDays();
            if (days == 1) {
                return "опубликовано вчера";
            } else if (days > 1) {
                return "опубликовано " + days + " " + getDayWordForm(days) + " назад";
            }

            long hours = duration.toHours();
            if (hours == 1 || hours == 21) {
                return "опубликовано " + hours + " час назад";
            } else if (hours > 1 && (hours % 10 == 2 || hours % 10 == 3 || hours % 10 == 4)) {
                return "опубликовано " + hours + " часа назад";
            } else if (hours > 0) {
                return "опубликовано " + hours + " часов назад";
            }

            long minutes = duration.toMinutes();
            if (minutes == 1 || (minutes > 20 && minutes % 10 == 1)) {
                return "опубликовано " + minutes + " минуту назад";
            } else if (minutes > 1 && (minutes % 10 == 2 || minutes % 10 == 3 || minutes % 10 == 4)) {
                return "опубликовано " + minutes + " минуты назад";
            } else {
                return "опубликовано " + minutes + " минут назад";
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error calculating timestamp", e);
            throw e;
        }
    }

    private String getDayWordForm(long days) {
        if (days == 1 || days % 10 == 1 && days != 11) {
            return "день";
        } else if ((days % 10 == 2 || days % 10 == 3 || days % 10 == 4) && (days < 10 || days > 20)) {
            return "дня";
        } else {
            return "дней";
        }
    }
}
