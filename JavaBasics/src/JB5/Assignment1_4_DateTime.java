/**
 * 
 */
package JB5;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Year;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.TemporalAdjusters;

/**
 * @author Arbaaz Khan
 *	This file will contain a lot of text which to answer all of the questions that are posed in this section. This file is a java file because some questions will be ask for code as well. 
 */
public class Assignment1_4_DateTime {

	public static void main(String[] args) {
//1.	Which class would you use to store your birthday in years, months, days, seconds, and nanoseconds?
	// YOu would most likely store it in a LocalDateTime class

	
	

		//2.	 Given a random date, how would you find the date of the previous Thursday?
	// You would use the previous method from a TemporalAdjuster
		LocalDate day = LocalDate.now();
		LocalDate thurs = day.with(TemporalAdjusters.previous(DayOfWeek.THURSDAY));
		
		
//3.	 What is the difference between a ZoneId and a ZoneOffset?
		//They both track the offset of UTC time. However ZoneOffset tracks only the absolute offset of UTC
		
				
		
//4.	 How would you convert an Instant to a ZonedDateTime? How would you convert a ZonedDateTime to an Instant?
		//You can convert an Instant to a ZonedDateTime by using the Instant.atZone method.
		ZonedDateTime zdt = Instant.now().atZone(ZoneId.systemDefault());
		//You can use the toInstant method in the ChronoZonedDateTime interface, implemented by the ZonedDateTime class, to convert from a ZonedDateTime to an Instant
		Instant inst = ZonedDateTime.now().toInstant();
		
		
		
//5.	 Write an example that, for a given year, reports the length of each month within that year.
        System.out.println("Example of how to find the length of each month");
		int year = 2021;
        for (Month month : Month.values()) {
            YearMonth ym = YearMonth.of(year, month);
            System.out.printf("%s: %d days%n", month, ym.lengthOfMonth());
        }
        System.out.println();
		
		
//6.	 Write an example that, for a given month of the current year, lists all of the Mondays in that month.
        System.out.println("Exmaple of finding all the Mondays in a given month");
        Month month = Month.OCTOBER;
        LocalDate date = Year.now().atMonth(month).atDay(1).
                with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));
          Month mi = date.getMonth();
          while (mi == month) {
              System.out.printf("%s%n", date);
              date = date.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
              mi = date.getMonth();
          }
          System.out.println();
        
        
//7.	 Write an example that tests whether a given date occurs on Friday the 13th.
          System.out.println("Exmaple to find if a given Friday is on the 13th");
          LocalDate f13 = Year.of(2020).atMonth(Month.NOVEMBER).atDay(13);  
          LocalDate f = Year.of(2021).atMonth(Month.NOVEMBER).atDay(13);
          DayOfWeek Fri = DayOfWeek.FRIDAY;
          if(f13.getDayOfWeek() == Fri) {
              System.out.println("This day is a Friday: "+f13);
          }
          else {
              System.out.println("This day is not a Friday: "+f13);
          }

	}
}
