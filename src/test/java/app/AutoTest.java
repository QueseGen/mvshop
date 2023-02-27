package app;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class AutoTest {
  public static String getTimeStamp(){
    LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE MMMM dd, yyyy h:mma", Locale.US);
    String formattedDateTime = now.format(formatter);
    return "Current TimeStamp: " + formattedDateTime;
  }
}


