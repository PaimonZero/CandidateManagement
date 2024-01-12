package View;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Validation {

    public static final Scanner sc = new Scanner(System.in);
    public static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public static Date checkBirthDay() {
        while (true) {
            String result = getString(">Enter birth year (dd/MM/yyyy): ");

            Date birthDay;
            try {
                birthDay = dateFormat.parse(result);
                Date currentDay = new Date();

                if (birthDay.before(currentDay) && !birthDay.equals(currentDay) && birthDay.after(new Date(1900))) {
                    return birthDay;
                } else {
                    System.err.println("Invalid input. Birth year cannot be in the future (or before 1900)");
                }
            } catch (ParseException ex) {
                System.err.println("Invalid input. Please enter a valid birth year in the format dd/MM/yyyy.");
            }
        }
    }
    
    public static Date checkDate(String msg, String pattern, Date birth) { //for graduation
        SimpleDateFormat dateF = new SimpleDateFormat(pattern);
        while (true) {
            String dateStr = getString(msg);

            Date date;
            try {
                date = dateF.parse(dateStr);
                Date currentDay = new Date();

                if (date.after(birth) && date.before(currentDay) ) {
                    return date;
                } else {
                    System.err.println("Invalid input. Date cannot be in the future.");
                }
            } catch (ParseException ex) {
                System.err.println("Invalid input. Please enter a valid date in the format " + pattern);
            }
        }
    }

//    public static String checkGraduationTime(String inputMsg) {
//        while (true) {
//            System.out.print(inputMsg);
//            String result = sc.nextLine().trim();
//            String regex = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])$";
//            if (result.matches(regex)) {
//                return result;
//            } else {
//                System.err.println("Invalid input. Please enter a valid Graduation time with format is(dd/MM).");
//            }
//        }
//    }

    public static String checkPhone(String inputMsg) {
        while (true) {
            System.out.print(inputMsg);
            String result = sc.nextLine().trim();
            String regex = "^[0-9]{10,}$";
            if (result.matches(regex)) {
                return result;
            } else {
                System.err.println("Invalid input. Please enter a valid phone number is number with minimum 10 characters.");
            }
        }
    }

    public static String checkEmail(String inputMsg) {
        while (true) {
            System.out.print(inputMsg);
            String result = sc.nextLine().trim();
            String regex = "^[A-Za-z0-9.+-_%]+@[A-Za-z.-]+\\.[A-Za-z]{2,4}$";
            if (result.matches(regex)) {
                return result;
            } else {
                System.err.println("Invalid input. Please enter a valid email with format <account name>@<domain>.<Top-level Domains>. ");
            }
        }
    }

    public static String getString(String inputMsg) {
        String result;
        do{
            try {
                System.out.print(inputMsg);
                result = sc.nextLine().trim();
                if(result.isEmpty() == true) {
                    System.out.println(">>You input nothing?");
                } else { return result; }
            } catch (Exception e) {
                System.err.println("Pls enter again!");
            }
        } while (true);
    }
    
    public static int inputIntMinMax(String inputMsg, int min, int max) {
        if (min > max) {
            int t = min;    min = max;    max = t;
        }
        int data;
        do{
            System.out.print(inputMsg);
            data = Integer.parseInt(sc.nextLine());
        }
        while (data < min || data > max);
        return data;
    }

    public static boolean checkInputYN(String inputMsg) {
        while (true) {
            try {
                String result = getString(inputMsg);
                if (result.equalsIgnoreCase("Y")) {
                    return true;
                } else if (result.equalsIgnoreCase("N")) {
                    return false;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Please input y/Y or n/N.");
            }
        }
    }
    
    public static String checkInputName(String inputMsg) {
        //loop until user input correct
        while (true) {
            System.out.print(inputMsg);
            String result = sc.nextLine().trim();
            String regex = "^[a-zA-Z\\s'-]+$";
            if (result.matches(regex)) {
                result = result.substring(0, 1).toUpperCase() + result.substring(1).toLowerCase();
                return result;
            } else {
                System.err.println("Invalid input. Please enter a valid name without number.");
            }
        }
    }
    
    public static int checkExperienceYear(String msg, Date birthDate) {
        String birthTemp = birthDate.toString();    //vd: Thu Jan 22 00:00:00 ICT 2004
        String[] timeTemp = birthTemp.split(" ");       // Thu Jan 22 00:00:00 ICT 2004 >>>> timeTemp[5] = year
        
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int birth = Integer.parseInt(timeTemp[5]);
        int age = currentYear - birth;
        while (true) {
            System.out.print(msg);
            String result = sc.nextLine().trim();
            String regex = "^[0-9]{0,100}$";
            int intResult = Integer.parseInt(result);
            
            if (result.matches(regex) && intResult < age) {
                return intResult;
            } else {
                System.out.println("Invalid input. Please enter a valid Year of Experience is number from 0 to 100 and must be smaller than age.");
            }
        }
    }

}
