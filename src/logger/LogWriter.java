package logger;

import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class LogWriter {
    public void writeOperation(String num1, String num2, String command, String answer) {
        String pattern = "dd/MM/yyyy HH:mm:ss";
        DateFormat df = new SimpleDateFormat(pattern);
        Date now = Calendar.getInstance().getTime();
        String nowAsString = df.format(now);
        String lineForLog = String.format("Date: %s, Command: %s, Num1: %s, Num2: %s, Answer: %s\n",
                nowAsString, command, num1, num2, answer);
        try (FileWriter writer = new FileWriter("log.txt", true)) {
            writer.write(lineForLog);
            writer.write("\n");
            writer.flush();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void writeException(String exception) {
        String pattern = "dd/MM/yyyy HH:mm:ss";
        DateFormat df = new SimpleDateFormat(pattern);
        Date now = Calendar.getInstance().getTime();
        String nowAsString = df.format(now);
        String lineForLog = String.format("Date: %s, Exception: %s\n",
                nowAsString, exception);
        try (FileWriter writer = new FileWriter("log.txt", true)) {
            writer.write(lineForLog);
            writer.write("\n");
            writer.flush();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
