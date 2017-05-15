import com.sun.xml.internal.ws.util.StringUtils;

import java.util.Scanner;

public class UserInput {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Integer number = null;
    String input;

    while(number == null)
    {
      System.out.print("Please input a number: " );
      input = scanner.nextLine();
      try
      {
        number = Integer.parseInt(input);
      }
      catch (NumberFormatException ex)
      {
        System.out.println("Enter a valid integer...");
        continue;
      }
      catch (Exception ex)
      {
        //According to https://docs.oracle.com/javase/7/docs/api/java/lang/Integer.html
        //the only exception thrown is NumberFormatException
        //But I add this "general"-catch block always in my code - u never know :^}
        System.out.println("Dunno, something bad happened: " + ex.getMessage());
        return;
      }
    }

    scanner.close();
    System.out.println("x = " + number);
    System.out.println("x² = " + (number * number));
  }
}
