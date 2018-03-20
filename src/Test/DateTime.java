package Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateTime {
public static void main(String[] args) {
	System.out.println(addOneDay("03/31/2018 00:00:00"));
}

static public String addOneDay(String date) {
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
	LocalDate tomorrow = LocalDate.parse(date, formatter).plusDays(1);
    return tomorrow.format(formatter);
  }

}
