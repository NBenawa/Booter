package org.example.booter.aspects;

import org.example.booter.entity.Guest;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class LoggerWriter {
    private static final String path = "log.txt";

    public static void writeLog(Guest guest, String string, LocalDateTime localDateTime) {
        try (FileWriter writer = new FileWriter(path, true)) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            writer.write(localDateTime.format(dtf) + "\t" + string + " {" + guest.getFirstName() + " " + guest.getLastName() + " - " + guest.getEmailAddress() + "} " + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
