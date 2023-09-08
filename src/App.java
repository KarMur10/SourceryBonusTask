import java.text.ParseException;
import java.text.SimpleDateFormat;

public class App {
    public static void main(String[] args) throws Exception {
        printBonusDatesBetween(0, 9999);
    }

    public static void printBonusDatesBetween(int fromYear, int toYear) {
        if (fromYear < 1) {
            System.out.println("Note: 1st given year is below 1, counting will begin with year 1");
            fromYear = 1;
        }

        int attemptCount = toYear - fromYear;
        if (attemptCount <= 0) {
            System.out.println("latter given year should be greater than former");
            return;
        }

        for(int i = 0; i <= attemptCount; i++) {
            int attemptYear = fromYear + i;
            
            String attemptYearStr = String.valueOf(attemptYear);  

            if(attemptYearStr.length() < 4) {
                printAllBonusDatesOfABelow4DigitYear(attemptYearStr);
            } else {
                if(attemptYearStr.length() > 5) {
                    if (!isPalindrome(attemptYearStr.substring(4))) {
                        continue;
                    }
                }

                String attemptDate = createPalindromeDate(attemptYearStr);

                printDateIfValid(attemptDate);
            }
        }
    }

    private static String createPalindromeDate(String year) {
        String fullDate = "";

        char[] yearArr = year.toCharArray();

        for (int i = 0; i < 4; i++) {
            fullDate = yearArr[i] + fullDate;
        }

        fullDate = year + fullDate;

        return fullDate;
    }
    
    private static boolean isDateValid(String input) {
        String formatString = "yyyy-MM-dd";
    
        try {
            SimpleDateFormat format = new SimpleDateFormat(formatString);
            format.setLenient(false);            
            format.parse(input);
        } catch (ParseException | IllegalArgumentException e) {
            return false;
        }
        return true;
    }

    private static boolean isPalindrome(String string) {
        int n = string.length();
        
        for (int i = 0; i < (n / 2); i++) {
            if (string.charAt(i) != string.charAt(n - i - 1)) {
                return false;
            }
        }

        return true;
    }

    private static void printAllBonusDatesOfABelow4DigitYear(String year) {
        String dateStr = "";

        if (year.length() == 2) {
            dateStr = year + "11" + new StringBuilder(year).reverse().toString();

            printDateIfValid(dateStr);
        } else {
            for (int monthDayDigit1 = 0; monthDayDigit1 < 2; monthDayDigit1++) {
                if (year.length() == 1) {
                    for (int monthDigit2 = 0; monthDigit2 < 3; monthDigit2++) {
                        dateStr = year + monthDayDigit1 + monthDigit2 + monthDayDigit1 + year;

                        printDateIfValid(dateStr);
                    }
                } else if (year.length() == 3) {
                    dateStr = year + monthDayDigit1 + new StringBuilder(year).reverse().toString();

                    printDateIfValid(dateStr);
                }
            }
        }
    }

    private static String toDateFormat(String input) {
        return input.substring(0, input.length() - 4) + 
        "-" + input.substring(input.length() - 4, input.length() - 2) +
        "-" + input.substring(input.length() - 2);
    }

    private static void printDateIfValid(String date) {
        date = toDateFormat(date);

        if(isDateValid(date)) {
            System.out.println(date);
        }
    }
}