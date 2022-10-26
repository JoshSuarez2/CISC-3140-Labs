import java.util.Scanner;
import java.util.ArrayList;
import java.time.temporal.ChronoUnit;
import java.util.regex.Pattern;
import java.time.LocalDate;



public class Lab2Java {
    //dates that represent the assignment due dates
    public static LocalDate lab1 = LocalDate.of(2022,9,27);
    public static LocalDate lab2 = LocalDate.of(2022,10,26);
    public static LocalDate lab3 = LocalDate.of(2022,11,23);
    public static LocalDate lab4 = LocalDate.of(2022,12,7);
   
    //returns the days between two dates
    public static long getDaysBetween(LocalDate from, LocalDate to){
        return from.until(to, ChronoUnit.DAYS);
    }


    public static void main(String[] args){
        //get the current date
        LocalDate currDate = LocalDate.now();
        Scanner scan = new Scanner(System.in);//scanner for reading in input
        System.out.println("For days between all labs type A, or for specific dates type B");
        while(scan.hasNext()){
            String keyboard = scan.next();
            if(keyboard.equals("A")){
                System.out.println("There are " + getDaysBetween(currDate,lab1) + " day(s) until lab 1 is due");
                System.out.println("There are " + getDaysBetween(currDate,lab2) + " day(s) until lab 2 is due");
                System.out.println("There are " + getDaysBetween(currDate,lab3) + " day(s) until lab 3 is due");
                System.out.println("There are " + getDaysBetween(currDate,lab4) + " day(s) until lab 4 is due");
            }
            else if(keyboard.equals("B")){
                System.out.println("Enter specific date in either MM/DD/YYYY or MM-DD. In case of using only month and date, the year will default to the following");
                String specificDate = scan.next();
		    //regular expression to find dates listed in MM/DD/YYYY
                Pattern pattern1 = Pattern.compile("^[0-9]{1,2}\\/[0-9]{1,2}\\/[0-9]{4}$");
		    //regular expression to find dates listed in MM-DD
                Pattern pattern2 = Pattern.compile("^[0-9]{1,2}\\-[0-9]{1,2}$");
                if(pattern1.matcher(specificDate).find()) {
                    String[] parsedDate = specificDate.split("/");
                    LocalDate newDate = LocalDate.of(Integer.parseInt(parsedDate[2]),Integer.parseInt(parsedDate[0]),Integer.parseInt(parsedDate[1]));
                    System.out.println("There are "+getDaysBetween(date,newDate) + " day(s) until your custom date");
                }
                else if(pattern2.matcher(customDate).find()){
                    String[] parsedDate = specificDate.split("-");
			  //creates a new localdate object with a year of the current year plus 1
                    LocalDate newDate = LocalDate.of(date.getYear()+1,Integer.parseInt(parsedDate[0]),Integer.parseInt(parsedDate[1]));
                    System.out.println("There are "+getDaysBetween(date, newDate) + " day(s) until your custom date");
                }
                else {
                    System.out.println("Error, try entering the dates in the correct format");
                    specificDate = scan.next();
                }
                
            }
            System.out.println("For days between all labs type A, or for specific dates type B");
        }
        scan.close();


    }
}