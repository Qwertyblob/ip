import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateTimeManager {
    private static final DateTimeFormatter DATE_ONLY = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private static final DateTimeFormatter DATE_TIME_12H = DateTimeFormatter.ofPattern("dd-MM-yyyy h:mma");
    private static final DateTimeFormatter DISPLAY_DATE = DateTimeFormatter.ofPattern("d MMM yy");
    private static final DateTimeFormatter DISPLAY_DATE_TIME = DateTimeFormatter.ofPattern("d MMM yy h:mma");

    public static LocalDateTime parse(String input) {
        try {
            return LocalDateTime.parse(input.toUpperCase(), DATE_TIME_12H);
        } catch (DateTimeParseException e) {
            LocalDate date = LocalDate.parse(input, DATE_ONLY);
            return date.atStartOfDay();
        }
    }

    public static String format(LocalDateTime dateTime) {
        if (dateTime.toLocalTime().equals(java.time.LocalTime.MIDNIGHT)) {
            return dateTime.toLocalDate().format(DATE_ONLY);
        } else {
            return dateTime.format(DATE_TIME_12H);
        }
    }

    public static String formatForDisplay(LocalDateTime dateTime) {
        if (dateTime.toLocalTime().equals(java.time.LocalTime.MIDNIGHT)) {
            return dateTime.format(DISPLAY_DATE);
        } else {
            return dateTime.format(DISPLAY_DATE_TIME);
        }
    }
}
