package Test;

import java.time.YearMonth;

public class DateTest {

	public static void main(String[] args) {
		YearMonth y = YearMonth.now();
		if(y.getMonthValue() > 10)
			System.out.println(y.getYear() + "" + y.getMonthValue());
		else{
			String yearmo = y.getYear() + "0" + y.getMonthValue();
			Long yearmoL = Long.parseLong(yearmo);
			System.out.println(yearmoL);
		}
			
	}

}
